package com.sadb.transformation.mysql;


import com.sadb.generated.dest.oracle.tables.records.*;
import com.sadb.generated.source.postgres.tables.records.SrcPgsDisciplineRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsResultsRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsSudentRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsTeacherRecord;
import com.sadb.transformation.ConnectionManager;
import org.jooq.*;
//import org.jooq.Statement;
import org.jooq.impl.DSL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.sadb.generated.dest.oracle.Tables.*;
import static com.sadb.generated.dest.oracle.tables.Discipline.DISCIPLINE;
import static com.sadb.generated.source.postgres.Tables.SRC_PGS_RESULTS;
import static com.sadb.generated.source.postgres.Tables.SRC_PGS_SUDENT;
import static com.sadb.generated.source.postgres.Tables.SRC_PGS_TEACHER;
import static com.sadb.generated.source.postgres.tables.SrcPgsDiscipline.SRC_PGS_DISCIPLINE;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class MysqlMigrationService {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = System.getenv("aws_mysql_url");
    private static final String USER = System.getenv("aws_mysql_user");
    private static final String PASSWORD = System.getenv("aws_mysql_password");
   private static Statement stmt;
    private static ResultSet rs;

    @Scheduled(fixedDelayString = "#{ 70 * 1000}")
    public void process() throws ClassNotFoundException, SQLException {

        List<TableRecord<?>> toInsert = new ArrayList<>();
        List<UpdatableRecord<?>> toUpdate = new ArrayList<>();
        String query = "select count(*) from books";

        // Connect to Mysql
//        Class.forName(JDBC_DRIVER);

        Connection connectionMysql = getSourceMysqlConnection();

        // Connect to Oracle
        Connection connectionOracle = ConnectionManager.getDestDBConnection();

        // Create context
        DSLContext contextPostgres = DSL.using(connectionMysql, SQLDialect.POSTGRES);
        DSLContext contextOracle = DSL.using(connectionOracle, SQLDialect.ORACLE);


        // getting Statement object to execute query
        stmt = connectionMysql.createStatement();

        // executing SELECT query
        rs = stmt.executeQuery(query);

        while (rs.next()) {
            int count = rs.getInt(1);
            System.out.println("Total number of books in the table : " + count);
        }
    }

    private Connection getSourceMysqlConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}



