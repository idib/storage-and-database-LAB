/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.DisciplineRecord;

import java.math.BigDecimal;
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
public class Discipline extends TableImpl<DisciplineRecord> {

    private static final long serialVersionUID = 1019186605;

    /**
     * The reference instance of <code>SANDDB.DISCIPLINE</code>
     */
    public static final Discipline DISCIPLINE = new Discipline();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DisciplineRecord> getRecordType() {
        return DisciplineRecord.class;
    }

    /**
     * The column <code>SANDDB.DISCIPLINE.DISCIPLINE_ID</code>.
     */
    public final TableField<DisciplineRecord, Long> DISCIPLINE_ID = createField("DISCIPLINE_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.DISCIPLINE.DISCIPLINE_NAME</code>.
     */
    public final TableField<DisciplineRecord, String> DISCIPLINE_NAME = createField("DISCIPLINE_NAME", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>SANDDB.DISCIPLINE.LECTIONS_HOURS</code>.
     */
    public final TableField<DisciplineRecord, BigDecimal> LECTIONS_HOURS = createField("LECTIONS_HOURS", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * The column <code>SANDDB.DISCIPLINE.PRACTICALS_HOURS</code>.
     */
    public final TableField<DisciplineRecord, BigDecimal> PRACTICALS_HOURS = createField("PRACTICALS_HOURS", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * The column <code>SANDDB.DISCIPLINE.LABS_HOUES</code>.
     */
    public final TableField<DisciplineRecord, BigDecimal> LABS_HOUES = createField("LABS_HOUES", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * The column <code>SANDDB.DISCIPLINE.EDUCATION_STANDART_TYPE</code>.
     */
    public final TableField<DisciplineRecord, String> EDUCATION_STANDART_TYPE = createField("EDUCATION_STANDART_TYPE", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>SANDDB.DISCIPLINE.CREAT_TIME</code>.
     */
    public final TableField<DisciplineRecord, Timestamp> CREAT_TIME = createField("CREAT_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38), this, "");

    /**
     * The column <code>SANDDB.DISCIPLINE.UPDATE_TIME</code>.
     */
    public final TableField<DisciplineRecord, Timestamp> UPDATE_TIME = createField("UPDATE_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38), this, "");

    /**
     * Create a <code>SANDDB.DISCIPLINE</code> table reference
     */
    public Discipline() {
        this(DSL.name("DISCIPLINE"), null);
    }

    /**
     * Create an aliased <code>SANDDB.DISCIPLINE</code> table reference
     */
    public Discipline(String alias) {
        this(DSL.name(alias), DISCIPLINE);
    }

    /**
     * Create an aliased <code>SANDDB.DISCIPLINE</code> table reference
     */
    public Discipline(Name alias) {
        this(alias, DISCIPLINE);
    }

    private Discipline(Name alias, Table<DisciplineRecord> aliased) {
        this(alias, aliased, null);
    }

    private Discipline(Name alias, Table<DisciplineRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Discipline(Table<O> child, ForeignKey<O, DisciplineRecord> key) {
        super(child, key, DISCIPLINE);
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
        return Arrays.<Index>asList(Indexes.XPK_DISCIPLINE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DisciplineRecord> getPrimaryKey() {
        return Keys.XPK_DISCIPLINE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DisciplineRecord>> getKeys() {
        return Arrays.<UniqueKey<DisciplineRecord>>asList(Keys.XPK_DISCIPLINE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Discipline as(String alias) {
        return new Discipline(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Discipline as(Name alias) {
        return new Discipline(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Discipline rename(String name) {
        return new Discipline(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Discipline rename(Name name) {
        return new Discipline(name, null);
    }
}
