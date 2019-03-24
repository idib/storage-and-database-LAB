package com.sadb.transformation.oracle;

import com.sadb.generated.source.oracle.tables.*;
import com.sadb.generated.source.oracle.tables.records.*;
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
/*        Result<LecturerRecord> oracleSourceLecturer =
                contextSourceOracle.select().from(Lecturer.LECTURER).fetch().into(Lecturer.LECTURER);

        Result<com.sadb.generated.dest.oracle.tables.records.LecturerRecord> oracleLectures =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.Lecturer.LECTURER).fetch().into(com.sadb.generated.dest.oracle.tables.Lecturer.LECTURER);


        processOracleLecturer(
                oracleSourceLecturer,
                oracleLectures,
                toInsert,
                toUpdate
        );*/
/*

        // STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS STUDENTS

        Result<StudentRecord> oracleSourceStudents =
                contextOracle.select().from(Student.STUDENT).fetch().into(Student.STUDENT);

        Result<com.sadb.generated.dest.oracle.tables.records.StudentRecord> oracleStudents =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.Student.STUDENT).fetch().into(com.sadb.generated.dest.oracle.tables.Student.STUDENT);


        processOracleStudents(
                oracleSourceStudents,
                oracleStudents,
                toInsert,
                toUpdate
        );
*/

/*        //  FACULTY FACULTY FACULTY FACULTY FACULTY

        Result<FacultyRecord> oracleSourseFaculty =
                contextSourceOracle.select().from(Faculty.FACULTY).fetch().into(Faculty.FACULTY);

        Result<com.sadb.generated.dest.oracle.tables.records.FacultyRecord> oracleFaculty =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.Faculty.FACULTY).fetch().into(com.sadb.generated.dest.oracle.tables.Faculty.FACULTY);

        processFaculty(
                oracleSourseFaculty,
                oracleFaculty,
                toInsert,
                toUpdate
        );*/

/*        Result<ProgramTrackRecord> oracleSourseProgramTrack =
                contextSourceOracle.select().from(ProgramTrack.PROGRAM_TRACK).fetch().into(ProgramTrack.PROGRAM_TRACK);

        Result<com.sadb.generated.dest.oracle.tables.records.ProgramTrackRecord> oracleProgramTrack =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.ProgramTrack.PROGRAM_TRACK).fetch().into(com.sadb.generated.dest.oracle.tables.ProgramTrack.PROGRAM_TRACK);

        processProgramTrack(
                oracleSourseProgramTrack,
                oracleProgramTrack,
                toInsert,
                toUpdate
        );*/

/*        Result<SpecialityRecord> oracleSourseSpeciality =
                contextSourceOracle.select().from(Speciality.SPECIALITY).fetch().into(Speciality.SPECIALITY);

        Result<com.sadb.generated.dest.oracle.tables.records.SpecialityRecord> oracleSpeciality =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.Speciality.SPECIALITY).fetch().into(com.sadb.generated.dest.oracle.tables.Speciality.SPECIALITY);

        processSpeciality(
                oracleSourseSpeciality,
                oracleSpeciality,
                toInsert,
                toUpdate
        );*/

/*        Result<AcademicYearRecord> oracleSourseAcademicYear =
                contextSourceOracle.select().from(AcademicYear.ACADEMIC_YEAR).fetch().into(AcademicYear.ACADEMIC_YEAR);

        Result<com.sadb.generated.dest.oracle.tables.records.AcademicYearRecord> oracleAcademicYear =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.AcademicYear.ACADEMIC_YEAR).fetch().into(com.sadb.generated.dest.oracle.tables.AcademicYear.ACADEMIC_YEAR);

        processAcademicYear(
                oracleSourseAcademicYear,
                oracleAcademicYear,
                toInsert,
                toUpdate
        );*/

