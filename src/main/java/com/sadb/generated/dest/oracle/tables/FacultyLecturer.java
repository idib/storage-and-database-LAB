/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.FacultyLecturerRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class FacultyLecturer extends TableImpl<FacultyLecturerRecord> {

    private static final long serialVersionUID = 1347285037;

    /**
     * The reference instance of <code>SANDDB.FACULTY_LECTURER</code>
     */
    public static final FacultyLecturer FACULTY_LECTURER = new FacultyLecturer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FacultyLecturerRecord> getRecordType() {
        return FacultyLecturerRecord.class;
    }

    /**
     * The column <code>SANDDB.FACULTY_LECTURER.LEC_ID</code>.
     */
    public final TableField<FacultyLecturerRecord, Long> LEC_ID = createField("LEC_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.FACULTY_LECTURER.FAC_ID</code>.
     */
    public final TableField<FacultyLecturerRecord, Long> FAC_ID = createField("FAC_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.FACULTY_LECTURER.FAC_LECT_ID</code>.
     */
    public final TableField<FacultyLecturerRecord, Long> FAC_LECT_ID = createField("FAC_LECT_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.FACULTY_LECTURER.CREAT_TIME</code>.
     */
    public final TableField<FacultyLecturerRecord, Timestamp> CREAT_TIME = createField("CREAT_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38), this, "");

    /**
     * The column <code>SANDDB.FACULTY_LECTURER.UPDATE_TIME</code>.
     */
    public final TableField<FacultyLecturerRecord, Timestamp> UPDATE_TIME = createField("UPDATE_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38), this, "");

    /**
     * Create a <code>SANDDB.FACULTY_LECTURER</code> table reference
     */
    public FacultyLecturer() {
        this(DSL.name("FACULTY_LECTURER"), null);
    }

    /**
     * Create an aliased <code>SANDDB.FACULTY_LECTURER</code> table reference
     */
    public FacultyLecturer(String alias) {
        this(DSL.name(alias), FACULTY_LECTURER);
    }

    /**
     * Create an aliased <code>SANDDB.FACULTY_LECTURER</code> table reference
     */
    public FacultyLecturer(Name alias) {
        this(alias, FACULTY_LECTURER);
    }

    private FacultyLecturer(Name alias, Table<FacultyLecturerRecord> aliased) {
        this(alias, aliased, null);
    }

    private FacultyLecturer(Name alias, Table<FacultyLecturerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> FacultyLecturer(Table<O> child, ForeignKey<O, FacultyLecturerRecord> key) {
        super(child, key, FACULTY_LECTURER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Sanddb.SANDDB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.XPK_FAC_LECTUR);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<FacultyLecturerRecord> getPrimaryKey() {
        return Keys.XPK_FAC_LECTUR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<FacultyLecturerRecord>> getKeys() {
        return Arrays.<UniqueKey<FacultyLecturerRecord>>asList(Keys.XPK_FAC_LECTUR);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<FacultyLecturerRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<FacultyLecturerRecord, ?>>asList(Keys.R_16, Keys.R_15);
    }

    public Lecturer lecturer() {
        return new Lecturer(this, Keys.R_16);
    }

    public Faculty faculty() {
        return new Faculty(this, Keys.R_15);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FacultyLecturer as(String alias) {
        return new FacultyLecturer(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FacultyLecturer as(Name alias) {
        return new FacultyLecturer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FacultyLecturer rename(String name) {
        return new FacultyLecturer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FacultyLecturer rename(Name name) {
        return new FacultyLecturer(name, null);
    }
}
