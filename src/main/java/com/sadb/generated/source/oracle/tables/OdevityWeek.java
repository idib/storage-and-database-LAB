/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.oracle.tables;


import com.sadb.generated.source.oracle.Indexes;
import com.sadb.generated.source.oracle.Keys;
import com.sadb.generated.source.oracle.User1;
import com.sadb.generated.source.oracle.tables.records.OdevityWeekRecord;

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
public class OdevityWeek extends TableImpl<OdevityWeekRecord> {

    private static final long serialVersionUID = 1561411054;

    /**
     * The reference instance of <code>USER1.ODEVITY_WEEK</code>
     */
    public static final OdevityWeek ODEVITY_WEEK = new OdevityWeek();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OdevityWeekRecord> getRecordType() {
        return OdevityWeekRecord.class;
    }

    /**
     * The column <code>USER1.ODEVITY_WEEK.ODEVITY_ID</code>.
     */
    public final TableField<OdevityWeekRecord, BigInteger> ODEVITY_ID = createField("ODEVITY_ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

    /**
     * The column <code>USER1.ODEVITY_WEEK.WEEK</code>.
     */
    public final TableField<OdevityWeekRecord, String> WEEK = createField("WEEK", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>USER1.ODEVITY_WEEK.CREAT_TIME</code>.
     */
    public final TableField<OdevityWeekRecord, Date> CREAT_TIME = createField("CREAT_TIME", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>USER1.ODEVITY_WEEK.UPDATE_TIME</code>.
     */
    public final TableField<OdevityWeekRecord, Date> UPDATE_TIME = createField("UPDATE_TIME", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * Create a <code>USER1.ODEVITY_WEEK</code> table reference
     */
    public OdevityWeek() {
        this(DSL.name("ODEVITY_WEEK"), null);
    }

    /**
     * Create an aliased <code>USER1.ODEVITY_WEEK</code> table reference
     */
    public OdevityWeek(String alias) {
        this(DSL.name(alias), ODEVITY_WEEK);
    }

    /**
     * Create an aliased <code>USER1.ODEVITY_WEEK</code> table reference
     */
    public OdevityWeek(Name alias) {
        this(alias, ODEVITY_WEEK);
    }

    private OdevityWeek(Name alias, Table<OdevityWeekRecord> aliased) {
        this(alias, aliased, null);
    }

    private OdevityWeek(Name alias, Table<OdevityWeekRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> OdevityWeek(Table<O> child, ForeignKey<O, OdevityWeekRecord> key) {
        super(child, key, ODEVITY_WEEK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return User1.USER1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.XPK_ODEVITY_WEEK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<OdevityWeekRecord> getPrimaryKey() {
        return Keys.XPK_ODEVITY_WEEK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<OdevityWeekRecord>> getKeys() {
        return Arrays.<UniqueKey<OdevityWeekRecord>>asList(Keys.XPK_ODEVITY_WEEK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OdevityWeek as(String alias) {
        return new OdevityWeek(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OdevityWeek as(Name alias) {
        return new OdevityWeek(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OdevityWeek rename(String name) {
        return new OdevityWeek(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OdevityWeek rename(Name name) {
        return new OdevityWeek(name, null);
    }
}
