/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.TimeTableRecord;

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
public class TimeTable extends TableImpl<TimeTableRecord> {

    private static final long serialVersionUID = 1917606042;

    /**
     * The reference instance of <code>SANDDB.TIME_TABLE</code>
     */
    public static final TimeTable TIME_TABLE = new TimeTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TimeTableRecord> getRecordType() {
        return TimeTableRecord.class;
    }

    /**
     * The column <code>SANDDB.TIME_TABLE.WEEK_DAY_ID</code>.
     */
    public final TableField<TimeTableRecord, Long> WEEK_DAY_ID = createField("WEEK_DAY_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.OCCUPATION_ID</code>.
     */
    public final TableField<TimeTableRecord, Long> OCCUPATION_ID = createField("OCCUPATION_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.ODEVITY_ID</code>.
     */
    public final TableField<TimeTableRecord, Long> ODEVITY_ID = createField("ODEVITY_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.VARIANT_OCCUPATION_ID</code>.
     */
    public final TableField<TimeTableRecord, Long> VARIANT_OCCUPATION_ID = createField("VARIANT_OCCUPATION_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.CLASS_ID</code>.
     */
    public final TableField<TimeTableRecord, Long> CLASS_ID = createField("CLASS_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.GROUP_ID</code>.
     */
    public final TableField<TimeTableRecord, Long> GROUP_ID = createField("GROUP_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.DISCIPLINE_ID</code>.
     */
    public final TableField<TimeTableRecord, Long> DISCIPLINE_ID = createField("DISCIPLINE_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>SANDDB.TIME_TABLE</code> table reference
     */
    public TimeTable() {
        this(DSL.name("TIME_TABLE"), null);
    }

    /**
     * Create an aliased <code>SANDDB.TIME_TABLE</code> table reference
     */
    public TimeTable(String alias) {
        this(DSL.name(alias), TIME_TABLE);
    }

    /**
     * Create an aliased <code>SANDDB.TIME_TABLE</code> table reference
     */
    public TimeTable(Name alias) {
        this(alias, TIME_TABLE);
    }

    private TimeTable(Name alias, Table<TimeTableRecord> aliased) {
        this(alias, aliased, null);
    }

    private TimeTable(Name alias, Table<TimeTableRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TimeTable(Table<O> child, ForeignKey<O, TimeTableRecord> key) {
        super(child, key, TIME_TABLE);
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
        return Arrays.<Index>asList(Indexes.XPK_TIME_TABLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TimeTableRecord> getPrimaryKey() {
        return Keys.XPK_TIME_TABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TimeTableRecord>> getKeys() {
        return Arrays.<UniqueKey<TimeTableRecord>>asList(Keys.XPK_TIME_TABLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<TimeTableRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TimeTableRecord, ?>>asList(Keys.R_19, Keys.R_21, Keys.R_20, Keys.R_22, Keys.R_23, Keys.R_24, Keys.R_25);
    }

    public WeekDay weekDay() {
        return new WeekDay(this, Keys.R_19);
    }

    public Occupation occupation() {
        return new Occupation(this, Keys.R_21);
    }

    public OdevityWeek odevityWeek() {
        return new OdevityWeek(this, Keys.R_20);
    }

    public VariantOccupation variantOccupation() {
        return new VariantOccupation(this, Keys.R_22);
    }

    public ClassRoom classRoom() {
        return new ClassRoom(this, Keys.R_23);
    }

    public Groups groups() {
        return new Groups(this, Keys.R_24);
    }

    public Discipline discipline() {
        return new Discipline(this, Keys.R_25);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeTable as(String alias) {
        return new TimeTable(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeTable as(Name alias) {
        return new TimeTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TimeTable rename(String name) {
        return new TimeTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TimeTable rename(Name name) {
        return new TimeTable(name, null);
    }
}
