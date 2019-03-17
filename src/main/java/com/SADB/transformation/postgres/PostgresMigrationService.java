package com.sadb.transformation.postgres;


import com.sadb.generated.dest.oracle.tables.records.DisciplineRecord;
import com.sadb.transformation.ConnectionManager;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

import static com.sadb.generated.dest.oracle.tables.Discipline.DISCIPLINE;

@Service
public class PostgresMigrationService {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";

    private static final String URL = System.getenv("aws_postgres_url");
    private static final String USER = System.getenv("aws_postgres_user");
    private static final String PASSWORD = System.getenv("aws_postgres_password");

    @Scheduled(fixedDelayString = "#{ ${postrgres.shedule.interval.seconds} * 1000}")
    public void process() throws ClassNotFoundException {

        // Region Extraction


        Class.forName(JDBC_DRIVER);

        Connection connectionPostgres = null;
        try {
            connectionPostgres = ConnectionManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            return;
        }

        DSLContext contextPostgres = DSL.using(connectionPostgres, SQLDialect.POSTGRES);


        Result<DisciplineRecord> disciplines = contextPostgres.select().from(DISCIPLINE).fetch().into(DISCIPLINE);


        // End region





        // Region Transformation


        for (Record r : disciplines) {
            Integer id = r.getValue(DISCIPLINE.DISCIPLINE_ID);
            String name = r.getValue(DISCIPLINE.DISCIPLINE_NAME);

            System.out.println("ID: " + id + " name: " + name);
        }


        for (DisciplineRecord disciplineRecord : disciplines) {
            disciplineRecord.changed(true);
        }


        // End region




        // Region Load

        // TODO logic for checking updation time in result table

        Connection connectionOracle = null;
        try {
            connectionOracle = ConnectionManager.getDestDBConnection();
        } catch (SQLException e) {
            return;
        }

        DSLContext contextOracle = DSL.using(connectionOracle, SQLDialect.ORACLE);

        contextOracle.batchInsert(disciplines).execute();

        // End region

    }
}
