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

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static com.sadb.generated.dest.oracle.Tables.*;
import static com.sadb.generated.dest.oracle.tables.Discipline.DISCIPLINE;
import static com.sadb.generated.source.postgres.Tables.SRC_PGS_RESULTS;
import static com.sadb.generated.source.postgres.Tables.SRC_PGS_SUDENT;
import static com.sadb.generated.source.postgres.Tables.SRC_PGS_TEACHER;
import static com.sadb.generated.source.postgres.tables.SrcPgsDiscipline.SRC_PGS_DISCIPLINE;


@Service
public class PostgresMigrationService {

    private static final Integer POSTGRES_DB_ID = 2;

    private static final String JDBC_DRIVER = "org.postgresql.Driver";

    private static final String URL = System.getenv("aws_postgres_url");
    private static final String USER = System.getenv("aws_postgres_user");
    private static final String PASSWORD = System.getenv("aws_postgres_password");

    @Scheduled(fixedDelayString = "#{ 60 * 1000}")
    public void process() throws ClassNotFoundException, SQLException {

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


        //Timestamp lastPostgresSync = contextOracle.select().from(SYNC_LOG).fetch().into(SYNC_LOG);
        Timestamp DBSyncDate = new Timestamp(new Date().getTime());


        // DISCIPLINES DISCIPLINES DISCIPLINES DISCIPLINES DISCIPLINES
        Result<SrcPgsDisciplineRecord> postgresDisciplines =
                contextPostgres.select().from(SRC_PGS_DISCIPLINE).fetch().into(SRC_PGS_DISCIPLINE);

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
                contextPostgres.select().from(SRC_PGS_TEACHER).fetch().into(SRC_PGS_TEACHER);

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
                contextPostgres.select().from(SRC_PGS_SUDENT).fetch().into(SRC_PGS_SUDENT);

        Result<StudentRecord> oracleStudents =
                contextOracle.select().from(STUDENT).fetch().into(STUDENT);

        Result<FormEducationRecord> oracleEducationForms =
                contextOracle.select().from(FORM_EDUCATION).fetch().into(FORM_EDUCATION);

        processStudents(
                postgresStudents,
                oracleStudents,
                oracleEducationForms,
                toInsert,
                toUpdate
        );

        // RESULTS RESULTS RESULTS RESULTS RESULTS RESULTS RESULTS RESULTS RESULTS
        Result<SrcPgsResultsRecord> postgresResults =
                contextPostgres.select().from(SRC_PGS_RESULTS).fetch().into(SRC_PGS_RESULTS);

        Result<ResultsRecord> oracleResults =
                contextOracle.select().from(RESULTS).fetch().into(RESULTS);


        processResults(
                postgresResults,
                oracleResults,
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
                if (oldRecord == null) {
                    disciplineRecord = new DisciplineRecord();
                } else {
                    disciplineRecord = oldRecord;
                    disciplineRecord.changed(true);
                }



                disciplineRecord.setDisciplineId(postgresDisciplineRecord.getDisciplineId().longValue());
                disciplineRecord.setDisciplineName(postgresDisciplineRecord.getDisciplineName());
                disciplineRecord.setEducationStandartType(postgresDisciplineRecord.getEducationStandartType());
                disciplineRecord.setLabsHoues(postgresDisciplineRecord.getLabsHoues());
                disciplineRecord.setLectionsHours(postgresDisciplineRecord.getLectionsHours());
                disciplineRecord.setPracticalsHours(postgresDisciplineRecord.getPracticalsHours());
                disciplineRecord.setCreatTime(Timestamp.valueOf(postgresDisciplineRecord.getCreatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                disciplineRecord.setUpdateTime(postgresRecordUpdateDate);

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(disciplineRecord);
                } else if (postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {
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

                LecturerRecord lecturerRecord;
                if (oldRecord == null) {
                    lecturerRecord = new LecturerRecord();
                } else {
                    lecturerRecord = oldRecord;
                    lecturerRecord.changed(true);
                }


                String FIO = postgresTeacherRecord.getFio();
                String[] fioArray = FIO.split(" ");

                lecturerRecord.setLecId(postgresTeacherRecord.getId().longValue());
                lecturerRecord.setPatronymicName(fioArray[0]);
                lecturerRecord.setFirstName(fioArray[1]);
                lecturerRecord.setSecondName(fioArray[2]);
                lecturerRecord.setUpdateTime(Timestamp.valueOf(postgresTeacherRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                lecturerRecord.setCreatTime(Timestamp.valueOf(postgresTeacherRecord.getCreatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));


                if (oracleRecordUpdateDate == null) {
                    toInsert.add(lecturerRecord);
                } else if (postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {
                    toUpdate.add(lecturerRecord);
                }
            }

        }


    }

    private void processStudents(
            List<SrcPgsSudentRecord> postgresStudents,
            List<StudentRecord> oracleStudents,
            List<FormEducationRecord> educationForms,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> studentIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, StudentRecord> studentIdToRecordMap = new HashMap<>();

        AtomicReference<Integer> maxId = new AtomicReference<>(1);
        Map<String, Integer> educationFormNameToIdMap = new HashMap<>();

        oracleStudents.forEach(oracleStudent -> {
            studentIdToUpdatedDateMap.put(oracleStudent.getId().intValue(), oracleStudent.getUpdationDate());
            studentIdToRecordMap.put(oracleStudent.getId().intValue(), oracleStudent);
        });

        educationForms.forEach(educationForm -> {
            educationFormNameToIdMap.put(educationForm.getName(), educationForm.getId().intValue());
            if (educationForm.getId() > maxId.get()) {
                maxId.set(educationForm.getId().intValue() + 1);
            }
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
                if (oldRecord == null) {
                    studentRecord = new StudentRecord();
                } else {
                    studentRecord = oldRecord;
                    studentRecord.changed(true);
                }


                String FIO = postgresStudentRecord.getFio();
                String[] fioArray = FIO.split(" ");

                studentRecord.setId(postgresStudentRecord.getId());
                studentRecord.setSurname(fioArray[0]);
                studentRecord.setName(fioArray[1]);
                studentRecord.setSecondName(fioArray[2]);
                studentRecord.setUniversity(postgresStudentRecord.getUniversity());
                studentRecord.setEducationPlace(postgresStudentRecord.getEducationPlace());
                studentRecord.setUpdationDate(Timestamp.valueOf(postgresStudentRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                studentRecord.setCreationDate(Timestamp.valueOf(postgresStudentRecord.getCreatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));

                Integer formId = educationFormNameToIdMap.get(postgresStudentRecord.getEducationForm());
                if (formId == null) {
                    FormEducationRecord record = new FormEducationRecord();
                    record.setId(maxId.get().longValue());
                    record.setName(postgresStudentRecord.getEducationForm());
                    // TODO set dates
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    record.setDateCreate(timestamp);
                    record.setDateUpdate(timestamp);

                    toInsert.add(record);
                }

                studentRecord.setFormEducation(formId.longValue());


                studentRecord.setSemester(postgresStudentRecord.getSemester());
                studentRecord.setSpeciality(postgresStudentRecord.getSpeciality());


                if (oracleRecordUpdateDate == null) {
                    toInsert.add(studentRecord);
                } else if (postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {
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
                if (oldRecord == null) {
                    resultRecord = new ResultsRecord();
                } else {
                    resultRecord = oldRecord;
                    resultRecord.changed(true);
                }

                resultRecord.setResultId(postgresResultRecord.getResultId().longValue());
                resultRecord.setStudentId(postgresResultRecord.getStudentId().longValue());
                resultRecord.setDisciplineId(postgresResultRecord.getDisciplineId().longValue());
                //TODO control form
                resultRecord.setResult(postgresResultRecord.getResult().toString());
                resultRecord.setResultDate(new Timestamp(postgresResultRecord.getResultDate().getTime()));
                resultRecord.setTeacherId(postgresResultRecord.getTeacherId().longValue());

                resultRecord.setUpdateTime(Timestamp.valueOf(postgresResultRecord.getUpdatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                resultRecord.setCreatTime(Timestamp.valueOf(postgresResultRecord.getCreatedAt().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));


                if (oracleRecordUpdateDate == null) {
                    toInsert.add(resultRecord);
                } else if (postgresRecordUpdateDate.after(oracleRecordUpdateDate)) {
                    toUpdate.add(resultRecord);
                }
            }

        }


    }

    private Connection getSourcePostgresConnection() throws SQLException {
        return ConnectionManager.getConnection(URL, USER, PASSWORD);
    }
}
