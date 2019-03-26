/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.TimeTableRecord;

import java.math.BigInteger;
import java.sql.Date;
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

    private static final long serialVersionUID = -1570593568;

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
    public final TableField<TimeTableRecord, BigInteger> WEEK_DAY_ID = createField("WEEK_DAY_ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.OCCUPATION_ID</code>.
     */
    public final TableField<TimeTableRecord, BigInteger> OCCUPATION_ID = createField("OCCUPATION_ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.ODEVITY_ID</code>.
     */
    public final TableField<TimeTableRecord, BigInteger> ODEVITY_ID = createField("ODEVITY_ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.VARIANT_OCCUPATION_ID</code>.
     */
    public final TableField<TimeTableRecord, BigInteger> VARIANT_OCCUPATION_ID = createField("VARIANT_OCCUPATION_ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.CLASS_ID</code>.
     */
    public final TableField<TimeTableRecord, BigInteger> CLASS_ID = createField("CLASS_ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.GROUP_ID</code>.
     */
    public final TableField<TimeTableRecord, BigInteger> GROUP_ID = createField("GROUP_ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.DISCIPLINE_ID</code>.
     */
    public final TableField<TimeTableRecord, BigInteger> DISCIPLINE_ID = createField("DISCIPLINE_ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.CREAT_TIME</code>.
     */
    public final TableField<TimeTableRecord, Date> CREAT_TIME = createField("CREAT_TIME", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.UPDATE_TIME</code>.
     */
    public final TableField<TimeTableRecord, Date> UPDATE_TIME = createField("UPDATE_TIME", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>SANDDB.TIME_TABLE.TIME_TABLE_ID</code>.
     */
    public final TableField<TimeTableRecord, BigInteger> TIME_TABLE_ID = createField("TIME_TABLE_ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

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
