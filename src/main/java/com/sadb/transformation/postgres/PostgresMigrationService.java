package com.sadb.transformation.postgres;


import com.sadb.generated.dest.oracle.tables.records.*;
import com.sadb.generated.source.postgres.tables.records.SrcPgsDisciplineRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsResultsRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsSudentRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsTeacherRecord;
import com.sadb.transformation.ConnectionManager;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.*;

import static com.sadb.generated.dest.oracle.Tables.*;
import static com.sadb.generated.dest.oracle.tables.Discipline.DISCIPLINE;
import static com.sadb.generated.source.postgres.Tables.*;
import static com.sadb.generated.source.postgres.tables.SrcPgsDiscipline.SRC_PGS_DISCIPLINE;


@Service
public class PostgresMigrationService {

    private static final Integer POSTGRES_DB_ID = 2;
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    /*private static final String URL = System.getenv("aws_postgres_url");
    private static final String USER = System.getenv("aws_postgres_user");
    private static final String PASSWORD = System.getenv("aws_postgres_password");
*/
    private static final String URL = "jdbc:postgresql://localhost:5432/dmmi";
    private static final String USER = "dmmi";
    private static final String PASSWORD = "";

    @Scheduled(fixedDelayString = "#{ 60 * 1000}")
    public void process() throws ClassNotFoundException, SQLException {


        Timestamp syncStartTime = new Timestamp(new Date().getTime());


        List<TableRecord<?>> toInsert = new ArrayList<>();
        List<UpdatableRecord<?>> toUpdate = new ArrayList<>();


        // Connect to Postgres
        Class.forName(JDBC_DRIVER);
        Connection connectionPostgres = getSourcePostgresConnection();


        // Connect to Oracle
        Connection connectionOracle = ConnectionManager.getDestDBConnection();


        // Create context
        DSLContext contextPostgres = DSL.using(connectionPostgres, SQLDialect.POSTGRES);
        DSLContext contextOracle = DSL.using(connectionOracle, SQLDialect.ORACLE);


        // Get last sync time

        Result<SyncLogRecord> logRecords = contextOracle
                .select()
                .from(SYNC_LOG)
                .where(SYNC_LOG.DB_TYPE.eq(BigInteger.valueOf(POSTGRES_DB_ID)))
                .orderBy(SYNC_LOG.TIMESTAMP.asc())
                .fetch().into(SYNC_LOG);

        Timestamp lastPostgresSync = logRecords.get(0).getTimestamp();


        // PROCESSING


        // DISCIPLINES DISCIPLINES DISCIPLINES DISCIPLINES DISCIPLINES
        Result<SrcPgsDisciplineRecord> postgresDisciplines =
                contextPostgres
                        .select()
                        .from(SRC_PGS_DISCIPLINE)
                        .where(SRC_PGS_DISCIPLINE.UPDATED_AT.ge(lastPostgresSync.toInstant().atOffset(ZoneOffset.UTC)))
                        .fetch().into(SRC_PGS_DISCIPLINE);

        Result<DisciplineRecord> oracleDisciplines =
                contextOracle.select().from(DISCIPLINE).fetch().into(DISCIPLINE);

        processDisciplines(
                postgresDisciplines,
                oracleDisciplines,
                toInsert,
                toUpdate
        );


        // LECTURER LECTURER LECTURER LECTURER LECTURER LECTURER LECTURER
        Result<SrcPgsTeacherRecord> postgresTeachers =
                contextPostgres
                        .select()
                        .from(SRC_PGS_TEACHER)
                        .where(SRC_PGS_TEACHER.UPDATED_AT.ge(lastPostgresSync.toInstant().atOffset(ZoneOffset.UTC)))
                        .fetch()
                        .into(SRC_PGS_TEACHER);

        Result<LecturerRecord> oracleLectures =
                contextOracle.select().from(LECTURER).fetch().into(LECTURER);


        processTeachers(
                postgresTeachers,
                oracleLectures,
                toInsert,
                toUpdate
        );

        // STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS

        Result<SrcPgsSudentRecord> postgresStudents =
                contextPostgres
                        .select()
                        .from(SRC_PGS_SUDENT)
                        .where(SRC_PGS_SUDENT.UPDATED_AT.ge(lastPostgresSync.toInstant().atOffset(ZoneOffset.UTC)))
                        .fetch().into(SRC_PGS_SUDENT);

        Result<StudentRecord> oracleStudents =
                contextOracle.select().from(STUDENT).fetch().into(STUDENT);

        processStudents(
                postgresStudents,
                oracleStudents,
                toInsert,
                toUpdate
        );

        // RESULTS RESULTS RESULTS RESULTS RESULTS RESULTS RESULTS RESULTS RESULTS
        Result<SrcPgsResultsRecord> postgresResults =
                contextPostgres
                        .select()
                        .from(SRC_PGS_RESULTS)
                        .where(SRC_PGS_RESULTS.UPDATED_AT.ge(lastPostgresSync.toInstant().atOffset(ZoneOffset.UTC)))
                        .fetch().into(SRC_PGS_RESULTS);

        Result<ResultsRecord> oracleResults =
                contextOracle.select().from(RESULTS).fetch().into(RESULTS);


        processResults(
                postgresResults,
                oracleResults,
                toInsert,
                toUpdate
        );


        SyncLogRecord syncLogRecord = new SyncLogRecord();
        syncLogRecord.setDbType(BigInteger.valueOf(POSTGRES_DB_ID));
        syncLogRecord.setTimestamp(syncStartTime);

        toInsert.add(syncLogRecord);


        if (!toInsert.isEmpty()) {
            contextOracle.batchInsert(toInsert).execute();
        }
        if (!toUpdate.isEmpty()) {
            contextOracle.batchUpdate(toUpdate).execute();
        }


    }