/*        Result<ClassRoomRecord> oracleSourseClassRoom =
                contextSourceOracle.select().from(ClassRoom.CLASS_ROOM).fetch().into(ClassRoom.CLASS_ROOM);

        Result<com.sadb.generated.dest.oracle.tables.records.ClassRoomRecord> oracleClassRoom =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.ClassRoom.CLASS_ROOM).fetch().into(com.sadb.generated.dest.oracle.tables.ClassRoom.CLASS_ROOM);

        processClassRoom(
                oracleSourseClassRoom,
                oracleClassRoom,
                toInsert,
                toUpdate
        );*/

/*        Result<FacultyLecturerRecord> oracleSourseFacultyLecturer =
                contextSourceOracle.select().from(FacultyLecturer.FACULTY_LECTURER).fetch().into(FacultyLecturer.FACULTY_LECTURER);

        Result<com.sadb.generated.dest.oracle.tables.records.FacultyLecturerRecord> oracleFacultyLecturer =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.FacultyLecturer.FACULTY_LECTURER).fetch().into(com.sadb.generated.dest.oracle.tables.FacultyLecturer.FACULTY_LECTURER);

        processFacultyLecturer(
                oracleSourseFacultyLecturer,
                oracleFacultyLecturer,
                toInsert,
                toUpdate
        );*/

/*        Result<GroupsRecord> oracleSourseGroups =
                contextSourceOracle.select().from(Groups.GROUPS).fetch().into(Groups.GROUPS);

        Result<com.sadb.generated.dest.oracle.tables.records.GroupsRecord> oracleGroups =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.Groups.GROUPS).fetch().into(com.sadb.generated.dest.oracle.tables.Groups.GROUPS);

        processGroups(
                oracleSourseGroups,
                oracleGroups,
                toInsert,
                toUpdate
        );*/

/*        Result<OccupationRecord> oracleSourseOccupation =
                contextSourceOracle.select().from(Occupation.OCCUPATION).fetch().into(Occupation.OCCUPATION);

        Result<com.sadb.generated.dest.oracle.tables.records.OccupationRecord> oracleOccupation =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.Occupation.OCCUPATION).fetch().into(com.sadb.generated.dest.oracle.tables.Occupation.OCCUPATION);

        processOccupation(
                oracleSourseOccupation,
                oracleOccupation,
                toInsert,
                toUpdate
        );*/

/*        Result<OdevityWeekRecord> oracleSourseOdevityWeek =
                contextSourceOracle.select().from(OdevityWeek.ODEVITY_WEEK).fetch().into(OdevityWeek.ODEVITY_WEEK);

        Result<com.sadb.generated.dest.oracle.tables.records.OdevityWeekRecord> oracleOdevityWeek =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.OdevityWeek.ODEVITY_WEEK).fetch().into(com.sadb.generated.dest.oracle.tables.OdevityWeek.ODEVITY_WEEK);

        processOdevityWeek(
                oracleSourseOdevityWeek,
                oracleOdevityWeek,
                toInsert,
                toUpdate
        );*/

        Result<VariantOccupationRecord> oracleSourseVariantOccupation =
                contextSourceOracle.select().from(VariantOccupation.VARIANT_OCCUPATION).fetch().into(VariantOccupation.VARIANT_OCCUPATION);

        Result<com.sadb.generated.dest.oracle.tables.records.VariantOccupationRecord> oracleVariantOccupation =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.VariantOccupation.VARIANT_OCCUPATION).fetch().into(com.sadb.generated.dest.oracle.tables.VariantOccupation.VARIANT_OCCUPATION);

        processVariantOccupation(
                oracleSourseVariantOccupation,
                oracleVariantOccupation,
                toInsert,
                toUpdate
        );

        Result<WeekDayRecord> oracleSourseWeekDay =
                contextSourceOracle.select().from(WeekDay.WEEK_DAY).fetch().into(WeekDay.WEEK_DAY);

        Result<com.sadb.generated.dest.oracle.tables.records.WeekDayRecord> oracleWeekDay =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.WeekDay.WEEK_DAY).fetch().into(com.sadb.generated.dest.oracle.tables.WeekDay.WEEK_DAY);

        processWeekDay(
                oracleSourseWeekDay,
                oracleWeekDay,
                toInsert,
                toUpdate
        );

