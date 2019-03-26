package com.sadb.transformation.oracle;

import com.sadb.generated.dest.oracle.tables.records.SyncLogRecord;
import com.sadb.generated.source.oracle.tables.*;
import com.sadb.generated.source.oracle.tables.Results;
import com.sadb.generated.source.oracle.tables.records.*;
import com.sadb.transformation.ConnectionManager;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.*;

import static com.sadb.generated.dest.oracle.Tables.SYNC_LOG;


@Service
public class OracleMigrationService {
    private static final Integer ORACLE_SOURCE_DB_ID = 0;
    private static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";

    //    private static final String URL = System.getenv("aws_oracle_url");
//    private static final String USER = System.getenv("aws_oracle_user");
//    private static final String PASSWORD = System.getenv("aws_oracle_password");
    private static final String URL = "jdbc:oracle:thin:@mydboraclinstance.c2wx7dijsbls.eu-west-3.rds.amazonaws.com:1521:ORCLDB";
    private static final String USER = "USER1";
    private static final String PASSWORD = "KMuZgdy4gbTDPps";

    @Scheduled(fixedDelayString = "#{ 60 * 1000}")
    public void process() throws ClassNotFoundException, SQLException {

        Timestamp syncStartTime = new Timestamp(new Date().getTime());

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

        // Get last sync time

        Result<SyncLogRecord> logRecords = contextOracle
                .select()
                .from(SYNC_LOG)
                .where(SYNC_LOG.DB_TYPE.eq(BigInteger.valueOf(ORACLE_SOURCE_DB_ID)))
                .orderBy(SYNC_LOG.TIMESTAMP.asc())
                .fetch().into(SYNC_LOG);

        Timestamp lastOracleSourceSync = logRecords.get(0).getTimestamp();


//        MEGAFACULTY MEGAFACULTY MEGAFACULTY
        Result<MegafacultyRecord> oracleSourceMegafaculty =
                contextSourceOracle
                        .select()
                        .from(Megafaculty.MEGAFACULTY)
                        .where(Megafaculty.MEGAFACULTY.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(Megafaculty.MEGAFACULTY);

        Result<com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord> oracleMegafaculty =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.Megafaculty.MEGAFACULTY)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.Megafaculty.MEGAFACULTY);

        processMegafaculty(
                oracleSourceMegafaculty,
                oracleMegafaculty,
                toInsert,
                toUpdate
        );

