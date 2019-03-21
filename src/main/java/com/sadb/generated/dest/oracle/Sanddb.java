/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle;


import com.sadb.generated.dest.oracle.tables.AcademicYear;
import com.sadb.generated.dest.oracle.tables.Block;
import com.sadb.generated.dest.oracle.tables.ClassRoom;
import com.sadb.generated.dest.oracle.tables.Conference;
import com.sadb.generated.dest.oracle.tables.Db;
import com.sadb.generated.dest.oracle.tables.Discipline;
import com.sadb.generated.dest.oracle.tables.Dormitory;
import com.sadb.generated.dest.oracle.tables.EventType;
import com.sadb.generated.dest.oracle.tables.Events;
import com.sadb.generated.dest.oracle.tables.Faculty;
import com.sadb.generated.dest.oracle.tables.FacultyLecturer;
import com.sadb.generated.dest.oracle.tables.FormEducation;
import com.sadb.generated.dest.oracle.tables.Groups;
import com.sadb.generated.dest.oracle.tables.Lecturer;
import com.sadb.generated.dest.oracle.tables.ListParticipant;
import com.sadb.generated.dest.oracle.tables.ListParticipantProject;
import com.sadb.generated.dest.oracle.tables.Megafaculty;
import com.sadb.generated.dest.oracle.tables.Occupation;
import com.sadb.generated.dest.oracle.tables.OdevityWeek;
import com.sadb.generated.dest.oracle.tables.ProgramTrack;
import com.sadb.generated.dest.oracle.tables.Publications;
import com.sadb.generated.dest.oracle.tables.ReaderSheet;
import com.sadb.generated.dest.oracle.tables.Results;
import com.sadb.generated.dest.oracle.tables.Room;
import com.sadb.generated.dest.oracle.tables.ScientificProject;
import com.sadb.generated.dest.oracle.tables.Speciality;
import com.sadb.generated.dest.oracle.tables.Student;
import com.sadb.generated.dest.oracle.tables.SyncLog;
import com.sadb.generated.dest.oracle.tables.TimeTable;
import com.sadb.generated.dest.oracle.tables.TypeEdition;
import com.sadb.generated.dest.oracle.tables.TypePosition;
import com.sadb.generated.dest.oracle.tables.TypePublication;
import com.sadb.generated.dest.oracle.tables.VariantOccupation;
import com.sadb.generated.dest.oracle.tables.WeekDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sanddb extends SchemaImpl {

    private static final long serialVersionUID = -350067251;

    /**
     * The reference instance of <code>SANDDB</code>
     */
    public static final Sanddb SANDDB = new Sanddb();

    /**
     * The table <code>SANDDB.ACADEMIC_YEAR</code>.
     */
    public final AcademicYear ACADEMIC_YEAR = com.sadb.generated.dest.oracle.tables.AcademicYear.ACADEMIC_YEAR;

    /**
     * The table <code>SANDDB.BLOCK</code>.
     */
    public final Block BLOCK = com.sadb.generated.dest.oracle.tables.Block.BLOCK;

    /**
     * The table <code>SANDDB.CLASS_ROOM</code>.
     */
    public final ClassRoom CLASS_ROOM = com.sadb.generated.dest.oracle.tables.ClassRoom.CLASS_ROOM;

    /**
     * The table <code>SANDDB.CONFERENCE</code>.
     */
    public final Conference CONFERENCE = com.sadb.generated.dest.oracle.tables.Conference.CONFERENCE;

    /**
     * The table <code>SANDDB.DB</code>.
     */
    public final Db DB = com.sadb.generated.dest.oracle.tables.Db.DB;

    /**
     * The table <code>SANDDB.DISCIPLINE</code>.
     */
    public final Discipline DISCIPLINE = com.sadb.generated.dest.oracle.tables.Discipline.DISCIPLINE;

    /**
     * The table <code>SANDDB.DORMITORY</code>.
     */
    public final Dormitory DORMITORY = com.sadb.generated.dest.oracle.tables.Dormitory.DORMITORY;

    /**
     * The table <code>SANDDB.EVENTS</code>.
     */
    public final Events EVENTS = com.sadb.generated.dest.oracle.tables.Events.EVENTS;

    /**
     * The table <code>SANDDB.EVENT_TYPE</code>.
     */
    public final EventType EVENT_TYPE = com.sadb.generated.dest.oracle.tables.EventType.EVENT_TYPE;

    /**
     * The table <code>SANDDB.FACULTY</code>.
     */
    public final Faculty FACULTY = com.sadb.generated.dest.oracle.tables.Faculty.FACULTY;

    /**
     * The table <code>SANDDB.FACULTY_LECTURER</code>.
     */
    public final FacultyLecturer FACULTY_LECTURER = com.sadb.generated.dest.oracle.tables.FacultyLecturer.FACULTY_LECTURER;

    /**
     * The table <code>SANDDB.FORM_EDUCATION</code>.
     */
    public final FormEducation FORM_EDUCATION = com.sadb.generated.dest.oracle.tables.FormEducation.FORM_EDUCATION;

    /**
     * The table <code>SANDDB.GROUPS</code>.
     */
    public final Groups GROUPS = com.sadb.generated.dest.oracle.tables.Groups.GROUPS;

    /**
     * The table <code>SANDDB.LECTURER</code>.
     */
    public final Lecturer LECTURER = com.sadb.generated.dest.oracle.tables.Lecturer.LECTURER;

    /**
     * The table <code>SANDDB.LIST_PARTICIPANT</code>.
     */
    public final ListParticipant LIST_PARTICIPANT = com.sadb.generated.dest.oracle.tables.ListParticipant.LIST_PARTICIPANT;

    /**
     * The table <code>SANDDB.LIST_PARTICIPANT_PROJECT</code>.
     */
    public final ListParticipantProject LIST_PARTICIPANT_PROJECT = com.sadb.generated.dest.oracle.tables.ListParticipantProject.LIST_PARTICIPANT_PROJECT;

    /**
     * The table <code>SANDDB.MEGAFACULTY</code>.
     */
    public final Megafaculty MEGAFACULTY = com.sadb.generated.dest.oracle.tables.Megafaculty.MEGAFACULTY;

    /**
     * The table <code>SANDDB.OCCUPATION</code>.
     */
    public final Occupation OCCUPATION = com.sadb.generated.dest.oracle.tables.Occupation.OCCUPATION;

    /**
     * The table <code>SANDDB.ODEVITY_WEEK</code>.
     */
    public final OdevityWeek ODEVITY_WEEK = com.sadb.generated.dest.oracle.tables.OdevityWeek.ODEVITY_WEEK;

    /**
     * The table <code>SANDDB.PROGRAM_TRACK</code>.
     */
    public final ProgramTrack PROGRAM_TRACK = com.sadb.generated.dest.oracle.tables.ProgramTrack.PROGRAM_TRACK;

    /**
     * The table <code>SANDDB.PUBLICATIONS</code>.
     */
    public final Publications PUBLICATIONS = com.sadb.generated.dest.oracle.tables.Publications.PUBLICATIONS;

    /**
     * The table <code>SANDDB.READER_SHEET</code>.
     */
    public final ReaderSheet READER_SHEET = com.sadb.generated.dest.oracle.tables.ReaderSheet.READER_SHEET;

    /**
     * The table <code>SANDDB.RESULTS</code>.
     */
    public final Results RESULTS = com.sadb.generated.dest.oracle.tables.Results.RESULTS;

    /**
     * The table <code>SANDDB.ROOM</code>.
     */
    public final Room ROOM = com.sadb.generated.dest.oracle.tables.Room.ROOM;

    /**
     * The table <code>SANDDB.SCIENTIFIC_PROJECT</code>.
     */
    public final ScientificProject SCIENTIFIC_PROJECT = com.sadb.generated.dest.oracle.tables.ScientificProject.SCIENTIFIC_PROJECT;

    /**
     * The table <code>SANDDB.SPECIALITY</code>.
     */
    public final Speciality SPECIALITY = com.sadb.generated.dest.oracle.tables.Speciality.SPECIALITY;

    /**
     * The table <code>SANDDB.STUDENT</code>.
     */
    public final Student STUDENT = com.sadb.generated.dest.oracle.tables.Student.STUDENT;

    /**
     * The table <code>SANDDB.SYNC_LOG</code>.
     */
    public final SyncLog SYNC_LOG = com.sadb.generated.dest.oracle.tables.SyncLog.SYNC_LOG;

    /**
     * The table <code>SANDDB.TIME_TABLE</code>.
     */
    public final TimeTable TIME_TABLE = com.sadb.generated.dest.oracle.tables.TimeTable.TIME_TABLE;

    /**
     * The table <code>SANDDB.TYPE_EDITION</code>.
     */
    public final TypeEdition TYPE_EDITION = com.sadb.generated.dest.oracle.tables.TypeEdition.TYPE_EDITION;

    /**
     * The table <code>SANDDB.TYPE_POSITION</code>.
     */
    public final TypePosition TYPE_POSITION = com.sadb.generated.dest.oracle.tables.TypePosition.TYPE_POSITION;

    /**
     * The table <code>SANDDB.TYPE_PUBLICATION</code>.
     */
    public final TypePublication TYPE_PUBLICATION = com.sadb.generated.dest.oracle.tables.TypePublication.TYPE_PUBLICATION;

    /**
     * The table <code>SANDDB.VARIANT_OCCUPATION</code>.
     */
    public final VariantOccupation VARIANT_OCCUPATION = com.sadb.generated.dest.oracle.tables.VariantOccupation.VARIANT_OCCUPATION;

    /**
     * The table <code>SANDDB.WEEK_DAY</code>.
     */
    public final WeekDay WEEK_DAY = com.sadb.generated.dest.oracle.tables.WeekDay.WEEK_DAY;

    /**
     * No further instances allowed
     */
    private Sanddb() {
        super("SANDDB", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.BLOCK_SEQ,
            Sequences.CONFERENCE_SEQ,
            Sequences.DORMITORY_SEQ,
            Sequences.EVENTS_SEQ,
            Sequences.EVENT_TYPE_SEQ,
            Sequences.FORM_EDUCATION_SEQ,
            Sequences.PUBLICATIONS_SEQ,
            Sequences.READER_SHEET_SEQ,
            Sequences.ROOM_SEQ,
            Sequences.SCIENTIFIC_PROJECT_SEQ,
            Sequences.TYPE_EDITION_SEQ,
            Sequences.TYPE_POSITION_SEQ,
            Sequences.TYPE_PUBLICATION_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            AcademicYear.ACADEMIC_YEAR,
            Block.BLOCK,
            ClassRoom.CLASS_ROOM,
            Conference.CONFERENCE,
            Db.DB,
            Discipline.DISCIPLINE,
            Dormitory.DORMITORY,
            Events.EVENTS,
            EventType.EVENT_TYPE,
            Faculty.FACULTY,
            FacultyLecturer.FACULTY_LECTURER,
            FormEducation.FORM_EDUCATION,
            Groups.GROUPS,
            Lecturer.LECTURER,
            ListParticipant.LIST_PARTICIPANT,
            ListParticipantProject.LIST_PARTICIPANT_PROJECT,
            Megafaculty.MEGAFACULTY,
            Occupation.OCCUPATION,
            OdevityWeek.ODEVITY_WEEK,
            ProgramTrack.PROGRAM_TRACK,
            Publications.PUBLICATIONS,
            ReaderSheet.READER_SHEET,
            Results.RESULTS,
            Room.ROOM,
            ScientificProject.SCIENTIFIC_PROJECT,
            Speciality.SPECIALITY,
            Student.STUDENT,
            SyncLog.SYNC_LOG,
            TimeTable.TIME_TABLE,
            TypeEdition.TYPE_EDITION,
            TypePosition.TYPE_POSITION,
            TypePublication.TYPE_PUBLICATION,
            VariantOccupation.VARIANT_OCCUPATION,
            WeekDay.WEEK_DAY);
    }
}
