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

        Result<SpecialityRecord> oracleSourseSpeciality =
                contextSourceOracle.select().from(Speciality.SPECIALITY).fetch().into(Speciality.SPECIALITY);

        Result<com.sadb.generated.dest.oracle.tables.records.SpecialityRecord> oracleSpeciality =
                contextOracle.select().from(com.sadb.generated.dest.oracle.tables.Speciality.SPECIALITY).fetch().into(com.sadb.generated.dest.oracle.tables.Speciality.SPECIALITY);

        processSpeciality(
                oracleSourseSpeciality,
                oracleSpeciality,
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
