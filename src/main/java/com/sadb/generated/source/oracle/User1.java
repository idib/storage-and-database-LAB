/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.oracle;


import com.sadb.generated.source.oracle.tables.AcademicYear;
import com.sadb.generated.source.oracle.tables.ClassRoom;
import com.sadb.generated.source.oracle.tables.Discipline;
import com.sadb.generated.source.oracle.tables.Faculty;
import com.sadb.generated.source.oracle.tables.FacultyLecturer;
import com.sadb.generated.source.oracle.tables.Groups;
import com.sadb.generated.source.oracle.tables.Lecturer;
import com.sadb.generated.source.oracle.tables.Megafaculty;
import com.sadb.generated.source.oracle.tables.Occupation;
import com.sadb.generated.source.oracle.tables.OdevityWeek;
import com.sadb.generated.source.oracle.tables.ProgramTrack;
import com.sadb.generated.source.oracle.tables.Results;
import com.sadb.generated.source.oracle.tables.Speciality;
import com.sadb.generated.source.oracle.tables.Student;
import com.sadb.generated.source.oracle.tables.TimeTable;
import com.sadb.generated.source.oracle.tables.VariantOccupation;
import com.sadb.generated.source.oracle.tables.WeekDay;

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
public class User1 extends SchemaImpl {

    private static final long serialVersionUID = -781826843;

    /**
     * The reference instance of <code>USER1</code>
     */
    public static final User1 USER1 = new User1();

    /**
     * The table <code>USER1.ACADEMIC_YEAR</code>.
     */
    public final AcademicYear ACADEMIC_YEAR = com.sadb.generated.source.oracle.tables.AcademicYear.ACADEMIC_YEAR;

    /**
     * The table <code>USER1.CLASS_ROOM</code>.
     */
    public final ClassRoom CLASS_ROOM = com.sadb.generated.source.oracle.tables.ClassRoom.CLASS_ROOM;

    /**
     * The table <code>USER1.DISCIPLINE</code>.
     */
    public final Discipline DISCIPLINE = com.sadb.generated.source.oracle.tables.Discipline.DISCIPLINE;

    /**
     * The table <code>USER1.FACULTY</code>.
     */
    public final Faculty FACULTY = com.sadb.generated.source.oracle.tables.Faculty.FACULTY;

    /**
     * The table <code>USER1.FACULTY_LECTURER</code>.
     */
    public final FacultyLecturer FACULTY_LECTURER = com.sadb.generated.source.oracle.tables.FacultyLecturer.FACULTY_LECTURER;

    /**
     * The table <code>USER1.GROUPS</code>.
     */
    public final Groups GROUPS = com.sadb.generated.source.oracle.tables.Groups.GROUPS;

    /**
     * The table <code>USER1.LECTURER</code>.
     */
    public final Lecturer LECTURER = com.sadb.generated.source.oracle.tables.Lecturer.LECTURER;

    /**
     * The table <code>USER1.MEGAFACULTY</code>.
     */
    public final Megafaculty MEGAFACULTY = com.sadb.generated.source.oracle.tables.Megafaculty.MEGAFACULTY;

    /**
     * The table <code>USER1.OCCUPATION</code>.
     */
    public final Occupation OCCUPATION = com.sadb.generated.source.oracle.tables.Occupation.OCCUPATION;

    /**
     * The table <code>USER1.ODEVITY_WEEK</code>.
     */
    public final OdevityWeek ODEVITY_WEEK = com.sadb.generated.source.oracle.tables.OdevityWeek.ODEVITY_WEEK;

    /**
     * The table <code>USER1.PROGRAM_TRACK</code>.
     */
    public final ProgramTrack PROGRAM_TRACK = com.sadb.generated.source.oracle.tables.ProgramTrack.PROGRAM_TRACK;

    /**
     * The table <code>USER1.RESULTS</code>.
     */
    public final Results RESULTS = com.sadb.generated.source.oracle.tables.Results.RESULTS;

    /**
     * The table <code>USER1.SPECIALITY</code>.
     */
    public final Speciality SPECIALITY = com.sadb.generated.source.oracle.tables.Speciality.SPECIALITY;

    /**
     * The table <code>USER1.STUDENT</code>.
     */
    public final Student STUDENT = com.sadb.generated.source.oracle.tables.Student.STUDENT;

    /**
     * The table <code>USER1.TIME_TABLE</code>.
     */
    public final TimeTable TIME_TABLE = com.sadb.generated.source.oracle.tables.TimeTable.TIME_TABLE;

    /**
     * The table <code>USER1.VARIANT_OCCUPATION</code>.
     */
    public final VariantOccupation VARIANT_OCCUPATION = com.sadb.generated.source.oracle.tables.VariantOccupation.VARIANT_OCCUPATION;

    /**
     * The table <code>USER1.WEEK_DAY</code>.
     */
    public final WeekDay WEEK_DAY = com.sadb.generated.source.oracle.tables.WeekDay.WEEK_DAY;

    /**
     * No further instances allowed
     */
    private User1() {
        super("USER1", null);
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
            Sequences.SEQ_ACADEMIC_YEAR,
            Sequences.SEQ_CLASS_ROOM,
            Sequences.SEQ_DISCIPLINE,
            Sequences.SEQ_FACULTY,
            Sequences.SEQ_FACULTY_LECTURER,
            Sequences.SEQ_GROUP,
            Sequences.SEQ_LECTURER,
            Sequences.SEQ_MEGAFACULTY,
            Sequences.SEQ_OCCUPATION,
            Sequences.SEQ_ODEVITY_WEEK,
            Sequences.SEQ_PROGRAM_TRACK,
            Sequences.SEQ_RESULTS,
            Sequences.SEQ_SPECIALITY,
            Sequences.SEQ_STUDENT,
            Sequences.SEQ_VARIANT_OCCUPATION,
            Sequences.SEQ_WEEK_DAY);
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
            ClassRoom.CLASS_ROOM,
            Discipline.DISCIPLINE,
            Faculty.FACULTY,
            FacultyLecturer.FACULTY_LECTURER,
            Groups.GROUPS,
            Lecturer.LECTURER,
            Megafaculty.MEGAFACULTY,
            Occupation.OCCUPATION,
            OdevityWeek.ODEVITY_WEEK,
            ProgramTrack.PROGRAM_TRACK,
            Results.RESULTS,
            Speciality.SPECIALITY,
            Student.STUDENT,
            TimeTable.TIME_TABLE,
            VariantOccupation.VARIANT_OCCUPATION,
            WeekDay.WEEK_DAY);
    }
}