    private void processDisciplines(
            List<SrcPgsDisciplineRecord> postgresDisciplines,
            List<DisciplineRecord> oracleDisciplines,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {


        // Build id -> updateTime map
        Map<Integer, Timestamp> disciplineIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, DisciplineRecord> disciplineIdToRecordMap = new HashMap<>();

        oracleDisciplines.forEach(oracleDiscipline -> {
            disciplineIdToUpdatedDateMap.put(oracleDiscipline.getDisciplineId().intValue(), oracleDiscipline.getUpdateTime());
            disciplineIdToRecordMap.put(oracleDiscipline.getDisciplineId().intValue(), oracleDiscipline);
        });


        for (SrcPgsDisciplineRecord postgresDisciplineRecord : postgresDisciplines) {

            Timestamp postgresRecordUpdateDate = Timestamp.valueOf(postgresDisciplineRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
            Timestamp oracleRecordUpdateDate = disciplineIdToUpdatedDateMap.get(postgresDisciplineRecord.getDisciplineId().intValue());

            // if oracleRecordUpdateDate == null -> insert new record
            // if oracleUpdateTime after postgresUpdateTime -> Ignore
            // if oracleUpdateTime before postgresUpdateTime -> Update current record
            if (oracleRecordUpdateDate == null || postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {

                DisciplineRecord oldRecord = disciplineIdToRecordMap.get(postgresDisciplineRecord.getDisciplineId().intValue());

                DisciplineRecord disciplineRecord;
                Mode mode;
                if (oldRecord == null) {
                    disciplineRecord = new DisciplineRecord();
                    disciplineRecord.setDisciplineId(postgresDisciplineRecord.getDisciplineId().longValue());
                    mode = Mode.INSERT;
                } else {
                    disciplineRecord = oldRecord;
                    disciplineRecord.changed(true);
                    mode = Mode.UPDATE;
                }


                if (mode == Mode.INSERT) {
                    disciplineRecord.setDisciplineName(postgresDisciplineRecord.getDisciplineName());
                }

                disciplineRecord.setEducationStandartType(postgresDisciplineRecord.getEducationStandartType());
                disciplineRecord.setLabsHoues(postgresDisciplineRecord.getLabsHoues());
                disciplineRecord.setLectionsHours(postgresDisciplineRecord.getLectionsHours());
                disciplineRecord.setPracticalsHours(postgresDisciplineRecord.getPracticalsHours());
                disciplineRecord.setCreatTime(Timestamp.valueOf(postgresDisciplineRecord.getCreatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                disciplineRecord.setUpdateTime(postgresRecordUpdateDate);

                if (mode == Mode.INSERT) {
                    toInsert.add(disciplineRecord);
                } else {
                    toUpdate.add(disciplineRecord);
                }
            }

        }

    }

    private void processTeachers(
            List<SrcPgsTeacherRecord> postgresTeachers,
            List<LecturerRecord> oracleLectures,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> lecturerIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, LecturerRecord> lecturerIdToRecordMap = new HashMap<>();

        oracleLectures.forEach(oracleLecture -> {
            lecturerIdToUpdatedDateMap.put(oracleLecture.getLecId().intValue(), oracleLecture.getUpdateTime());
            lecturerIdToRecordMap.put(oracleLecture.getLecId().intValue(), oracleLecture);
        });


        for (SrcPgsTeacherRecord postgresTeacherRecord : postgresTeachers) {

            Timestamp postgresRecordUpdateDate = Timestamp.valueOf(postgresTeacherRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
            Timestamp oracleRecordUpdateDate = lecturerIdToUpdatedDateMap.get(postgresTeacherRecord.getId().intValue());

            // if oracleRecordUpdateDate == null -> insert new record
            // if oracleUpdateTime after postgresUpdateTime -> Ignore
            // if oracleUpdateTime before postgresUpdateTime -> Update current record
            if (oracleRecordUpdateDate == null || postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {

                LecturerRecord oldRecord = lecturerIdToRecordMap.get(postgresTeacherRecord.getId().intValue());

                Mode mode;
                LecturerRecord lecturerRecord;
                if (oldRecord == null) {
                    lecturerRecord = new LecturerRecord();
                    lecturerRecord.setLecId(postgresTeacherRecord.getId().longValue());
                    mode = Mode.INSERT;
                } else {
                    lecturerRecord = oldRecord;
                    lecturerRecord.changed(true);
                    mode = Mode.UPDATE;
                }


                if (mode == Mode.INSERT) {
                    String FIO = postgresTeacherRecord.getFio();
                    String[] fioArray = FIO.split(" ");
                    lecturerRecord.setPatronymicName(fioArray[0]);
                    lecturerRecord.setFirstName(fioArray[1]);
                    lecturerRecord.setSecondName(fioArray[2]);
                }


                lecturerRecord.setUpdateTime(Timestamp.valueOf(postgresTeacherRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                lecturerRecord.setCreatTime(Timestamp.valueOf(postgresTeacherRecord.getCreatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));


                if (mode == Mode.INSERT) {
                    toInsert.add(lecturerRecord);
                } else {
                    toUpdate.add(lecturerRecord);
                }
            }
        }
    }

    private void processStudents(
            List<SrcPgsSudentRecord> postgresStudents,
            List<StudentRecord> oracleStudents,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> studentIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, StudentRecord> studentIdToRecordMap = new HashMap<>();

        oracleStudents.forEach(oracleStudent -> {
            studentIdToUpdatedDateMap.put(oracleStudent.getId().intValue(), oracleStudent.getUpdationDate());
            studentIdToRecordMap.put(oracleStudent.getId().intValue(), oracleStudent);
        });


        for (SrcPgsSudentRecord postgresStudentRecord : postgresStudents) {

            Timestamp postgresRecordUpdateDate = Timestamp.valueOf(postgresStudentRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
            Timestamp oracleRecordUpdateDate = studentIdToUpdatedDateMap.get(postgresStudentRecord.getId().intValue());

            // if oracleRecordUpdateDate == null -> insert new record
            // if oracleUpdateTime after postgresUpdateTime -> Ignore
            // if oracleUpdateTime before postgresUpdateTime -> Update current record
            if (oracleRecordUpdateDate == null || postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {


                StudentRecord oldRecord = studentIdToRecordMap.get(postgresStudentRecord.getId().intValue());

                StudentRecord studentRecord;
                Mode mode;
                if (oldRecord == null) {
                    studentRecord = new StudentRecord();
                    studentRecord.setId(postgresStudentRecord.getId());
                    mode = Mode.INSERT;
                } else {
                    studentRecord = oldRecord;
                    studentRecord.changed(true);
                    mode = Mode.UPDATE;
                }


                String FIO = postgresStudentRecord.getFio();
                String[] fioArray = FIO.split(" ");

                studentRecord.setSurname(fioArray[0]);
                studentRecord.setName(fioArray[1]);
                studentRecord.setSecondName(fioArray[2]);
                studentRecord.setUniversity(postgresStudentRecord.getUniversity());
                studentRecord.setEducationPlace(postgresStudentRecord.getEducationPlace());
                studentRecord.setSemester(postgresStudentRecord.getSemester());
                studentRecord.setSpeciality(postgresStudentRecord.getSpeciality());

                if (mode == Mode.UPDATE) {
                    studentRecord.setFormEducation(postgresStudentRecord.getEducationForm());
                }

                studentRecord.setUpdationDate(Timestamp.valueOf(postgresStudentRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                studentRecord.setCreationDate(Timestamp.valueOf(postgresStudentRecord.getCreatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));


                if (mode == Mode.INSERT) {
                    toInsert.add(studentRecord);
                } else {
                    toUpdate.add(studentRecord);
                }
            }

        }


    }

    private void processResults(
            List<SrcPgsResultsRecord> postgresResults,
            List<ResultsRecord> oracleResults,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> resultIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, ResultsRecord> resultIdToRecordMap = new HashMap<>();

        oracleResults.forEach(oracleResult -> {
            resultIdToUpdatedDateMap.put(oracleResult.getResultId().intValue(), oracleResult.getUpdateTime());
            resultIdToRecordMap.put(oracleResult.getResultId().intValue(), oracleResult);
        });


        for (SrcPgsResultsRecord postgresResultRecord : postgresResults) {

            Timestamp postgresRecordUpdateDate = Timestamp.valueOf(postgresResultRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
            Timestamp oracleRecordUpdateDate = resultIdToUpdatedDateMap.get(postgresResultRecord.getResultId().intValue());

            // if oracleRecordUpdateDate == null -> insert new record
            // if oracleUpdateTime after postgresUpdateTime -> Ignore
            // if oracleUpdateTime before postgresUpdateTime -> Update current record
            if (oracleRecordUpdateDate == null || postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {

                ResultsRecord oldRecord = resultIdToRecordMap.get(postgresResultRecord.getResultId().intValue());

                ResultsRecord resultRecord;
                Mode mode;
                if (oldRecord == null) {
                    resultRecord = new ResultsRecord();
                    resultRecord.setResultId(postgresResultRecord.getResultId().longValue());
                    mode = Mode.INSERT;
                } else {
                    resultRecord = oldRecord;
                    resultRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                resultRecord.setStudentId(postgresResultRecord.getStudentId().longValue());
                resultRecord.setDisciplineId(postgresResultRecord.getDisciplineId().longValue());
                if (postgresResultRecord.getResult() != null && postgresResultRecord.getResult() >= 60) {
                    resultRecord.setExType("EXAM");
                } else {
                    resultRecord.setExType("PASS_FAIL_EXAM");
                }
                resultRecord.setResult(postgresResultRecord.getResult().toString());
                resultRecord.setResultDate(new Timestamp(postgresResultRecord.getResultDate().getTime()));
                resultRecord.setTeacherId(postgresResultRecord.getTeacherId().longValue());

                resultRecord.setUpdateTime(Timestamp.valueOf(postgresResultRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                resultRecord.setCreatTime(Timestamp.valueOf(postgresResultRecord.getCreatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));


                if (mode == Mode.INSERT) {
                    toInsert.add(resultRecord);
                } else {
                    toUpdate.add(resultRecord);
                }
            }
        }
    }

    private Connection getSourcePostgresConnection() throws SQLException {
        return ConnectionManager.getConnection(URL, USER, PASSWORD);
    }

    private static enum Mode {
        INSERT, UPDATE
    }
}
