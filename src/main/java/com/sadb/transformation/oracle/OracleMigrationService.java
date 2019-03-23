package com.sadb.transformation.oracle;

import com.sadb.generated.source.oracle.tables.Lecturer;
import com.sadb.generated.source.oracle.tables.Megafaculty;
import com.sadb.generated.source.oracle.tables.records.LecturerRecord;
import com.sadb.generated.source.oracle.tables.records.MegafacultyRecord;
import com.sadb.transformation.ConnectionManager;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OracleMigrationService {
    private static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";

    //    private static final String URL = System.getenv("aws_oracle_url");
//    private static final String USER = System.getenv("aws_oracle_user");
//    private static final String PASSWORD = System.getenv("aws_oracle_password");
    private static final String URL = "jdbc:oracle:thin:@mydboraclinstance.c2wx7dijsbls.eu-west-3.rds.amazonaws.com:1521:ORCLDB";
    private static final String USER = "USER1";
    private static final String PASSWORD = "KMuZgdy4gbTDPps";

    @Scheduled(fixedDelayString = "#{ 60 * 1000}")
    public void process() throws ClassNotFoundException, SQLException {
        List<TableRecord<?>> toInsert = new ArrayList<>();
        List<UpdatableRecord<?>> toUpdate = new ArrayList<>();

        // Connect to OracleDB
        Class.forName(JDBC_DRIVER);
        Connection connectionSourceOracle = getSourceOracleConnection();

        // Connect to Oracle
        Connection connectionOracle = ConnectionManager.getDestDBConnection();

        // Create context
        DSLContext contextSourceOracle = DSL.using(connectionSourceOracle, SQLDialect.ORACLE);
        DSLContext contextOracle = DSL.using(connectionOracle, SQLDialect.ORACLE);

////        MEGAFACULTY MEGAFACULTY MEGAFACULTY
//        Result<MegafacultyRecord> oracleSourceMegafaculty =
//                contextSourceOracle.select().from(Megafaculty.MEGAFACULTY).fetch().into(Megafaculty.MEGAFACULTY);
//
//        Result<com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord> oracleMegafaculty =
//                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.Megafaculty.MEGAFACULTY).fetch().into(com.sadb.generated.dest.oracle.tables.Megafaculty.MEGAFACULTY);
//
//        processMegafaculty(
//                oracleSourceMegafaculty,
//                oracleMegafaculty,
//                toInsert,
//                toUpdate
//        );

        // LECTURER LECTURER LECTURER LECTURER LECTURER LECTURER LECTURER
        Result<LecturerRecord> oracleSourceLecturer =
                contextSourceOracle.select().from(Lecturer.LECTURER).fetch().into(Lecturer.LECTURER);

        Result<com.sadb.generated.dest.oracle.tables.records.LecturerRecord> oracleLectures =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.Lecturer.LECTURER).fetch().into(com.sadb.generated.dest.oracle.tables.Lecturer.LECTURER);


        processOracleLecturer(
                oracleSourceLecturer,
                oracleLectures,
                toInsert,
                toUpdate
        );


        if (!toInsert.isEmpty()) {
            contextOracle.batchInsert(toInsert).execute();
        }
        if (!toUpdate.isEmpty()) {
            contextOracle.batchUpdate(toUpdate).execute();
        }

    }

    private void processMegafaculty(
            List<MegafacultyRecord> oracleSourceMegafaculty,
            List<com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord> oracleMegafacultys,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        // Build id -> updateTime map
        Map<Integer, Timestamp> megafacultyIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord> megafacultyIdToRecordMap = new HashMap<>();

        oracleMegafacultys.forEach(oracleMegafaculty -> {
            megafacultyIdToUpdatedDateMap.put(oracleMegafaculty.getMegafacId().intValue(), oracleMegafaculty.getUpdateTime());
            megafacultyIdToRecordMap.put(oracleMegafaculty.getMegafacId().intValue(), oracleMegafaculty);
        });

        for (MegafacultyRecord oracleMegafacultyRecord : oracleSourceMegafaculty) {

            // условие на нулпоинтер
            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleMegafacultyRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = megafacultyIdToUpdatedDateMap.get(oracleMegafacultyRecord.getMegafacId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord oldRecord =
                        megafacultyIdToRecordMap.get(oracleMegafacultyRecord.getMegafacId().intValue());

                com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord megafacultyRecord;

                if (oldRecord == null) {
                    megafacultyRecord = new com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord();
                } else {
                    megafacultyRecord = oldRecord;
                    megafacultyRecord.changed(true);
                }

                megafacultyRecord.setMegafacId(oracleMegafacultyRecord.getMegafacId().longValue());
                megafacultyRecord.setMfacultyName(oracleMegafacultyRecord.getMfacultyName());
                megafacultyRecord.setCreatTime(new Timestamp(oracleMegafacultyRecord.getUpdateTime().getTime()));
                megafacultyRecord.setUpdateTime(oracleSourceRecordUpdateDate);

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(megafacultyRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
                    toUpdate.add(megafacultyRecord);
                }
            }

        }

    }

    private void processOracleLecturer(
            List<LecturerRecord> oracleSourceLecturers,
            List<com.sadb.generated.dest.oracle.tables.records.LecturerRecord> oracleLectures,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> lecturerIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.LecturerRecord> lecturerIdToRecordMap = new HashMap<>();

        oracleLectures.forEach(oracleLecture -> {
            lecturerIdToUpdatedDateMap.put(oracleLecture.getLecId().intValue(), oracleLecture.getUpdateTime());
            lecturerIdToRecordMap.put(oracleLecture.getLecId().intValue(), oracleLecture);
        });

        for (LecturerRecord oracleSourceLecturerRecord : oracleSourceLecturers) {

            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleSourceLecturerRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = lecturerIdToUpdatedDateMap.get(oracleSourceLecturerRecord.getLecId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.LecturerRecord oldRecord = lecturerIdToRecordMap.get(oracleSourceLecturerRecord.getLecId().intValue());

                com.sadb.generated.dest.oracle.tables.records.LecturerRecord lecturerRecord;
                if (oldRecord == null) {
                    lecturerRecord = new com.sadb.generated.dest.oracle.tables.records.LecturerRecord();
                } else {
                    lecturerRecord = oldRecord;
                    lecturerRecord.changed(true);
                }

                lecturerRecord.setLecId(oracleSourceLecturerRecord.getLecId().longValue());
                lecturerRecord.setPatronymicName(oracleSourceLecturerRecord.getPatronymicName());
                lecturerRecord.setFirstName(oracleSourceLecturerRecord.getFirstName());
                lecturerRecord.setSecondName(oracleSourceLecturerRecord.getSecondName());
                lecturerRecord.setPost(oracleSourceLecturerRecord.getPost());
                lecturerRecord.setBirthPlace(oracleSourceLecturerRecord.getBirthPlace());
                if (oracleSourceLecturerRecord.getBirthDate() != null) {
                    lecturerRecord.setBirthDate(new Timestamp(oracleSourceLecturerRecord.getBirthDate().getTime()));
                }
                if (oracleSourceLecturerRecord.getWorkPeriodFrom() != null) {
                    lecturerRecord.setWorkPeriodFrom(new Timestamp(oracleSourceLecturerRecord.getWorkPeriodFrom().getTime()));
                }
                if (oracleSourceLecturerRecord.getWorkPeriodTo() != null) {
                    lecturerRecord.setWorkPeriodTo(new Timestamp(oracleSourceLecturerRecord.getWorkPeriodTo().getTime()));
                }
                lecturerRecord.setUpdateTime(new Timestamp(oracleSourceLecturerRecord.getUpdateTime().getTime()));
                lecturerRecord.setCreatTime(new Timestamp(oracleSourceLecturerRecord.getCreatTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(lecturerRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
                    toUpdate.add(lecturerRecord);
                }
            }

        }

    }

    private Connection getSourceOracleConnection() throws SQLException {
        return ConnectionManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        OracleMigrationService orclMS = new OracleMigrationService();
        try {
            orclMS.process();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
