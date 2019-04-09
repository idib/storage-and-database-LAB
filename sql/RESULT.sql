create sequence TYPE_POSITION_SEQ
/

create sequence CONFERENCE_SEQ
/

create sequence PUBLICATIONS_SEQ
/

create sequence TYPE_EDITION_SEQ
/

create sequence TYPE_PUBLICATION_SEQ
/

create sequence SCIENTIFIC_PROJECT_SEQ
/

create sequence READER_SHEET_SEQ
/

create sequence DORMITORY_SEQ
/

create sequence BLOCK_SEQ
/

create sequence ROOM_SEQ
/

create sequence FORM_EDUCATION_SEQ
/

create sequence EVENTS_SEQ
/

create sequence EVENT_TYPE_SEQ
/

create sequence SYNC_LOG_SEQ
/

create table DISCIPLINE
(
  DISCIPLINE_ID NUMBER(10) not null
    constraint XPK_DISCIPLINE
    primary key,
  DISCIPLINE_NAME VARCHAR2(150),
  LECTIONS_HOURS NUMBER,
  PRACTICALS_HOURS NUMBER,
  LABS_HOUES NUMBER,
  EDUCATION_STANDART_TYPE VARCHAR2(255),
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table LECTURER
(
  LEC_ID NUMBER(10) not null
    constraint XPK_LECTURER
    primary key,
  SECOND_NAME VARCHAR2(50),
  FIRST_NAME VARCHAR2(50),
  PATRONYMIC_NAME VARCHAR2(50),
  BIRTH_DATE TIMESTAMP(0),
  BIRTH_PLACE VARCHAR2(255),
  POST VARCHAR2(100),
  WORK_PERIOD_FROM TIMESTAMP(0),
  WORK_PERIOD_TO TIMESTAMP(0),
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table ACADEMIC_YEAR
(
  ACADEM_YEAR VARCHAR2(20),
  ACADEM_YEAR_ID NUMBER(10) not null
    constraint XPK_ACADEMIC_YEAR
    primary key,
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table CLASS_ROOM
(
  CLASS_ID NUMBER(10) not null
    constraint XPK_CLASS_ROOM
    primary key,
  CLASS_NUMBER NUMBER(10),
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table MEGAFACULTY
(
  MEGAFAC_ID NUMBER(10) not null
    constraint XPK_MFAC
    primary key,
  MFACULTY_NAME VARCHAR2(255),
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table FACULTY
(
  FAC_ID NUMBER(10) not null
    constraint XPK_FAC
    primary key,
  FAC_NAME VARCHAR2(150),
  MEGAFAC_ID NUMBER(10) not null
    constraint R_33
    references MEGAFACULTY,
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table FACULTY_LECTURER
(
  LEC_ID NUMBER(10) not null
    constraint R_16
    references LECTURER,
  FAC_ID NUMBER(10) not null
    constraint R_15
    references FACULTY,
  FAC_LECT_ID NUMBER(10) not null
    constraint XPK_FAC_LECTUR
    primary key,
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table OCCUPATION
(
  OCCUPATION_ID NUMBER(10) not null
    constraint XPK_OCCUPATION
    primary key,
  OCCUPATON_NUM NUMBER(10),
  OCCUPATION_TIME_FROM VARCHAR2(25) default NULL,
  OCCUPATION_TIME_TO VARCHAR2(25) default NULL,
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table ODEVITY_WEEK
(
  ODEVITY_ID NUMBER(10) not null
    constraint XPK_ODEVITY_WEEK
    primary key,
  WEEK VARCHAR2(20)
    constraint VR_WEEK
    check (WEEK IN ('EVEN', 'UNEVER')),
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table PROGRAM_TRACK
(
  PROG_ID NUMBER(10) not null
    constraint XPK_PROGRAM_TRACK
    primary key,
  FAC_ID NUMBER(10)
    constraint R_4
    references FACULTY,
  PROGM_NAME VARCHAR2(150),
  PROGRAM_TRACK_NUM VARCHAR2(20),
  PROGM_TYPE VARCHAR2(20)
    constraint VR_TYPE
    check (PROGM_TYPE IN ('FULL_TIME', 'PART_TIME')),
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table SPECIALITY
(
  SPEC_ID NUMBER(10) not null
    constraint XPK_PROGR_SPECIALITY
    primary key,
  SPEC_NAME VARCHAR2(255),
  SPEC_NUMBER VARCHAR2(20),
  SPEC_DEGREE VARCHAR2(10)
    constraint VR_DEGREE
    check (SPEC_DEGREE IN ('MAGISTER', 'BACHELOR')),
  FREE_EDUC_COUNT NUMBER(10),
  PAID_EDUC_COUNT NUMBER(10),
  SPONSORED_EDUC_COUNT NUMBER(10),
  PROG_ID NUMBER(10)
    constraint R_26
    references PROGRAM_TRACK,
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table GROUPS
(
  GROUP_ID NUMBER(10) not null
    constraint XPK_GROUP
    primary key,
  SPEC_ID NUMBER(10)
    constraint R_6
    references SPECIALITY,
  GROUP_NUM VARCHAR2(20),
  COURSE NUMBER(10),
  EDUCATION_TIME_FROM TIMESTAMP(0),
  EDUCATION_TIME_TO TIMESTAMP(0),
  ACADEM_YEAR_ID NUMBER(10) not null
    constraint R_29
    references ACADEMIC_YEAR,
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table VARIANT_OCCUPATION
(
  VARIANT_OCCUPATION_ID NUMBER(10) not null
    constraint XPK_ARIANT_OCC
    primary key,
  VAR_OCC_TYPE VARCHAR2(20)
    constraint VR_OCCUPATION_TYPE
    check (VAR_OCC_TYPE IN ('LECTURE', 'PRACTIC')),
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table WEEK_DAY
(
  WEEK_DAY_ID NUMBER(10) not null
    constraint XPK_WEEK_DAY
    primary key,
  DAY VARCHAR2(20)
    constraint VR_DAY
    check (DAY IN
           ('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY')),
  CREAT_TIME TIMESTAMP(0),
  UPDATE_TIME TIMESTAMP(0)
)
/

create table TYPE_POSITION
(
  ID NUMBER(10) not null
    primary key,
  NAME VARCHAR2(255) not null,
  DATA_UPDATE TIMESTAMP(0) not null,
  DATA_CREATE TIMESTAMP(0) not null
)
/

create table CONFERENCE
(
  ID NUMBER(10) not null
    primary key,
  NAME VARCHAR2(500) default NULL not null,
  VENUE VARCHAR2(255) not null,
  DATE_CONFERENCE DATE not null,
  DATA_UPDATE TIMESTAMP(0) not null,
  DATA_CREATE TIMESTAMP(0) not null
)
/

create table TYPE_EDITION
(
  ID NUMBER(10) not null
    primary key,
  NAME VARCHAR2(500) default NULL not null,
  DATA_UPDATE TIMESTAMP(0) not null,
  DATA_CREATE TIMESTAMP(0) not null
)
/

create table TYPE_PUBLICATION
(
  ID NUMBER(10) not null
    primary key,
  NAME VARCHAR2(255) not null,
  DATA_UPDATE TIMESTAMP(0) not null,
  DATA_CREATE TIMESTAMP(0) not null
)
/

create table SCIENTIFIC_PROJECT
(
  ID NUMBER(10) not null
    primary key,
  NAME VARCHAR2(255) not null,
  PERIOD_PARTICIPATION VARCHAR2(255) not null,
  DATA_UPDATE TIMESTAMP(0) not null,
  DATA_CREATE TIMESTAMP(0) not null
)
/

create table DORMITORY
(
  ID NUMBER(10) not null
    constraint DORMITORY_PK
    primary key,
  NAME CLOB not null,
  ADDRESS CLOB not null,
  DATE_UPDATE TIMESTAMP(6) not null,
  DATE_CREATE TIMESTAMP(6) not null
)
/

create trigger DORMITORY_SEQ_TR
  before insert
  on DORMITORY
  for each row when (NEW.id IS NULL)
  BEGIN
    SELECT dormitory_seq.NEXTVAL INTO :NEW.id FROM DUAL;
  END;
/

create table BLOCK
(
  ID NUMBER(10) not null
    constraint BLOCK_PK
    primary key,
  FLOOR NUMBER(10) not null,
  DATE_DISINSECTION DATE not null,
  DORM_ID NUMBER(10) not null
    constraint BLOCK_FK0
    references DORMITORY,
  DATE_UPDATE TIMESTAMP(6) not null,
  DATE_CREATE TIMESTAMP(6) not null
)
/

create trigger BLOCK_SEQ_TR
  before insert
  on BLOCK
  for each row when (NEW.id IS NULL)
  BEGIN
    SELECT block_seq.NEXTVAL INTO :NEW.id FROM DUAL;
  END;
/

create table ROOM
(
  ID NUMBER(10) not null
    constraint ROOM_PK
    primary key,
  NUMBERROOM VARCHAR2(255) not null,
  MAX_STUDENT NUMBER(10) not null,
  BLOCK_ID NUMBER(10) not null
    constraint ROOM_FK0
    references BLOCK,
  DATE_UPDATE TIMESTAMP(6) not null,
  DATE_CREATE TIMESTAMP(6) not null
)
/

create table STUDENT
(
  ID NUMBER not null
    primary key,
  NAME VARCHAR2(255) default NULL,
  SURNAME VARCHAR2(255) default NULL,
  SECOND_NAME VARCHAR2(255) default NULL,
  UNIVERSITY VARCHAR2(255) default NULL,
  EDUCATION_PLACE VARCHAR2(255) default NULL,
  SPECIALITY VARCHAR2(255) default null,
  SEMESTER NUMBER default NULL,
  CREATION_DATE TIMESTAMP(6),
  UPDATION_DATE TIMESTAMP(6),
  CONCESSION CHAR default NULL,
  ROOM_ID NUMBER(10) default NULL
    constraint STUDENT_FK0
    references ROOM,
  DATE_CHECKIN DATE default NULL,
  DATE_CHECKOUT DATE default NULL,
  FORM_EDUCATION VARCHAR2(255) default NULL,
  POSITION_ID NUMBER(10) default NULL
    constraint PARTICIPANT_FK0
    references TYPE_POSITION,
  GROUP_ID NUMBER(10) default NULL,
  BIRTH_DATE TIMESTAMP(6) default NULL,
  BIRTH_PLACE VARCHAR2(255) default NULL,
  EDUCATION_TYPE VARCHAR2(255) default null
)
/

create table RESULTS
(
  RESULT VARCHAR2(20) default null,
  EX_TYPE VARCHAR2(20) default null
    constraint VR_RESULT_TYPE
    check (EX_TYPE IN ('EXAM', 'PASS_FAIL_EXAM')),
  DISCIPLINE_ID NUMBER(10) default NULL
    constraint R_18
    references DISCIPLINE,
  RESULT_DATE TIMESTAMP(0) default null,
  RESULT_EU VARCHAR2(20) default null,
  ACADEM_YEAR_ID NUMBER(10) default NULL
    constraint R_31
    references ACADEMIC_YEAR,
  RESULT_ID NUMBER(10) not null
    constraint XPK_RESULTS
    primary key,
  STUDENT_ID NUMBER(10) default NULL
    constraint R_17
    references STUDENT,
  CREAT_TIME TIMESTAMP(0) default null,
  UPDATE_TIME TIMESTAMP(0) default null,
  TEACHER_ID NUMBER(10) default NULL
    constraint RESULTS_FK1
    references LECTURER
)
/

create table PUBLICATIONS
(
  ID NUMBER(10) not null
    primary key,
  TITLE_EDITION VARCHAR2(255) not null,
  LANGUAGE_PUBLICATION VARCHAR2(255) not null,
  VOLUME_EDITION VARCHAR2(255) not null,
  PLACE_EDITON VARCHAR2(255) not null,
  EDITION_ID NUMBER(10) not null
    constraint PUBLICATIONS_FK0
    references TYPE_EDITION,
  CO_AUTHORS VARCHAR2(255) not null,
  CITATION_INDEX BINARY_DOUBLE not null,
  DATA_PUBLICATION DATE not null,
  PARTICIPANT_ID NUMBER(10) not null
    constraint PUBLICATIONS_FK1
    references STUDENT,
  ID_TYPE_PUBLICATION NUMBER(10) not null
    constraint PUBLICATIONS_FK2
    references TYPE_PUBLICATION,
  DATA_UPDATE TIMESTAMP(0) not null,
  DATA_CREATE TIMESTAMP(0) not null
)
/

create table READER_SHEET
(
  ID NUMBER(10) not null
    primary key,
  PARTICIPANT_ID NUMBER(10) not null
    constraint READER_SHEET_FK0
    references STUDENT,
  TITLE_BOOK VARCHAR2(255) not null,
  DATE_TAKE DATE not null,
  DATE_PUT DATE not null,
  DATA_UPDATE TIMESTAMP(0) not null,
  DATA_CREATE TIMESTAMP(0) not null
)
/

create table LIST_PARTICIPANT
(
  PARTICIPANT_ID NUMBER(10) not null
    constraint LIST_PARTICIPANT_FK0
    references STUDENT,
  CONFERENCE_ID NUMBER(10) not null
    constraint LIST_PARTICIPANT_FK1
    references CONFERENCE,
  DATA_UPDATE TIMESTAMP(0) not null,
  DATA_CREATE TIMESTAMP(0) not null
)
/

create table LIST_PARTICIPANT_PROJECT
(
  PARTICIPANT_ID NUMBER(10) not null
    constraint LIST_PARTICIPANT_PROJECT_FK0
    references STUDENT,
  PROJECT_ID NUMBER(10) not null
    constraint LIST_PARTICIPANT_PROJECT_FK1
    references SCIENTIFIC_PROJECT,
  DATA_UPDATE TIMESTAMP(0) not null,
  DATA_CREATE TIMESTAMP(0) not null
)
/

create trigger ROOM_SEQ_TR
  before insert
  on ROOM
  for each row when (NEW.id IS NULL)
  BEGIN
    SELECT room_seq.NEXTVAL INTO :NEW.id FROM DUAL;
  END;
/

create table EVENT_TYPE
(
  ID NUMBER(10) not null
    constraint EVENT_TYPE_PK
    primary key,
  NAME VARCHAR2(255) not null,
  DATE_UPDATE TIMESTAMP(6) not null,
  DATE_CREATE TIMESTAMP(6) not null
)
/

create table EVENTS
(
  ID NUMBER(10) not null
    constraint EVENTS_PK
    primary key,
  STUDENT_ID NUMBER(10) not null
    constraint EVENTS_FK0
    references STUDENT,
  EVENT_TYPE_ID NUMBER(10) not null
    constraint EVENTS_FK1
    references EVENT_TYPE,
  DATETIME TIMESTAMP(6) not null,
  DATE_UPDATE TIMESTAMP(6) not null,
  DATE_CREATE TIMESTAMP(6) not null
)
/

create trigger EVENTS_SEQ_TR
  before insert
  on EVENTS
  for each row when (NEW.id IS NULL)
  BEGIN
    SELECT events_seq.NEXTVAL INTO :NEW.id FROM DUAL;
  END;
/

create trigger EVENT_TYPE_SEQ_TR
  before insert
  on EVENT_TYPE
  for each row when (NEW.id IS NULL)
  BEGIN
    SELECT event_type_seq.NEXTVAL INTO :NEW.id FROM DUAL;
  END;
/

create table DB
(
  ID NUMBER not null
    primary key,
  NAME VARCHAR2(50) not null
)
/

create table SYNC_LOG
(
  ID NUMBER not null,
  DB_TYPE NUMBER not null
    constraint SYNC_LOG_DB_ID_FK
    references DB,
  TIMESTAMP TIMESTAMP(0) default NULL not null
)
/

create unique index SYNC_LOG_ID_UINDEX
  on SYNC_LOG (ID)
/

alter table SYNC_LOG
  add constraint SYNC_LOG_PK
primary key (ID)
/

create table TIME_TABLE
(
  WEEK_DAY_ID NUMBER not null,
  OCCUPATION_ID NUMBER not null,
  ODEVITY_ID NUMBER not null,
  VARIANT_OCCUPATION_ID NUMBER not null,
  CLASS_ID NUMBER not null,
  GROUP_ID NUMBER not null,
  DISCIPLINE_ID NUMBER not null,
  CREAT_TIME DATE,
  UPDATE_TIME DATE,
  TIME_TABLE_ID NUMBER not null
    constraint XPK_TIME_TABLE
    primary key
)
/