        // LECTURER LECTURER LECTURER LECTURER LECTURER LECTURER LECTURER
        Result<LecturerRecord> oracleSourceLecturer =
                contextSourceOracle
                        .select()
                        .from(Lecturer.LECTURER)
                        .where(Lecturer.LECTURER.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(Lecturer.LECTURER);

        Result<com.sadb.generated.dest.oracle.tables.records.LecturerRecord> oracleLectures =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.Lecturer.LECTURER)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.Lecturer.LECTURER);


        processOracleLecturer(
                oracleSourceLecturer,
                oracleLectures,
                toInsert,
                toUpdate
        );

        // STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS

        Result<StudentRecord> oracleSourceStudents =
                contextOracle
                        .select()
                        .from(Student.STUDENT)
                        .where(Student.STUDENT.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(Student.STUDENT);

        Result<com.sadb.generated.dest.oracle.tables.records.StudentRecord> oracleStudents =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.Student.STUDENT)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.Student.STUDENT);


        processOracleStudents(
                oracleSourceStudents,
                oracleStudents,
                toInsert,
                toUpdate
        );

        //  FACULTY FACULTY FACULTY FACULTY FACULTY

        Result<FacultyRecord> oracleSourseFaculty =
                contextSourceOracle
                        .select()
                        .from(Faculty.FACULTY)
                        .where(Faculty.FACULTY.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(Faculty.FACULTY);

        Result<com.sadb.generated.dest.oracle.tables.records.FacultyRecord> oracleFaculty =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.Faculty.FACULTY)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.Faculty.FACULTY);

        processFaculty(
                oracleSourseFaculty,
                oracleFaculty,
                toInsert,
                toUpdate
        );

        //        PROGRAM_TRACK PROGRAM_TRACK PROGRAM_TRACK

        Result<ProgramTrackRecord> oracleSourseProgramTrack =
                contextSourceOracle
                        .select()
                        .from(ProgramTrack.PROGRAM_TRACK)
                        .where(ProgramTrack.PROGRAM_TRACK.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(ProgramTrack.PROGRAM_TRACK);

        Result<com.sadb.generated.dest.oracle.tables.records.ProgramTrackRecord> oracleProgramTrack =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.ProgramTrack.PROGRAM_TRACK)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.ProgramTrack.PROGRAM_TRACK);

        processProgramTrack(
                oracleSourseProgramTrack,
                oracleProgramTrack,
                toInsert,
                toUpdate
        );

        //        SPECIALITY SPECIALITY SPECIALITY

        Result<SpecialityRecord> oracleSourseSpeciality =
                contextSourceOracle
                        .select()
                        .from(Speciality.SPECIALITY)
                        .where(Speciality.SPECIALITY.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(Speciality.SPECIALITY);

        Result<com.sadb.generated.dest.oracle.tables.records.SpecialityRecord> oracleSpeciality =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.Speciality.SPECIALITY)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.Speciality.SPECIALITY);

        processSpeciality(
                oracleSourseSpeciality,
                oracleSpeciality,
                toInsert,
                toUpdate
        );

        //        ACADEMIC_YEAR ACADEMIC_YEAR ACADEMIC_YEAR

        Result<AcademicYearRecord> oracleSourseAcademicYear =
                contextSourceOracle
                        .select()
                        .from(AcademicYear.ACADEMIC_YEAR)
                        .where(AcademicYear.ACADEMIC_YEAR.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(AcademicYear.ACADEMIC_YEAR);

        Result<com.sadb.generated.dest.oracle.tables.records.AcademicYearRecord> oracleAcademicYear =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.AcademicYear.ACADEMIC_YEAR)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.AcademicYear.ACADEMIC_YEAR);

        processAcademicYear(
                oracleSourseAcademicYear,
                oracleAcademicYear,
                toInsert,
                toUpdate
        );

        //        CLASS_ROOM CLASS_ROOM CLASS_ROOM

        Result<ClassRoomRecord> oracleSourseClassRoom =
                contextSourceOracle
                        .select()
                        .from(ClassRoom.CLASS_ROOM)
                        .where(ClassRoom.CLASS_ROOM.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(ClassRoom.CLASS_ROOM);

        Result<com.sadb.generated.dest.oracle.tables.records.ClassRoomRecord> oracleClassRoom =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.ClassRoom.CLASS_ROOM)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.ClassRoom.CLASS_ROOM);

        processClassRoom(
                oracleSourseClassRoom,
                oracleClassRoom,
                toInsert,
                toUpdate
        );

        //        FACULTY_LECTURER FACULTY_LECTURER FACULTY_LECTURER

        Result<FacultyLecturerRecord> oracleSourseFacultyLecturer =
                contextSourceOracle
                        .select()
                        .from(FacultyLecturer.FACULTY_LECTURER)
                        .where(FacultyLecturer.FACULTY_LECTURER.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(FacultyLecturer.FACULTY_LECTURER);

        Result<com.sadb.generated.dest.oracle.tables.records.FacultyLecturerRecord> oracleFacultyLecturer =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.FacultyLecturer.FACULTY_LECTURER)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.FacultyLecturer.FACULTY_LECTURER);

        processFacultyLecturer(
                oracleSourseFacultyLecturer,
                oracleFacultyLecturer,
                toInsert,
                toUpdate
        );

        //        GROUPS GROUPS GROUPS

        Result<GroupsRecord> oracleSourseGroups =
                contextSourceOracle
                        .select()
                        .from(Groups.GROUPS)
                        .where(Groups.GROUPS.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(Groups.GROUPS);

        Result<com.sadb.generated.dest.oracle.tables.records.GroupsRecord> oracleGroups =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.Groups.GROUPS)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.Groups.GROUPS);

        processGroups(
                oracleSourseGroups,
                oracleGroups,
                toInsert,
                toUpdate
        );

        //        OCCUPATION OCCUPATION OCCUPATION

        Result<OccupationRecord> oracleSourseOccupation =
                contextSourceOracle
                        .select()
                        .from(Occupation.OCCUPATION)
                        .where(Occupation.OCCUPATION.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(Occupation.OCCUPATION);

        Result<com.sadb.generated.dest.oracle.tables.records.OccupationRecord> oracleOccupation =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.Occupation.OCCUPATION)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.Occupation.OCCUPATION);

        processOccupation(
                oracleSourseOccupation,
                oracleOccupation,
                toInsert,
                toUpdate
        );

        //        ODEVITY_WEEK ODEVITY_WEEK ODEVITY_WEEK

        Result<OdevityWeekRecord> oracleSourseOdevityWeek =
                contextSourceOracle
                        .select()
                        .from(OdevityWeek.ODEVITY_WEEK)
                        .where(OdevityWeek.ODEVITY_WEEK.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(OdevityWeek.ODEVITY_WEEK);

        Result<com.sadb.generated.dest.oracle.tables.records.OdevityWeekRecord> oracleOdevityWeek =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.OdevityWeek.ODEVITY_WEEK)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.OdevityWeek.ODEVITY_WEEK);

        processOdevityWeek(
                oracleSourseOdevityWeek,
                oracleOdevityWeek,
                toInsert,
                toUpdate
        );

        //        VARIANT_OCCUPATION VARIANT_OCCUPATION VARIANT_OCCUPATION

        Result<VariantOccupationRecord> oracleSourseVariantOccupation =
                contextSourceOracle
                        .select()
                        .from(VariantOccupation.VARIANT_OCCUPATION)
                        .where(VariantOccupation.VARIANT_OCCUPATION.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(VariantOccupation.VARIANT_OCCUPATION);

        Result<com.sadb.generated.dest.oracle.tables.records.VariantOccupationRecord> oracleVariantOccupation =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.VariantOccupation.VARIANT_OCCUPATION)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.VariantOccupation.VARIANT_OCCUPATION);

        processVariantOccupation(
                oracleSourseVariantOccupation,
                oracleVariantOccupation,
                toInsert,
                toUpdate
        );

        //        WEEK_DAY WEEK_DAY WEEK_DAY

        Result<WeekDayRecord> oracleSourseWeekDay =
                contextSourceOracle
                        .select()
                        .from(WeekDay.WEEK_DAY)
                        .where(WeekDay.WEEK_DAY.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(WeekDay.WEEK_DAY);

        Result<com.sadb.generated.dest.oracle.tables.records.WeekDayRecord> oracleWeekDay =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.WeekDay.WEEK_DAY)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.WeekDay.WEEK_DAY);

        processWeekDay(
                oracleSourseWeekDay,
                oracleWeekDay,
                toInsert,
                toUpdate
        );

        //        TIME_TABLE TIME_TABLE TIME_TABLE

        Result<TimeTableRecord> oracleSourseTimeTable =
                contextSourceOracle
                        .select()
                        .from(TimeTable.TIME_TABLE)
                        .where(TimeTable.TIME_TABLE.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(TimeTable.TIME_TABLE);

        Result<com.sadb.generated.dest.oracle.tables.records.TimeTableRecord> oracleTimeTable =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.TimeTable.TIME_TABLE)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.TimeTable.TIME_TABLE);

        processTimeTable(
                oracleSourseTimeTable,
                oracleTimeTable,
                toInsert,
                toUpdate
        );

        //        DISCIPLINE DISCIPLINE DISCIPLINE

        Result<DisciplineRecord> oracleSourseDiscipline =
                contextSourceOracle
                        .select()
                        .from(Discipline.DISCIPLINE)
                        .where(Discipline.DISCIPLINE.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(Discipline.DISCIPLINE);

        Result<com.sadb.generated.dest.oracle.tables.records.DisciplineRecord> oracleDiscipline =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.Discipline.DISCIPLINE)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.Discipline.DISCIPLINE);

        processOracleDiscipline(
                oracleSourseDiscipline,
                oracleDiscipline,
                toInsert,
                toUpdate
        );

        //        RESULTS RESULTS RESULTS

        Result<ResultsRecord> oracleSourseResults =
                contextSourceOracle
                        .select()
                        .from(Results.RESULTS)
                        .where(Results.RESULTS.UPDATE_TIME.ge(new java.sql.Date(lastOracleSourceSync.getTime())))
                        .fetch()
                        .into(Results.RESULTS);

        Result<com.sadb.generated.dest.oracle.tables.records.ResultsRecord> oracleResults =
                contextOracle
                        .select()
                        .from(com.sadb.generated.dest.oracle.tables.Results.RESULTS)
                        .fetch()
                        .into(com.sadb.generated.dest.oracle.tables.Results.RESULTS);

        processOracleResults(
                oracleSourseResults,
                oracleResults,
                toInsert,
                toUpdate
        );

        SyncLogRecord syncLogRecord = new SyncLogRecord();
        syncLogRecord.setDbType(BigInteger.valueOf(ORACLE_SOURCE_DB_ID));
        syncLogRecord.setTimestamp(syncStartTime);

        toInsert.add(syncLogRecord);

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


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleMegafacultyRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = megafacultyIdToUpdatedDateMap.get(oracleMegafacultyRecord.getMegafacId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord oldRecord =
                        megafacultyIdToRecordMap.get(oracleMegafacultyRecord.getMegafacId().intValue());

                com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord megafacultyRecord;


                Mode mode;
                if (oldRecord == null) {
                    megafacultyRecord = new com.sadb.generated.dest.oracle.tables.records.MegafacultyRecord();
                    megafacultyRecord.setMegafacId(oracleMegafacultyRecord.getMegafacId().longValue());
                    mode = Mode.INSERT;
                } else {
                    megafacultyRecord = oldRecord;
                    megafacultyRecord.changed(true);
                    mode = Mode.UPDATE;
                }


                megafacultyRecord.setMfacultyName(oracleMegafacultyRecord.getMfacultyName());

                megafacultyRecord.setCreatTime(new Timestamp(oracleMegafacultyRecord.getUpdateTime().getTime()));
                megafacultyRecord.setUpdateTime(oracleSourceRecordUpdateDate);

                if (mode == Mode.INSERT) {
                    toInsert.add(megafacultyRecord);
                } else {
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

                Mode mode;
                if (oldRecord == null) {
                    lecturerRecord = new com.sadb.generated.dest.oracle.tables.records.LecturerRecord();
                    lecturerRecord.setLecId(oracleSourceLecturerRecord.getLecId().longValue());
                    mode = Mode.INSERT;
                } else {
                    lecturerRecord = oldRecord;
                    lecturerRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                lecturerRecord.setPatronymicName(oracleSourceLecturerRecord.getPatronymicName());
                lecturerRecord.setFirstName(oracleSourceLecturerRecord.getFirstName());
                lecturerRecord.setSecondName(oracleSourceLecturerRecord.getSecondName());
                lecturerRecord.setPost(oracleSourceLecturerRecord.getPost());
                lecturerRecord.setWorkPeriodFrom(new Timestamp(oracleSourceLecturerRecord.getWorkPeriodFrom().getTime()));
                if (oracleSourceLecturerRecord.getBirthPlace() != null) {
                    lecturerRecord.setBirthPlace(oracleSourceLecturerRecord.getBirthPlace());
                }
                if (oracleSourceLecturerRecord.getBirthDate() != null) {
                    lecturerRecord.setBirthDate(new Timestamp(oracleSourceLecturerRecord.getBirthDate().getTime()));
                }
                if (oracleSourceLecturerRecord.getWorkPeriodTo() != null) {
                    lecturerRecord.setWorkPeriodTo(new Timestamp(oracleSourceLecturerRecord.getWorkPeriodTo().getTime()));
                }

                lecturerRecord.setUpdateTime(new Timestamp(oracleSourceLecturerRecord.getUpdateTime().getTime()));
                lecturerRecord.setCreatTime(new Timestamp(oracleSourceLecturerRecord.getCreatTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(lecturerRecord);
                } else {
                    toUpdate.add(lecturerRecord);
                }
            }

        }

    }

    private void processOracleStudents(
            List<StudentRecord> oracleSourceStudents,
            List<com.sadb.generated.dest.oracle.tables.records.StudentRecord> oracleStudents,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> studentIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.StudentRecord> studentIdToRecordMap = new HashMap<>();

        oracleStudents.forEach(oracleStudent -> {
            studentIdToUpdatedDateMap.put(oracleStudent.getId().intValue(), oracleStudent.getUpdationDate());
            studentIdToRecordMap.put(oracleStudent.getId().intValue(), oracleStudent);
        });

        for (StudentRecord oracleSourceStudentRecord : oracleSourceStudents) {

            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleSourceStudentRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = studentIdToUpdatedDateMap.get(oracleSourceStudentRecord.getStudentId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.StudentRecord oldRecord =
                        studentIdToRecordMap.get(oracleSourceStudentRecord.getStudentId().intValue());

                com.sadb.generated.dest.oracle.tables.records.StudentRecord studentRecord;

                Mode mode;
                if (oldRecord == null) {
                    studentRecord = new com.sadb.generated.dest.oracle.tables.records.StudentRecord();
                    studentRecord.setId(BigDecimal.valueOf(oracleSourceStudentRecord.getStudentId().longValue()));
                    mode = Mode.INSERT;
                } else {
                    studentRecord = oldRecord;
                    studentRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                if (mode == Mode.INSERT) {
                    studentRecord.setSurname(oracleSourceStudentRecord.getSecondName());
                    studentRecord.setName(oracleSourceStudentRecord.getFirstName());
                    studentRecord.setSecondName(oracleSourceStudentRecord.getPatronymicName());
                }


                if (oracleSourceStudentRecord.getBirthDate() != null) {
                    studentRecord.setBirthDate(new Timestamp(oracleSourceStudentRecord.getBirthDate().getTime()));
                }
                if (oracleSourceStudentRecord.getBirthPlace() != null) {
                    studentRecord.setBirthPlace(oracleSourceStudentRecord.getBirthPlace());
                }
                if (oracleSourceStudentRecord.getGroupId() != null) {
                    studentRecord.setGroupId(oracleSourceStudentRecord.getGroupId().longValue());
                }
                if (oracleSourceStudentRecord.getEducationType() != null) {
                    studentRecord.setEducationType(oracleSourceStudentRecord.getEducationType());
                }

                studentRecord.setUpdationDate(new Timestamp(oracleSourceStudentRecord.getUpdateTime().getTime()));
                studentRecord.setCreationDate(new Timestamp(oracleSourceStudentRecord.getCreatTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(studentRecord);
                } else {
                    toUpdate.add(studentRecord);
                }
            }

        }

    }


    private void processFaculty(
            List<FacultyRecord> oracleSourceFacultys,
            List<com.sadb.generated.dest.oracle.tables.records.FacultyRecord> oracleFacultys,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> facultyIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.FacultyRecord> facultyIdToRecordMap = new HashMap<>();

        oracleFacultys.forEach(oracleFaculty -> {
            facultyIdToUpdatedDateMap.put(oracleFaculty.getFacId().intValue(), oracleFaculty.getUpdateTime());
            facultyIdToRecordMap.put(oracleFaculty.getFacId().intValue(), oracleFaculty);
        });

        for (FacultyRecord oracleFacultyRecord : oracleSourceFacultys) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleFacultyRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = facultyIdToUpdatedDateMap.get(oracleFacultyRecord.getFacId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.FacultyRecord oldRecord =
                        facultyIdToRecordMap.get(oracleFacultyRecord.getFacId().intValue());

                com.sadb.generated.dest.oracle.tables.records.FacultyRecord facultyRecord;

                Mode mode;
                if (oldRecord == null) {
                    facultyRecord = new com.sadb.generated.dest.oracle.tables.records.FacultyRecord();
                    facultyRecord.setFacId(oracleFacultyRecord.getFacId().longValue());
                    mode = Mode.INSERT;
                } else {
                    facultyRecord = oldRecord;
                    facultyRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                facultyRecord.setFacName(oracleFacultyRecord.getFacName());
                facultyRecord.setMegafacId(oracleFacultyRecord.getMegafacId().longValue());

                facultyRecord.setCreatTime(new Timestamp(oracleFacultyRecord.getCreatTime().getTime()));
                facultyRecord.setUpdateTime(new Timestamp(oracleFacultyRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(facultyRecord);
                } else {
                    toUpdate.add(facultyRecord);
                }
            }

        }

    }

    private void processProgramTrack(
            List<ProgramTrackRecord> oracleSourceProgramTracks,
            List<com.sadb.generated.dest.oracle.tables.records.ProgramTrackRecord> oracleProgramTracks,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> programTrackIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.ProgramTrackRecord> programTrackIdToRecordMap = new HashMap<>();

        oracleProgramTracks.forEach(oracleProgramTrack -> {
            programTrackIdToUpdatedDateMap.put(oracleProgramTrack.getProgId().intValue(), oracleProgramTrack.getUpdateTime());
            programTrackIdToRecordMap.put(oracleProgramTrack.getProgId().intValue(), oracleProgramTrack);
        });

        for (ProgramTrackRecord oracleProgramTrackRecord : oracleSourceProgramTracks) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleProgramTrackRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = programTrackIdToUpdatedDateMap.get(oracleProgramTrackRecord.getProgId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.ProgramTrackRecord oldRecord =
                        programTrackIdToRecordMap.get(oracleProgramTrackRecord.getProgId().intValue());

                com.sadb.generated.dest.oracle.tables.records.ProgramTrackRecord programTrackRecordRecord;

                Mode mode;
                if (oldRecord == null) {
                    programTrackRecordRecord = new com.sadb.generated.dest.oracle.tables.records.ProgramTrackRecord();
                    programTrackRecordRecord.setProgId(oracleProgramTrackRecord.getProgId().longValue());
                    mode = Mode.INSERT;
                } else {
                    programTrackRecordRecord = oldRecord;
                    programTrackRecordRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                programTrackRecordRecord.setFacId(oracleProgramTrackRecord.getFacId().longValue());
                programTrackRecordRecord.setProgmName(oracleProgramTrackRecord.getProgmName());
                programTrackRecordRecord.setProgmType(oracleProgramTrackRecord.getProgmType());
                programTrackRecordRecord.setProgramTrackNum(oracleProgramTrackRecord.getProgramTrackNum());

                programTrackRecordRecord.setCreatTime(new Timestamp(oracleProgramTrackRecord.getCreatTime().getTime()));
                programTrackRecordRecord.setUpdateTime(new Timestamp(oracleProgramTrackRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(programTrackRecordRecord);
                } else {
                    toUpdate.add(programTrackRecordRecord);
                }
            }

        }

    }

    private void processSpeciality(
            List<SpecialityRecord> oracleSourceSpecialitys,
            List<com.sadb.generated.dest.oracle.tables.records.SpecialityRecord> oracleSpecialitys,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> specialityIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.SpecialityRecord> specialityIdToRecordMap = new HashMap<>();

        oracleSpecialitys.forEach(oracleSpeciality -> {
            specialityIdToUpdatedDateMap.put(oracleSpeciality.getSpecId().intValue(), oracleSpeciality.getUpdateTime());
            specialityIdToRecordMap.put(oracleSpeciality.getSpecId().intValue(), oracleSpeciality);
        });

        for (SpecialityRecord oracleSpecialityRecord : oracleSourceSpecialitys) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleSpecialityRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = specialityIdToUpdatedDateMap.get(oracleSpecialityRecord.getSpecId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.SpecialityRecord oldRecord =
                        specialityIdToRecordMap.get(oracleSpecialityRecord.getSpecId().intValue());

                com.sadb.generated.dest.oracle.tables.records.SpecialityRecord specialityRecord;

                Mode mode;
                if (oldRecord == null) {
                    specialityRecord = new com.sadb.generated.dest.oracle.tables.records.SpecialityRecord();
                    specialityRecord.setSpecId(oracleSpecialityRecord.getSpecId().longValue());
                    mode = Mode.INSERT;
                } else {
                    specialityRecord = oldRecord;
                    specialityRecord.changed(true);
                    mode = Mode.UPDATE;
                }


                specialityRecord.setProgId(oracleSpecialityRecord.getProgId().longValue());
                specialityRecord.setSpecName(oracleSpecialityRecord.getSpecName());
                specialityRecord.setSpecDegree(oracleSpecialityRecord.getSpecDegree());
                if (oracleSpecialityRecord.getFreeEducCount() != null) {
                    specialityRecord.setFreeEducCount(oracleSpecialityRecord.getFreeEducCount().longValue());
                }
                if (oracleSpecialityRecord.getPaidEducCount() != null) {
                    specialityRecord.setPaidEducCount(oracleSpecialityRecord.getPaidEducCount().longValue());
                }
                if (oracleSpecialityRecord.getSponsoredEducCount() != null) {
                    specialityRecord.setSponsoredEducCount(oracleSpecialityRecord.getSponsoredEducCount().longValue());
                }

                specialityRecord.setCreatTime(new Timestamp(oracleSpecialityRecord.getCreatTime().getTime()));
                specialityRecord.setUpdateTime(new Timestamp(oracleSpecialityRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(specialityRecord);
                } else {
                    toUpdate.add(specialityRecord);
                }
            }

        }

    }

    private void processAcademicYear(
            List<AcademicYearRecord> oracleSourceAcademicYears,
            List<com.sadb.generated.dest.oracle.tables.records.AcademicYearRecord> oracleAcademicYears,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> AcademicYearIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.AcademicYearRecord> AcademicYearIdToRecordMap = new HashMap<>();

        oracleAcademicYears.forEach(oracleAcademicYear -> {
            AcademicYearIdToUpdatedDateMap.put(oracleAcademicYear.getAcademYearId().intValue(), oracleAcademicYear.getUpdateTime());
            AcademicYearIdToRecordMap.put(oracleAcademicYear.getAcademYearId().intValue(), oracleAcademicYear);
        });

        for (AcademicYearRecord oracleAcademicYearRecord : oracleSourceAcademicYears) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleAcademicYearRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = AcademicYearIdToUpdatedDateMap.get(oracleAcademicYearRecord.getAcademYearId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.AcademicYearRecord oldRecord =
                        AcademicYearIdToRecordMap.get(oracleAcademicYearRecord.getAcademYearId().intValue());

                com.sadb.generated.dest.oracle.tables.records.AcademicYearRecord acodemicYearRecord;

                Mode mode;
                if (oldRecord == null) {
                    acodemicYearRecord = new com.sadb.generated.dest.oracle.tables.records.AcademicYearRecord();
                    acodemicYearRecord.setAcademYearId(oracleAcademicYearRecord.getAcademYearId().longValue());
                    mode = Mode.INSERT;
                } else {
                    acodemicYearRecord = oldRecord;
                    acodemicYearRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                acodemicYearRecord.setAcademYear(oracleAcademicYearRecord.getAcademYear());

                acodemicYearRecord.setCreatTime(new Timestamp(oracleAcademicYearRecord.getCreatTime().getTime()));
                acodemicYearRecord.setUpdateTime(new Timestamp(oracleAcademicYearRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(acodemicYearRecord);
                } else {
                    toUpdate.add(acodemicYearRecord);
                }
            }

        }

    }

    private void processClassRoom(
            List<ClassRoomRecord> oracleSourceClassRooms,
            List<com.sadb.generated.dest.oracle.tables.records.ClassRoomRecord> oracleClassRooms,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> ClassRoomIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.ClassRoomRecord> ClassRoomIdToRecordMap = new HashMap<>();

        oracleClassRooms.forEach(oracleClassRoom -> {
            ClassRoomIdToUpdatedDateMap.put(oracleClassRoom.getClassId().intValue(), oracleClassRoom.getUpdateTime());
            ClassRoomIdToRecordMap.put(oracleClassRoom.getClassId().intValue(), oracleClassRoom);
        });

        for (ClassRoomRecord oracleClassRoomRecord : oracleSourceClassRooms) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleClassRoomRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = ClassRoomIdToUpdatedDateMap.get(oracleClassRoomRecord.getClassId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.ClassRoomRecord oldRecord =
                        ClassRoomIdToRecordMap.get(oracleClassRoomRecord.getClassId().intValue());

                com.sadb.generated.dest.oracle.tables.records.ClassRoomRecord classRoomRecord;

                Mode mode;
                if (oldRecord == null) {
                    classRoomRecord = new com.sadb.generated.dest.oracle.tables.records.ClassRoomRecord();
                    classRoomRecord.setClassId(oracleClassRoomRecord.getClassId().longValue());
                    mode = Mode.INSERT;
                } else {
                    classRoomRecord = oldRecord;
                    classRoomRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                classRoomRecord.setClassNumber(oracleClassRoomRecord.getClassNumber().longValue());

                classRoomRecord.setCreatTime(new Timestamp(oracleClassRoomRecord.getCreatTime().getTime()));
                classRoomRecord.setUpdateTime(new Timestamp(oracleClassRoomRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(classRoomRecord);
                } else {
                    toUpdate.add(classRoomRecord);
                }
            }

        }

    }

    private void processFacultyLecturer(
            List<FacultyLecturerRecord> oracleSourceFacultyLecturers,
            List<com.sadb.generated.dest.oracle.tables.records.FacultyLecturerRecord> oracleFacultyLecturers,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> FacultyLecturerIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.FacultyLecturerRecord> FacultyLecturerIdToRecordMap = new HashMap<>();

        oracleFacultyLecturers.forEach(oracleFacultyLecturer -> {
            FacultyLecturerIdToUpdatedDateMap.put(oracleFacultyLecturer.getFacLectId().intValue(), oracleFacultyLecturer.getUpdateTime());
            FacultyLecturerIdToRecordMap.put(oracleFacultyLecturer.getFacLectId().intValue(), oracleFacultyLecturer);
        });

        for (FacultyLecturerRecord oracleFacultyLecturerRecord : oracleSourceFacultyLecturers) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleFacultyLecturerRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = FacultyLecturerIdToUpdatedDateMap.get(oracleFacultyLecturerRecord.getFacLectId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.FacultyLecturerRecord oldRecord =
                        FacultyLecturerIdToRecordMap.get(oracleFacultyLecturerRecord.getFacLectId().intValue());

                com.sadb.generated.dest.oracle.tables.records.FacultyLecturerRecord facultulecturerRecord;

                Mode mode;
                if (oldRecord == null) {
                    facultulecturerRecord = new com.sadb.generated.dest.oracle.tables.records.FacultyLecturerRecord();
                    facultulecturerRecord.setFacLectId(oracleFacultyLecturerRecord.getFacLectId().longValue());
                    mode = Mode.INSERT;
                } else {
                    facultulecturerRecord = oldRecord;
                    facultulecturerRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                facultulecturerRecord.setFacId(oracleFacultyLecturerRecord.getFacId().longValue());
                facultulecturerRecord.setLecId(oracleFacultyLecturerRecord.getLecId().longValue());

                facultulecturerRecord.setCreatTime(new Timestamp(oracleFacultyLecturerRecord.getCreatTime().getTime()));
                facultulecturerRecord.setUpdateTime(new Timestamp(oracleFacultyLecturerRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(facultulecturerRecord);
                } else {
                    toUpdate.add(facultulecturerRecord);
                }
            }

        }

    }

    private void processGroups(
            List<GroupsRecord> oracleSourceGroups,
            List<com.sadb.generated.dest.oracle.tables.records.GroupsRecord> oracleGroups,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> GroupsIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.GroupsRecord> GroupsIdToRecordMap = new HashMap<>();

        oracleGroups.forEach(oracleGroup -> {
            GroupsIdToUpdatedDateMap.put(oracleGroup.getGroupId().intValue(), oracleGroup.getUpdateTime());
            GroupsIdToRecordMap.put(oracleGroup.getGroupId().intValue(), oracleGroup);
        });

        for (GroupsRecord oracleGroupsRecord : oracleSourceGroups) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleGroupsRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = GroupsIdToUpdatedDateMap.get(oracleGroupsRecord.getGroupId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.GroupsRecord oldRecord =
                        GroupsIdToRecordMap.get(oracleGroupsRecord.getGroupId().intValue());

                com.sadb.generated.dest.oracle.tables.records.GroupsRecord groupsRecord;

                Mode mode;
                if (oldRecord == null) {
                    groupsRecord = new com.sadb.generated.dest.oracle.tables.records.GroupsRecord();
                    groupsRecord.setGroupId(oracleGroupsRecord.getGroupId().longValue());
                    mode = Mode.INSERT;
                } else {
                    groupsRecord = oldRecord;
                    groupsRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                groupsRecord.setSpecId(oracleGroupsRecord.getSpecId().longValue());
                groupsRecord.setAcademYearId(oracleGroupsRecord.getAcademYearId().longValue());
                groupsRecord.setGroupNum(oracleGroupsRecord.getGroupNum());
                groupsRecord.setCourse(oracleGroupsRecord.getCourse().longValue());
                if (oracleGroupsRecord.getEducationTimeFrom() != null) {
                    groupsRecord.setEducationTimeFrom(new Timestamp(oracleGroupsRecord.getEducationTimeFrom().getTime()));
                }
                if (oracleGroupsRecord.getEducationTimeTo() != null) {
                    groupsRecord.setEducationTimeTo(new Timestamp(oracleGroupsRecord.getEducationTimeTo().getTime()));
                }

                groupsRecord.setCreatTime(new Timestamp(oracleGroupsRecord.getCreatTime().getTime()));
                groupsRecord.setUpdateTime(new Timestamp(oracleGroupsRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(groupsRecord);
                } else {
                    toUpdate.add(groupsRecord);
                }
            }

        }

    }

    private void processOccupation(
            List<OccupationRecord> oracleSourceOccupations,
            List<com.sadb.generated.dest.oracle.tables.records.OccupationRecord> oracleOccupations,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> OccupationIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.OccupationRecord> OccupationIdToRecordMap = new HashMap<>();

        oracleOccupations.forEach(oracleOccupation -> {
            OccupationIdToUpdatedDateMap.put(oracleOccupation.getOccupationId().intValue(), oracleOccupation.getUpdateTime());
            OccupationIdToRecordMap.put(oracleOccupation.getOccupationId().intValue(), oracleOccupation);
        });

        for (OccupationRecord oracleOccupationRecord : oracleSourceOccupations) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleOccupationRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = OccupationIdToUpdatedDateMap.get(oracleOccupationRecord.getOccupationId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.OccupationRecord oldRecord =
                        OccupationIdToRecordMap.get(oracleOccupationRecord.getOccupationId().intValue());

                com.sadb.generated.dest.oracle.tables.records.OccupationRecord occupationRecord;

                Mode mode;
                if (oldRecord == null) {
                    occupationRecord = new com.sadb.generated.dest.oracle.tables.records.OccupationRecord();
                    occupationRecord.setOccupationId(oracleOccupationRecord.getOccupationId().longValue());
                    mode = Mode.INSERT;
                } else {
                    occupationRecord = oldRecord;
                    occupationRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                occupationRecord.setOccupatonNum(oracleOccupationRecord.getOccupatonNum().longValue());
                occupationRecord.setOccupationTimeFrom(oracleOccupationRecord.getOccupationTimeFrom());
                occupationRecord.setOccupationTimeTo(oracleOccupationRecord.getOccupationTimeTo());

                occupationRecord.setCreatTime(new Timestamp(oracleOccupationRecord.getCreatTime().getTime()));
                occupationRecord.setUpdateTime(new Timestamp(oracleOccupationRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(occupationRecord);
                } else {
                    toUpdate.add(occupationRecord);
                }
            }

        }
    }

    private void processOdevityWeek(
            List<OdevityWeekRecord> oracleSourceOdevityWeeks,
            List<com.sadb.generated.dest.oracle.tables.records.OdevityWeekRecord> oracleOdevityWeeks,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> OdevityWeekIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.OdevityWeekRecord> OdevityWeekIdToRecordMap = new HashMap<>();

        oracleOdevityWeeks.forEach(oracleOdevityWeek -> {
            OdevityWeekIdToUpdatedDateMap.put(oracleOdevityWeek.getOdevityId().intValue(), oracleOdevityWeek.getUpdateTime());
            OdevityWeekIdToRecordMap.put(oracleOdevityWeek.getOdevityId().intValue(), oracleOdevityWeek);
        });

        for (OdevityWeekRecord oracleOdevityWeekRecord : oracleSourceOdevityWeeks) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleOdevityWeekRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = OdevityWeekIdToUpdatedDateMap.get(oracleOdevityWeekRecord.getOdevityId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.OdevityWeekRecord oldRecord =
                        OdevityWeekIdToRecordMap.get(oracleOdevityWeekRecord.getOdevityId().intValue());

                com.sadb.generated.dest.oracle.tables.records.OdevityWeekRecord odevityWeekRecord;

                Mode mode;
                if (oldRecord == null) {
                    odevityWeekRecord = new com.sadb.generated.dest.oracle.tables.records.OdevityWeekRecord();
                    odevityWeekRecord.setOdevityId(oracleOdevityWeekRecord.getOdevityId().longValue());
                    mode = Mode.INSERT;
                } else {
                    odevityWeekRecord = oldRecord;
                    odevityWeekRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                odevityWeekRecord.setWeek(oracleOdevityWeekRecord.getWeek());

                odevityWeekRecord.setCreatTime(new Timestamp(oracleOdevityWeekRecord.getCreatTime().getTime()));
                odevityWeekRecord.setUpdateTime(new Timestamp(oracleOdevityWeekRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(odevityWeekRecord);
                } else {
                    toUpdate.add(odevityWeekRecord);
                }
            }

        }

    }

    private void processVariantOccupation(
            List<VariantOccupationRecord> oracleSourceVariantOccupations,
            List<com.sadb.generated.dest.oracle.tables.records.VariantOccupationRecord> oracleVariantOccupations,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> VariantOccupationIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.VariantOccupationRecord> VariantOccupationIdToRecordMap = new HashMap<>();

        oracleVariantOccupations.forEach(oracleVariantOccupation -> {
            VariantOccupationIdToUpdatedDateMap.put(oracleVariantOccupation.getVariantOccupationId().intValue(), oracleVariantOccupation.getUpdateTime());
            VariantOccupationIdToRecordMap.put(oracleVariantOccupation.getVariantOccupationId().intValue(), oracleVariantOccupation);
        });

        for (VariantOccupationRecord oracleVariantOccupationRecord : oracleSourceVariantOccupations) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleVariantOccupationRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = VariantOccupationIdToUpdatedDateMap.get(oracleVariantOccupationRecord.getVariantOccupationId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.VariantOccupationRecord oldRecord =
                        VariantOccupationIdToRecordMap.get(oracleVariantOccupationRecord.getVariantOccupationId().intValue());

                com.sadb.generated.dest.oracle.tables.records.VariantOccupationRecord variantOccupationRecord;

                Mode mode;
                if (oldRecord == null) {
                    variantOccupationRecord = new com.sadb.generated.dest.oracle.tables.records.VariantOccupationRecord();
                    variantOccupationRecord.setVariantOccupationId(oracleVariantOccupationRecord.getVariantOccupationId().longValue());
                    mode = Mode.INSERT;
                } else {
                    variantOccupationRecord = oldRecord;
                    variantOccupationRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                variantOccupationRecord.setVarOccType(oracleVariantOccupationRecord.getVarOccType());

                variantOccupationRecord.setCreatTime(new Timestamp(oracleVariantOccupationRecord.getCreatTime().getTime()));
                variantOccupationRecord.setUpdateTime(new Timestamp(oracleVariantOccupationRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(variantOccupationRecord);
                } else {
                    toUpdate.add(variantOccupationRecord);
                }
            }

        }

    }

    private void processWeekDay(
            List<WeekDayRecord> oracleSourceWeekDays,
            List<com.sadb.generated.dest.oracle.tables.records.WeekDayRecord> oracleWeekDays,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> WeekDayIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.WeekDayRecord> WeekDayIdToRecordMap = new HashMap<>();

        oracleWeekDays.forEach(oracleWeekDay -> {
            WeekDayIdToUpdatedDateMap.put(oracleWeekDay.getWeekDayId().intValue(), oracleWeekDay.getUpdateTime());
            WeekDayIdToRecordMap.put(oracleWeekDay.getWeekDayId().intValue(), oracleWeekDay);
        });

        for (WeekDayRecord oracleWeekDayRecord : oracleSourceWeekDays) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleWeekDayRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = WeekDayIdToUpdatedDateMap.get(oracleWeekDayRecord.getWeekDayId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.WeekDayRecord oldRecord =
                        WeekDayIdToRecordMap.get(oracleWeekDayRecord.getWeekDayId().intValue());

                com.sadb.generated.dest.oracle.tables.records.WeekDayRecord weekDayRecord;

                Mode mode;
                if (oldRecord == null) {
                    weekDayRecord = new com.sadb.generated.dest.oracle.tables.records.WeekDayRecord();
                    weekDayRecord.setWeekDayId(oracleWeekDayRecord.getWeekDayId().longValue());
                    mode = Mode.INSERT;
                } else {
                    weekDayRecord = oldRecord;
                    weekDayRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                weekDayRecord.setDay(oracleWeekDayRecord.getDay());

                weekDayRecord.setCreatTime(new Timestamp(oracleWeekDayRecord.getCreatTime().getTime()));
                weekDayRecord.setUpdateTime(new Timestamp(oracleWeekDayRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(weekDayRecord);
                } else {
                    toUpdate.add(weekDayRecord);
                }
            }

        }

    }

    private void processOracleDiscipline(
            List<DisciplineRecord> oracleSourceDisciplines,
            List<com.sadb.generated.dest.oracle.tables.records.DisciplineRecord> oracleDisciplines,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> DisciplineIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.DisciplineRecord> DisciplineIdToRecordMap = new HashMap<>();

        oracleDisciplines.forEach(oracleDiscipline -> {
            DisciplineIdToUpdatedDateMap.put(oracleDiscipline.getDisciplineId().intValue(), oracleDiscipline.getUpdateTime());
            DisciplineIdToRecordMap.put(oracleDiscipline.getDisciplineId().intValue(), oracleDiscipline);
        });

        for (DisciplineRecord oracleDisciplineRecord : oracleSourceDisciplines) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleDisciplineRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = DisciplineIdToUpdatedDateMap.get(oracleDisciplineRecord.getDisciplineId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.DisciplineRecord oldRecord =
                        DisciplineIdToRecordMap.get(oracleDisciplineRecord.getDisciplineId().intValue());

                com.sadb.generated.dest.oracle.tables.records.DisciplineRecord disciplineRecord;

                Mode mode;
                if (oldRecord == null) {
                    disciplineRecord = new com.sadb.generated.dest.oracle.tables.records.DisciplineRecord();
                    disciplineRecord.setDisciplineId(oracleDisciplineRecord.getDisciplineId().longValue());
                    mode = Mode.INSERT;
                } else {
                    disciplineRecord = oldRecord;
                    disciplineRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                disciplineRecord.setDisciplineName(oracleDisciplineRecord.getDisciplineName());

                disciplineRecord.setCreatTime(new Timestamp(oracleDisciplineRecord.getCreatTime().getTime()));
                disciplineRecord.setUpdateTime(new Timestamp(oracleDisciplineRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(disciplineRecord);
                } else {
                    toUpdate.add(disciplineRecord);
                }
            }

        }

    }

    private void processOracleResults(
            List<ResultsRecord> oracleSourceResults,
            List<com.sadb.generated.dest.oracle.tables.records.ResultsRecord> oracleResults,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> ResultsIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.ResultsRecord> ResultsIdToRecordMap = new HashMap<>();

        oracleResults.forEach(oracleResult -> {
            ResultsIdToUpdatedDateMap.put(oracleResult.getResultId().intValue(), oracleResult.getUpdateTime());
            ResultsIdToRecordMap.put(oracleResult.getResultId().intValue(), oracleResult);
        });

        for (ResultsRecord oracleResultsRecord : oracleSourceResults) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleResultsRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = ResultsIdToUpdatedDateMap.get(oracleResultsRecord.getResultId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.ResultsRecord oldRecord =
                        ResultsIdToRecordMap.get(oracleResultsRecord.getResultId().intValue());

                com.sadb.generated.dest.oracle.tables.records.ResultsRecord resultsRecord;

                Mode mode;
                if (oldRecord == null) {
                    resultsRecord = new com.sadb.generated.dest.oracle.tables.records.ResultsRecord();
                    resultsRecord.setResultId(oracleResultsRecord.getResultId().longValue());
                    mode = Mode.INSERT;
                } else {
                    resultsRecord = oldRecord;
                    resultsRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                resultsRecord.setDisciplineId(oracleResultsRecord.getDisciplineId().longValue());
                resultsRecord.setAcademYearId(oracleResultsRecord.getAcademYearId().longValue());
                resultsRecord.setStudentId(oracleResultsRecord.getStudentId().longValue());
                if (oracleResultsRecord.getResult() != null) {
                    resultsRecord.setResult(oracleResultsRecord.getResult());
                }
                if (oracleResultsRecord.getExType() != null) {
                    resultsRecord.setExType(oracleResultsRecord.getExType());
                }
                if (oracleResultsRecord.getResultDate() != null) {
                    resultsRecord.setResultDate(new Timestamp(oracleResultsRecord.getResultDate().getTime()));
                }
                if (oracleResultsRecord.getResultEu() != null) {
                    resultsRecord.setResultEu(oracleResultsRecord.getResultEu());
                }

                resultsRecord.setCreatTime(new Timestamp(oracleResultsRecord.getCreatTime().getTime()));
                resultsRecord.setUpdateTime(new Timestamp(oracleResultsRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(resultsRecord);
                } else {
                    toUpdate.add(resultsRecord);
                }
            }

        }

    }

    private void processTimeTable(
            List<TimeTableRecord> oracleSourceTimeTables,
            List<com.sadb.generated.dest.oracle.tables.records.TimeTableRecord> oracleTimeTables,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {

        Map<Integer, Timestamp> TimeTableIdToUpdatedDateMap = new HashMap<>();
        Map<Integer, com.sadb.generated.dest.oracle.tables.records.TimeTableRecord> TimeTableIdToRecordMap = new HashMap<>();

        oracleTimeTables.forEach(oracleTimeTable -> {
            TimeTableIdToUpdatedDateMap.put(oracleTimeTable.getTimeTableId().intValue(), oracleTimeTable.getUpdateTime());
            TimeTableIdToRecordMap.put(oracleTimeTable.getTimeTableId().intValue(), oracleTimeTable);
        });

        for (TimeTableRecord oracleTimeTableRecord : oracleSourceTimeTables) {


            Timestamp oracleSourceRecordUpdateDate = new Timestamp(oracleTimeTableRecord.getUpdateTime().getTime());
            Timestamp oracleRecordUpdateDate = TimeTableIdToUpdatedDateMap.get(oracleTimeTableRecord.getTimeTableId().intValue());

            if (oracleRecordUpdateDate == null || oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {

                com.sadb.generated.dest.oracle.tables.records.TimeTableRecord oldRecord =
                        TimeTableIdToRecordMap.get(oracleTimeTableRecord.getTimeTableId().intValue());

                com.sadb.generated.dest.oracle.tables.records.TimeTableRecord timeTableRecord;

                Mode mode;
                if (oldRecord == null) {
                    timeTableRecord = new com.sadb.generated.dest.oracle.tables.records.TimeTableRecord();
                    timeTableRecord.setTimeTableId(oracleTimeTableRecord.getTimeTableId().longValue());
                    mode = Mode.INSERT;
                } else {
                    timeTableRecord = oldRecord;
                    timeTableRecord.changed(true);
                    mode = Mode.UPDATE;
                }

                timeTableRecord.setDisciplineId(oracleTimeTableRecord.getDisciplineId().longValue());
                timeTableRecord.setClassId(oracleTimeTableRecord.getClassId().longValue());
                timeTableRecord.setGroupId(oracleTimeTableRecord.getGroupId().longValue());
                timeTableRecord.setOccupationId(oracleTimeTableRecord.getOccupationId().longValue());
                timeTableRecord.setWeekDayId(oracleTimeTableRecord.getWeekDayId().longValue());
                timeTableRecord.setOdevityId(oracleTimeTableRecord.getDisciplineId().longValue());
                timeTableRecord.setVariantOccupationId(oracleTimeTableRecord.getVariantOccupationId().longValue());

                timeTableRecord.setCreatTime(new Timestamp(oracleTimeTableRecord.getCreatTime().getTime()));
                timeTableRecord.setUpdateTime(new Timestamp(oracleTimeTableRecord.getUpdateTime().getTime()));

                if (mode == Mode.INSERT) {
                    toInsert.add(timeTableRecord);
                } else {
                    toUpdate.add(timeTableRecord);
                }
            }

        }

    }

    private Connection getSourceOracleConnection() throws SQLException {
        return ConnectionManager.getConnection(URL, USER, PASSWORD);
    }

    private static enum Mode {
        INSERT, UPDATE
    }

}
