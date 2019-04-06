package com.sadb.fill;

import com.sadb.generated.dest.oracle.tables.ListParticipantProject;
import com.sadb.generated.dest.oracle.tables.records.*;
import com.sadb.transformation.ConnectionManager;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.TableRecord;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OracleFillService {

    private static Connection connection;

    public static void main(String[] args) {
        connection = ConnectionManager.getDestDBConnection();
        //s2_BLOCK();
        //s2_ROOM();
        //s2_FACULTY();
        //s2_PROGRAMTRACK();
        //s2_SPECIALITY();
        //s2_GROUP();
        //s2_STUDENT();
        //s2_READER_SHEET();

        //s3_EVENTS();
        //s3_FACULTY_LECTURER();
        //s3_LIST_PARTICIPANT();
        //s3_LIST_PARTICIPANT_PROJECT();

        //s4_PUBLICATIONS();

        //s5_RESULTS();

        //s6_TIME_TABLE();
    }

    private static void s2_BLOCK() {
        List<TableRecord<?>> recordList = new ArrayList<>();
        for (long i = 5; i < 10000; i++) {
            BlockRecord blockRecord = new BlockRecord();
            blockRecord.setId(i);
            blockRecord.setDormId(r_long(1, 30));
            blockRecord.setFloor(r_long(1, 12));
            blockRecord.setDateDisinsection(new Date(r_int(110, 119), r_int(1, 12), r_int(1, 28)));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            blockRecord.setDateCreate(timestamp);
            blockRecord.setDateUpdate(timestamp);
            blockRecord.changed(true);
            recordList.add(blockRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }

    private static void s2_ROOM() {
        List<TableRecord<?>> recordList = new ArrayList<>();
        for (long i = 10; i < 30000; i++) {
            RoomRecord roomRecord = new RoomRecord();
            roomRecord.setId(i);
            long blockId = r_long(1, 9999);
            roomRecord.setBlockId(blockId);
            roomRecord.setMaxStudent(r_long(1, 4));
            roomRecord.setNumberroom(blockId + "-" + String.valueOf(r_int(1, 4)));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            roomRecord.setDateCreate(timestamp);
            roomRecord.setDateUpdate(timestamp);
            roomRecord.changed(true);
            recordList.add(roomRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }

    private static void s2_FACULTY() {
        List<TableRecord<?>> recordList = new ArrayList<>();

        String[] part1 = {"Веб", "Оптических", "Пищевых", "Программных", "Лазерных", "Урбанистических"};

        String[] part2 = {"Машин", "Технологий", "Сервисов", "Приборов"};

        for (long i = 4; i < 21; i++) {
            FacultyRecord facultyRecord = new FacultyRecord();

            facultyRecord.setFacId(i);

            facultyRecord.setFacName("Факультет " +
                    part1[r_int(0, part1.length - 1)] + " " +
                    part2[r_int(0, part2.length - 1)] +
                    " и " +
                    part1[r_int(0, part1.length - 1)] + " " +
                    part2[r_int(0, part2.length - 1)]);

            facultyRecord.setMegafacId(r_long(1, 4));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            facultyRecord.setCreatTime(timestamp);
            facultyRecord.setUpdateTime(timestamp);
            facultyRecord.changed(true);
            recordList.add(facultyRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }


    private static void s2_PROGRAMTRACK() {
        List<TableRecord<?>> recordList = new ArrayList<>();

        String[] part1 = {"Веб", "Оптические", "Пищевые", "Программные", "Лазерные", "Урбанистические"};

        String[] part2 = {"Машины", "Технологии", "Сервисы", "Приборы"};

        for (long i = 3; i < 101; i++) {
            ProgramTrackRecord programRecord = new ProgramTrackRecord();

            programRecord.setProgId(i);
            programRecord.setProgmName(part1[r_int(0, part1.length - 1)] + " " + part2[r_int(0, part2.length - 1)]);
            programRecord.setFacId(r_long(1, 20));

            programRecord.setProgramTrackNum("09.0" + String.valueOf(r_int(1, 3)) + ".0" + String.valueOf(r_int(1, 7)));
            programRecord.setProgmType("FULL_TIME");

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            programRecord.setCreatTime(timestamp);
            programRecord.setUpdateTime(timestamp);
            programRecord.changed(true);
            recordList.add(programRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }


    private static void s2_SPECIALITY() {
        List<TableRecord<?>> recordList = new ArrayList<>();

        String[] part1 = {"Веб", "Оптические", "Пищевые", "Программные", "Лазерные", "Урбанистические"};

        String[] part2 = {"Машины", "Технологии", "Сервисы", "Приборы"};

        for (long i = 4; i < 101; i++) {
            SpecialityRecord specRecord = new SpecialityRecord();

            specRecord.setSpecId(i);
            specRecord.setSpecName(part1[r_int(0, part1.length - 1)] + " " + part2[r_int(0, part2.length - 1)]);

            if (r_boolean()) {
                specRecord.setSpecDegree("BACHELOR");
            } else {
                specRecord.setSpecDegree("MAGISTER");
            }

            specRecord.setFreeEducCount(r_long(10, 150));
            specRecord.setPaidEducCount(r_long(50, 400));
            specRecord.setProgId(r_long(1, 100));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            specRecord.setCreatTime(timestamp);
            specRecord.setUpdateTime(timestamp);
            specRecord.changed(true);
            recordList.add(specRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }

    private static void s2_GROUP() {

        String[] prefixes = {"V", "P", "O", "L", "K", "F", "S", "T"};

        List<TableRecord<?>> recordList = new ArrayList<>();
        for (long i = 4; i < 200; i++) {
            GroupsRecord groupRecord = new GroupsRecord();

            long course = r_long(1, 4);
            groupRecord.setGroupId(i);
            groupRecord.setAcademYearId(r_long(1, 11));
            groupRecord.setSpecId(r_long(1, 100));
            groupRecord.setGroupNum(prefixes[r_int(0, prefixes.length - 1)] + r_long(3,4) + course + r_int(1,2) + r_int(1,2));
            groupRecord.setCourse(course);


            int year = r_int(110, 119);
            groupRecord.setEducationTimeFrom(new Timestamp(new Date(year, 9, 1).getTime()));
            groupRecord.setEducationTimeTo(new Timestamp(new Date(year + 1, 6, 30).getTime()));



            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            groupRecord.setCreatTime(timestamp);
            groupRecord.setUpdateTime(timestamp);
            groupRecord.changed(true);
            recordList.add(groupRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }


    private static void s2_STUDENT() {
        String[] maleLastNames = {"Иванов", "Алексеев", "Рузанов", "Миронычев", "Бабушкин", "Прокин", "Ягнышев", "Петров",
                "Тихонов", "Максименко", "Карапетян", "Нестеров", "Слободкин", "Литвинов", "Губарев", "Разумовский"};

        String[] maleNames = {"Егор", "Дмитрий", "Алексей", "Илья", "Павел", "Петр", "Иван", "Максим", "Юрий", "Юлий",
                "Вячеслав", "Владислав", "Азат", "Евгений"};

        String[] maleSecondNames = {"Егорович", "Дмитриевич", "Алексеевич", "Ильич", "Павлович", "Петрович", "Иванович",
                "Максимович", "Юрьевич", "Робертович", "Азатович"};

        String[] femaleLastNames = {"Иванова", "Алексеева", "Рузанова", "Миронычева", "Бабушкина", "Прокина",
                "Ягнышева", "Петрова", "Тихонова", "Максименко", "Карапетян", "Нестерова", "Слободкина", "Литвинова",
                "Губарева", "Разумовская"};

        String[] femaleNames = {"Анастасия", "Яна", "Ольга", "Светлана", "Людмила", "Мария", "Марина", "Василиса",
                "Лилия", "Юлия", "Евгения", "Александра", "Екатерина", "Маргарита"};

        String[] femaleSecondNames = {"Егоровна", "Дмитриевна", "Алексеевна", "Павловна", "Петровна", "Ивановна",
                "Максимовна", "Игоревна"};

        String[] educationPlaces = {"Кронверкский проспект, 49", "Гривцова 10", "Ломоносова 16", "Чайковского 20", "2 линия В.О. 10"};

        String[] birthPlace = {"Краснодар", "Новосибирск", "Москва", "Санкт-Петербург", "Саратов", "Самара", "Саранск", "Омск", "Смоленск",
        "Орел", "Луга", "Пермь", "Владивосток", "Норильск", "Екатеринбург"};


        List<TableRecord<?>> recordList = new ArrayList<>();
        for (long i = 450000; i < 600001; i++) {

            if (i == 182124 || i == 182125) {
                continue;
            }
            StudentRecord studentRecord = new StudentRecord();
            studentRecord.setId(BigDecimal.valueOf(i));

            if (r_boolean()) {
                studentRecord.setName(femaleNames[r_int(0, femaleNames.length - 1)]);
                studentRecord.setSurname(femaleLastNames[r_int(0, femaleLastNames.length - 1)]);
                studentRecord.setSecondName(femaleSecondNames[r_int(0, femaleSecondNames.length - 1)]);
            } else {
                studentRecord.setName(maleNames[r_int(0, maleNames.length - 1)]);
                studentRecord.setSurname(maleLastNames[r_int(0, maleLastNames.length - 1)]);
                studentRecord.setSecondName(maleSecondNames[r_int(0, maleSecondNames.length - 1)]);
            }

            studentRecord.setSemester(BigDecimal.valueOf(r_long(1, 10)));
            studentRecord.setUniversity("Университет ИТМО");
            studentRecord.setEducationPlace(educationPlaces[r_int(0, educationPlaces.length - 1)]);

            if (r_boolean()) {
                studentRecord.setRoomId(r_long(1, 29999));
                studentRecord.setDateCheckin(new Date(r_int(113, 119), r_int(1, 12), r_int(1, 28)));
                studentRecord.setDateCheckout(new Date(r_int(119, 124), r_int(1, 12), r_int(1, 28)));
            }

            if (r_int(1, 10) > 2) {
                studentRecord.setFormEducation("Очная");
            } else {
                studentRecord.setFormEducation("Заочная");
            }

            studentRecord.setPositionId(r_long(1, 3));

            studentRecord.setGroupId(r_long(1, 199));

            studentRecord.setRoomId(r_long(1, 29999));
            studentRecord.setDateCheckin(new Date(r_int(112, 118), r_int(1, 12), r_int(1, 28)));
            studentRecord.setDateCheckout(new Date(r_int(119, 123), r_int(1, 12), r_int(1, 28)));

            studentRecord.setBirthPlace(birthPlace[r_int(0, birthPlace.length - 1)]);
            studentRecord.setBirthDate(new Timestamp(new Date(r_int(85, 101), r_int(1, 12), r_int(1, 28)).getTime()));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            studentRecord.setCreationDate(timestamp);
            studentRecord.setUpdationDate(timestamp);
            studentRecord.changed(true);
            recordList.add(studentRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();

    }



    private static void s2_READER_SHEET() {
        List<TableRecord<?>> recordList = new ArrayList<>();
        for (long i = 6; i < 200000; i++) {
            ReaderSheetRecord readerSheetRecord = new ReaderSheetRecord();
            readerSheetRecord.setId(i);
            readerSheetRecord.setParticipantId(r_long(100000, 600000));
            readerSheetRecord.setTitleBook("Книга " + r_long(1, 10000));
            readerSheetRecord.setDateTake(new Date(r_int(112, 119), r_int(1, 12), r_int(1, 28)));
            readerSheetRecord.setDatePut(new Date(r_int(112, 119), r_int(1, 12), r_int(1, 28)));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            readerSheetRecord.setDataCreate(timestamp);
            readerSheetRecord.setDataUpdate(timestamp);
            readerSheetRecord.changed(true);
            recordList.add(readerSheetRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }




    private static void s3_EVENTS() {
        List<TableRecord<?>> recordList = new ArrayList<>();
        for (long i = 1; i < 100_000; i++) {
            EventsRecord eventRecord = new EventsRecord();
            eventRecord.setId(i);
            eventRecord.setStudentId(r_long(100_000, 600_000));
            eventRecord.setEventTypeId(r_long(1, 4));
            eventRecord.setDatetime(new Timestamp(new Date(r_int(112, 119), r_int(1, 12), r_int(1, 28)).getTime()));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            eventRecord.setDateCreate(timestamp);
            eventRecord.setDateUpdate(timestamp);
            eventRecord.changed(true);
            recordList.add(eventRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }

    private static void s3_FACULTY_LECTURER() {
        List<TableRecord<?>> recordList = new ArrayList<>();
        for (long i = 4; i < 102; i++) {
            FacultyLecturerRecord facultyLecturerRecord = new FacultyLecturerRecord();
            facultyLecturerRecord.setFacLectId(i);
            facultyLecturerRecord.setLecId(i);
            facultyLecturerRecord.setFacId(r_long(1, 20));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            facultyLecturerRecord.setCreatTime(timestamp);
            facultyLecturerRecord.setUpdateTime(timestamp);
            facultyLecturerRecord.changed(true);
            recordList.add(facultyLecturerRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }

    private static void s3_LIST_PARTICIPANT() {
        List<TableRecord<?>> recordList = new ArrayList<>();
        for (long i = 5; i < 250_000; i++) {
            ListParticipantRecord participantRecord = new ListParticipantRecord();
            participantRecord.setParticipantId(r_long(100_000, 600_000));
            participantRecord.setConferenceId(r_long(1, 50));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            participantRecord.setDataCreate(timestamp);
            participantRecord.setDataUpdate(timestamp);
            participantRecord.changed(true);
            recordList.add(participantRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }

    private static void s3_LIST_PARTICIPANT_PROJECT() {
        List<TableRecord<?>> recordList = new ArrayList<>();
        for (long i = 5; i < 37; i++) {
            ListParticipantProjectRecord participantProjectRecord = new ListParticipantProjectRecord();
            participantProjectRecord.setParticipantId(r_long(100_000, 600_000));
            participantProjectRecord.setProjectId(r_long(1, 37));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            participantProjectRecord.setDataCreate(timestamp);
            participantProjectRecord.setDataUpdate(timestamp);
            participantProjectRecord.changed(true);
            recordList.add(participantProjectRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }





    private static void s4_PUBLICATIONS() {
        List<TableRecord<?>> recordList = new ArrayList<>();

        String[] part1 = {"сингулярных", "оптических", "пищевых", "движущихся", "лазерных", "Урбанистических"};

        String[] part2 = {"машин", "технологий", "сервисов", "приборов", "частиц"};

        for (long i = 4; i < 100_000; i++) {
            PublicationsRecord publicationRecord = new PublicationsRecord();

            publicationRecord.setId(i);

            publicationRecord.setTitleEdition("Исследование " + part1[r_int(0, part1.length - 1)] + " " + part2[r_int(0, part2.length - 1)]);

            if (r_boolean()) {
                publicationRecord.setLanguagePublication("Русский");
            } else {
                publicationRecord.setLanguagePublication("Английский");
            }

            publicationRecord.setVolumeEdition(r_int(5, 110) + " страниц");

            publicationRecord.setPlaceEditon("Санкт-Петербург");
            publicationRecord.setEditionId(r_long(1, 48));
            publicationRecord.setCoAuthors("-");
            publicationRecord.setCitationIndex((double) r_long(1, 8));

            publicationRecord.setDataPublication(new Date(r_int(112, 119), r_int(1, 12), r_int(1, 28)));

            publicationRecord.setParticipantId(r_long(100_000, 600_000));
            publicationRecord.setIdTypePublication(r_long(1, 6));


            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            publicationRecord.setDataCreate(timestamp);
            publicationRecord.setDataUpdate(timestamp);
            publicationRecord.changed(true);
            recordList.add(publicationRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }




    private static void s5_RESULTS() {
        List<TableRecord<?>> recordList = new ArrayList<>();


        for (long i = 800_001; i < 1_000_001; i++) {
            ResultsRecord resultRecord = new ResultsRecord();
            resultRecord.setResultId(i);
            resultRecord.setAcademYearId(r_long(1, 11));
            resultRecord.setDisciplineId(r_long(1, 500));
            resultRecord.setStudentId(r_long(100_000, 600_000));
            resultRecord.setTeacherId(r_long(1, 102));
            if (r_boolean()) {
                resultRecord.setExType(String.valueOf("PASS_FAIL_EXAM"));
                resultRecord.setResultEu(String.valueOf(2));
                resultRecord.setResult(String.valueOf(r_long(1, 11)));
            } else {
                resultRecord.setExType(String.valueOf("EXAM"));
                resultRecord.setResultEu(String.valueOf(r_int(3, 5)));
                resultRecord.setResult(String.valueOf(r_long(12, 20)));
            }

            resultRecord.setResultDate(new Timestamp(new Date(r_int(112, 119), r_int(1, 12), r_int(1, 28)).getTime()));


            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            resultRecord.setCreatTime(timestamp);
            resultRecord.setUpdateTime(timestamp);
            resultRecord.changed(true);
            recordList.add(resultRecord);
        }
        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
        contextOracle.batchInsert(recordList).execute();
    }




//    private static void s6_TIME_TABLE() {
//        List<TableRecord<?>> recordList = new ArrayList<>();
//
//
//        for (long i = 1; i < 10; i++) {
//            TimeTableRecord timeTableRecord = new TimeTableRecord();
//
//            timeTableRecord.setClassId(r_long(1, 334));
//            timeTableRecord.setDisciplineId(r_long(1, 500));
//            timeTableRecord.setGroupId(r_long(1, 199));
//            timeTableRecord.setOccupationId(r_long(1, 8));
//            timeTableRecord.setOdevityId(r_long(1, 2));
//            timeTableRecord.setVariantOccupationId(r_long(1, 2));
//            timeTableRecord.setWeekDayId(r_long(1, 7));
//
//
//            recordList.add(timeTableRecord);
//        }
//        DSLContext contextOracle = DSL.using(connection, SQLDialect.ORACLE);
//        contextOracle.batchInsert(recordList).execute();
//    }


    private static long r_long(int begin, int end) {
        return r_int(begin, end);
    }

    private static int r_int(int begin, int end) {
        return ThreadLocalRandom.current().nextInt(begin, end + 1);
    }

    private static boolean r_boolean() {
        return new Random().nextBoolean();
    }
}