/*
        Result<TimeTableRecord> oracleSourseTimeTable =
                contextSourceOracle.select().from(TimeTable.TIME_TABLE).fetch().into(TimeTable.TIME_TABLE);

        Result<com.sadb.generated.dest.oracle.tables.records.TimeTableRecord> oracleTimeTable =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.TimeTable.TIME_TABLE).fetch().into(com.sadb.generated.dest.oracle.tables.TimeTable.TIME_TABLE);

        processTimeTable(
                oracleSourseTimeTable,
                oracleTimeTable,
                toInsert,
                toUpdate
        );
*/


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

/*    private void processOracleStudents(
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

    }*/

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

                if (oldRecord == null) {
                    facultyRecord = new com.sadb.generated.dest.oracle.tables.records.FacultyRecord();
                } else {
                    facultyRecord = oldRecord;
                    facultyRecord.changed(true);
                }

                facultyRecord.setFacId(oracleFacultyRecord.getFacId().longValue());
                facultyRecord.setFacName(oracleFacultyRecord.getFacName());
                facultyRecord.setMegafacId(oracleFacultyRecord.getMegafacId().longValue());
                facultyRecord.setCreatTime(new Timestamp(oracleFacultyRecord.getCreatTime().getTime()));
                facultyRecord.setUpdateTime(new Timestamp(oracleFacultyRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(facultyRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
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

                if (oldRecord == null) {
                    programTrackRecordRecord = new com.sadb.generated.dest.oracle.tables.records.ProgramTrackRecord();
                } else {
                    programTrackRecordRecord = oldRecord;
                    programTrackRecordRecord.changed(true);
                }

                programTrackRecordRecord.setProgId(oracleProgramTrackRecord.getProgId().longValue());
                programTrackRecordRecord.setFacId(oracleProgramTrackRecord.getFacId().longValue());
                programTrackRecordRecord.setProgmName(oracleProgramTrackRecord.getProgmName());
                programTrackRecordRecord.setProgmType(oracleProgramTrackRecord.getProgmType());
                programTrackRecordRecord.setProgramTrackNum(oracleProgramTrackRecord.getProgramTrackNum());
                programTrackRecordRecord.setCreatTime(new Timestamp(oracleProgramTrackRecord.getCreatTime().getTime()));
                programTrackRecordRecord.setUpdateTime(new Timestamp(oracleProgramTrackRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(programTrackRecordRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
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

                if (oldRecord == null) {
                    specialityRecord = new com.sadb.generated.dest.oracle.tables.records.SpecialityRecord();
                } else {
                    specialityRecord = oldRecord;
                    specialityRecord.changed(true);
                }

                specialityRecord.setSpecId(oracleSpecialityRecord.getSpecId().longValue());
                specialityRecord.setProgId(oracleSpecialityRecord.getProgId().longValue());
                specialityRecord.setSpecName(oracleSpecialityRecord.getSpecName());
                if (oracleSpecialityRecord.getFreeEducCount() != null) {
                    specialityRecord.setFreeEducCount(oracleSpecialityRecord.getFreeEducCount().longValue());
                }
                if (oracleSpecialityRecord.getPaidEducCount() != null) {
                    specialityRecord.setPaidEducCount(oracleSpecialityRecord.getPaidEducCount().longValue());
                }
                if (oracleSpecialityRecord.getSponsoredEducCount() != null) {
                    specialityRecord.setSponsoredEducCount(oracleSpecialityRecord.getSponsoredEducCount().longValue());
                }
                specialityRecord.setSpecDegree(oracleSpecialityRecord.getSpecDegree());
                specialityRecord.setCreatTime(new Timestamp(oracleSpecialityRecord.getCreatTime().getTime()));
                specialityRecord.setUpdateTime(new Timestamp(oracleSpecialityRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(specialityRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
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

                if (oldRecord == null) {
                    acodemicYearRecord = new com.sadb.generated.dest.oracle.tables.records.AcademicYearRecord();
                } else {
                    acodemicYearRecord = oldRecord;
                    acodemicYearRecord.changed(true);
                }

                acodemicYearRecord.setAcademYearId(oracleAcademicYearRecord.getAcademYearId().longValue());
                acodemicYearRecord.setAcademYear(oracleAcademicYearRecord.getAcademYear());
                acodemicYearRecord.setCreatTime(new Timestamp(oracleAcademicYearRecord.getCreatTime().getTime()));
                acodemicYearRecord.setUpdateTime(new Timestamp(oracleAcademicYearRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(acodemicYearRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
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

                if (oldRecord == null) {
                    classRoomRecord = new com.sadb.generated.dest.oracle.tables.records.ClassRoomRecord();
                } else {
                    classRoomRecord = oldRecord;
                    classRoomRecord.changed(true);
                }

                classRoomRecord.setClassId(oracleClassRoomRecord.getClassId().longValue());
                if (oracleClassRoomRecord.getClassNumber() != null) {
                    classRoomRecord.setClassNumber(oracleClassRoomRecord.getClassNumber().longValue());
                }
                classRoomRecord.setCreatTime(new Timestamp(oracleClassRoomRecord.getCreatTime().getTime()));
                classRoomRecord.setUpdateTime(new Timestamp(oracleClassRoomRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(classRoomRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
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

                if (oldRecord == null) {
                    facultulecturerRecord = new com.sadb.generated.dest.oracle.tables.records.FacultyLecturerRecord();
                } else {
                    facultulecturerRecord = oldRecord;
                    facultulecturerRecord.changed(true);
                }

                facultulecturerRecord.setFacLectId(oracleFacultyLecturerRecord.getFacLectId().longValue());
                facultulecturerRecord.setFacId(oracleFacultyLecturerRecord.getFacId().longValue());
                facultulecturerRecord.setLecId(oracleFacultyLecturerRecord.getLecId().longValue());
                facultulecturerRecord.setCreatTime(new Timestamp(oracleFacultyLecturerRecord.getCreatTime().getTime()));
                facultulecturerRecord.setUpdateTime(new Timestamp(oracleFacultyLecturerRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(facultulecturerRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
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

                if (oldRecord == null) {
                    groupsRecord = new com.sadb.generated.dest.oracle.tables.records.GroupsRecord();
                } else {
                    groupsRecord = oldRecord;
                    groupsRecord.changed(true);
                }

                groupsRecord.setGroupId(oracleGroupsRecord.getGroupId().longValue());
                groupsRecord.setSpecId(oracleGroupsRecord.getSpecId().longValue());
                groupsRecord.setAcademYearId(oracleGroupsRecord.getAcademYearId().longValue());
                groupsRecord.setGroupNum(oracleGroupsRecord.getGroupNum());
                if (oracleGroupsRecord.getCourse() != null) {
                    groupsRecord.setCourse(oracleGroupsRecord.getCourse().longValue());
                }
                if (oracleGroupsRecord.getEducationTimeFrom() != null){
                    groupsRecord.setEducationTimeFrom(new Timestamp(oracleGroupsRecord.getEducationTimeFrom().getTime()));
                }
                if (oracleGroupsRecord.getEducationTimeTo() != null){
                    groupsRecord.setEducationTimeTo(new Timestamp(oracleGroupsRecord.getEducationTimeTo().getTime()));
                }
                groupsRecord.setCreatTime(new Timestamp(oracleGroupsRecord.getCreatTime().getTime()));
                groupsRecord.setUpdateTime(new Timestamp(oracleGroupsRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(groupsRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
                    toUpdate.add(groupsRecord);
                }
            }

        }

    }

    //Есть проблема в getOccupationTimeFrom и To (String -> TimeStamp)
    private void processOccupation(
            List<OccupationRecord> oracleSourceOccupations,
            List<com.sadb.generated.dest.oracle.tables.records.OccupationRecord> oracleOccupations,
            List<TableRecord<?>> toInsert,
            List<UpdatableRecord<?>> toUpdate) {/*

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

                if (oldRecord == null) {
                    occupationRecord = new com.sadb.generated.dest.oracle.tables.records.OccupationRecord();
                } else {
                    occupationRecord = oldRecord;
                    occupationRecord.changed(true);
                }

                occupationRecord.setOccupationId(oracleOccupationRecord.getOccupationId().longValue());
                if (oracleOccupationRecord.getOccupatonNum() != null) {
                    occupationRecord.setOccupatonNum(oracleOccupationRecord.getOccupatonNum().longValue());
                }
                if (oracleOccupationRecord.getOccupationTimeFrom() != null) {
                    occupationRecord.setOccupationTimeFrom(new Timestamp(oracleOccupationRecord.getOccupationTimeFrom()));
                }
                if (oracleOccupationRecord.getOccupationTimeTo() != null) {
                    occupationRecord.setOccupationTimeTo(Timestamp.valueOf(oracleOccupationRecord.getOccupationTimeTo()));
                }
                occupationRecord.setCreatTime(new Timestamp(oracleOccupationRecord.getCreatTime().getTime()));
                occupationRecord.setUpdateTime(new Timestamp(oracleOccupationRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(occupationRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
                    toUpdate.add(occupationRecord);
                }
            }

        }*/

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

                if (oldRecord == null) {
                    odevityWeekRecord = new com.sadb.generated.dest.oracle.tables.records.OdevityWeekRecord();
                } else {
                    odevityWeekRecord = oldRecord;
                    odevityWeekRecord.changed(true);
                }

                odevityWeekRecord.setOdevityId(oracleOdevityWeekRecord.getOdevityId().longValue());
                odevityWeekRecord.setWeek(oracleOdevityWeekRecord.getWeek());
                odevityWeekRecord.setCreatTime(new Timestamp(oracleOdevityWeekRecord.getCreatTime().getTime()));
                odevityWeekRecord.setUpdateTime(new Timestamp(oracleOdevityWeekRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(odevityWeekRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
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

                if (oldRecord == null) {
                    variantOccupationRecord = new com.sadb.generated.dest.oracle.tables.records.VariantOccupationRecord();
                } else {
                    variantOccupationRecord = oldRecord;
                    variantOccupationRecord.changed(true);
                }

                variantOccupationRecord.setVariantOccupationId(oracleVariantOccupationRecord.getVariantOccupationId().longValue());
                variantOccupationRecord.setVarOccType(oracleVariantOccupationRecord.getVarOccType());
                variantOccupationRecord.setCreatTime(new Timestamp(oracleVariantOccupationRecord.getCreatTime().getTime()));
                variantOccupationRecord.setUpdateTime(new Timestamp(oracleVariantOccupationRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(variantOccupationRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
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

                if (oldRecord == null) {
                    weekDayRecord = new com.sadb.generated.dest.oracle.tables.records.WeekDayRecord();
                } else {
                    weekDayRecord = oldRecord;
                    weekDayRecord.changed(true);
                }

                weekDayRecord.setWeekDayId(oracleWeekDayRecord.getWeekDayId().longValue());
                weekDayRecord.setDay(oracleWeekDayRecord.getDay());
                weekDayRecord.setCreatTime(new Timestamp(oracleWeekDayRecord.getCreatTime().getTime()));
                weekDayRecord.setUpdateTime(new Timestamp(oracleWeekDayRecord.getUpdateTime().getTime()));

                if (oracleRecordUpdateDate == null) {
                    toInsert.add(weekDayRecord);
                } else if (oracleSourceRecordUpdateDate.after(oracleRecordUpdateDate)) {
                    toUpdate.add(weekDayRecord);
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
