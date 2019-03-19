package com.sadb.transformation.postgres;


import com.sadb.generated.dest.oracle.tables.records.DisciplineRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsDisciplineRecord;
import com.sadb.transformation.ConnectionManager;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sadb.generated.dest.oracle.tables.Discipline.DISCIPLINE;
import static com.sadb.generated.source.postgres.tables.SrcPgsDiscipline.SRC_PGS_DISCIPLINE;


@Service
public class PostgresMigrationService {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";

    private static final String URL = System.getenv("aws_postgres_url");
    private static final String USER = System.getenv("aws_postgres_user");
    private static final String PASSWORD = System.getenv("aws_postgres_password");

    @Scheduled(fixedDelayString = "#{ 60 * 1000}")
    public void process() throws ClassNotFoundException {

        Class.forName(JDBC_DRIVER);

        Connection connectionPostgres = null;
        try {
            connectionPostgres = ConnectionManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            return;
        }

        Connection connectionOracle = null;
        try {
            connectionOracle = ConnectionManager.getDestDBConnection();
        } catch (SQLException e) {
            return;
        }

        DSLContext contextPostgres = DSL.using(connectionPostgres, SQLDialect.POSTGRES);
        DSLContext contextOracle = DSL.using(connectionOracle, SQLDialect.ORACLE);

        Result<SrcPgsDisciplineRecord> postgresDisciplines =
                contextPostgres.select().from(SRC_PGS_DISCIPLINE).fetch().into(SRC_PGS_DISCIPLINE);

        Result<DisciplineRecord> oracleDisciplines =
                contextOracle.select().from(DISCIPLINE).fetch().into(DISCIPLINE);

        Map<Integer, Timestamp> disciplineIdToUpdatedDateMap = new HashMap<>();

        oracleDisciplines.forEach(oracleDiscipline -> {
            disciplineIdToUpdatedDateMap.put(oracleDiscipline.getDisciplineId(), oracleDiscipline.getUpdateTime());
        });


        List<DisciplineRecord> toInsert = new ArrayList<>();
        List<DisciplineRecord> toUpdate = new ArrayList<>();

        for (SrcPgsDisciplineRecord disciplineRecord : postgresDisciplines) {

            Timestamp postgresRecordUpdateDate = Timestamp.valueOf(disciplineRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
            Timestamp oracleRecordUpdateDate = disciplineIdToUpdatedDateMap.get(disciplineRecord.getDisciplineId().intValue());

            // if oracleRecordUpdateDate == null -> insert new record
            // if oracleUpdateTime after postgresUpdateTime -> Ignore
            // if oracleUpdateTime before postgresUpdateTime -> Update current record
            if (oracleRecordUpdateDate == null || postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {
                disciplineRecord.changed(true);
                DisciplineRecord newRecord = new DisciplineRecord();
                newRecord.setDisciplineId(disciplineRecord.getDisciplineId().toBigInteger().intValue());
                newRecord.setDisciplineName(disciplineRecord.getDisciplineName());
                newRecord.setEducationStandartType(disciplineRecord.getEducationStandartType());
                newRecord.setLabsHoues(disciplineRecord.getLabsHoues());
                newRecord.setLectionsHours(disciplineRecord.getLectionsHours());
                newRecord.setPracticalsHours(disciplineRecord.getPracticalsHours());
                newRecord.setCreatTime(Timestamp.valueOf(disciplineRecord.getCreatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                newRecord.setUpdateTime(postgresRecordUpdateDate);

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(newRecord);
                } else if (postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {
                    toUpdate.add(newRecord);
                }
            }

            if (!toInsert.isEmpty()) {
                contextOracle.batchInsert(toInsert).execute();
            }
            if (!toUpdate.isEmpty()) {
                contextOracle.batchUpdate(toUpdate).execute();
            }

        }


    }
}
