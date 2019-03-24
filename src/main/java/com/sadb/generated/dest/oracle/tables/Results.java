/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.ResultsRecord;

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
public class Results extends TableImpl<ResultsRecord> {

    private static final long serialVersionUID = -530701691;

    /**
     * The reference instance of <code>SANDDB.RESULTS</code>
     */
    public static final Results RESULTS = new Results();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ResultsRecord> getRecordType() {
        return ResultsRecord.class;
    }

    /**
     * The column <code>SANDDB.RESULTS.RESULT</code>.
     */
    public final TableField<ResultsRecord, String> RESULT = createField("RESULT", org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.field("null", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>SANDDB.RESULTS.EX_TYPE</code>.
     */
    public final TableField<ResultsRecord, String> EX_TYPE = createField("EX_TYPE", org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.field("null", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>SANDDB.RESULTS.DISCIPLINE_ID</code>.
     */
    public final TableField<ResultsRecord, Long> DISCIPLINE_ID = createField("DISCIPLINE_ID", org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.field("NULL ", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>SANDDB.RESULTS.RESULT_DATE</code>.
     */
    public final TableField<ResultsRecord, Timestamp> RESULT_DATE = createField("RESULT_DATE", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38).defaultValue(org.jooq.impl.DSL.field("null", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>SANDDB.RESULTS.RESULT_EU</code>.
     */
    public final TableField<ResultsRecord, String> RESULT_EU = createField("RESULT_EU", org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.field("null", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>SANDDB.RESULTS.ACADEM_YEAR_ID</code>.
     */
    public final TableField<ResultsRecord, Long> ACADEM_YEAR_ID = createField("ACADEM_YEAR_ID", org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.field("NULL ", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>SANDDB.RESULTS.RESULT_ID</code>.
     */
    public final TableField<ResultsRecord, Long> RESULT_ID = createField("RESULT_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.RESULTS.STUDENT_ID</code>.
     */
    public final TableField<ResultsRecord, Long> STUDENT_ID = createField("STUDENT_ID", org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.field("NULL ", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>SANDDB.RESULTS.CREAT_TIME</code>.
     */
    public final TableField<ResultsRecord, Timestamp> CREAT_TIME = createField("CREAT_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38).defaultValue(org.jooq.impl.DSL.field("null", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>SANDDB.RESULTS.UPDATE_TIME</code>.
     */
    public final TableField<ResultsRecord, Timestamp> UPDATE_TIME = createField("UPDATE_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38).defaultValue(org.jooq.impl.DSL.field("null", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>SANDDB.RESULTS.TEACHER_ID</code>.
     */
    public final TableField<ResultsRecord, Long> TEACHER_ID = createField("TEACHER_ID", org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.field("NULL ", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>SANDDB.RESULTS</code> table reference
     */
    public Results() {
        this(DSL.name("RESULTS"), null);
    }

    /**
     * Create an aliased <code>SANDDB.RESULTS</code> table reference
     */
    public Results(String alias) {
        this(DSL.name(alias), RESULTS);
    }

    /**
     * Create an aliased <code>SANDDB.RESULTS</code> table reference
     */
    public Results(Name alias) {
        this(alias, RESULTS);
    }

    private Results(Name alias, Table<ResultsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Results(Name alias, Table<ResultsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Results(Table<O> child, ForeignKey<O, ResultsRecord> key) {
        super(child, key, RESULTS);
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
        return Arrays.<Index>asList(Indexes.XPK_RESULTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ResultsRecord> getPrimaryKey() {
        return Keys.XPK_RESULTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ResultsRecord>> getKeys() {
        return Arrays.<UniqueKey<ResultsRecord>>asList(Keys.XPK_RESULTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ResultsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ResultsRecord, ?>>asList(Keys.R_18, Keys.R_31, Keys.R_17, Keys.RESULTS_FK1);
    }

    public Discipline discipline() {
        return new Discipline(this, Keys.R_18);
    }

    public AcademicYear academicYear() {
        return new AcademicYear(this, Keys.R_31);
    }

    public Student student() {
        return new Student(this, Keys.R_17);
    }

    public Lecturer lecturer() {
        return new Lecturer(this, Keys.RESULTS_FK1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Results as(String alias) {
        return new Results(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Results as(Name alias) {
        return new Results(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Results rename(String name) {
        return new Results(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Results rename(Name name) {
        return new Results(name, null);
    }
}
