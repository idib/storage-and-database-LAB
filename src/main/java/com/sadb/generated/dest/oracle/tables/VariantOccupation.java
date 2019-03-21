/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.VariantOccupationRecord;

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
public class VariantOccupation extends TableImpl<VariantOccupationRecord> {

    private static final long serialVersionUID = -2063422827;

    /**
     * The reference instance of <code>SANDDB.VARIANT_OCCUPATION</code>
     */
    public static final VariantOccupation VARIANT_OCCUPATION = new VariantOccupation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VariantOccupationRecord> getRecordType() {
        return VariantOccupationRecord.class;
    }

    /**
     * The column <code>SANDDB.VARIANT_OCCUPATION.VARIANT_OCCUPATION_ID</code>.
     */
    public final TableField<VariantOccupationRecord, Long> VARIANT_OCCUPATION_ID = createField("VARIANT_OCCUPATION_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.VARIANT_OCCUPATION.VAR_OCC_TYPE</code>.
     */
    public final TableField<VariantOccupationRecord, String> VAR_OCC_TYPE = createField("VAR_OCC_TYPE", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>SANDDB.VARIANT_OCCUPATION.CREAT_TIME</code>.
     */
    public final TableField<VariantOccupationRecord, Timestamp> CREAT_TIME = createField("CREAT_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38), this, "");

    /**
     * The column <code>SANDDB.VARIANT_OCCUPATION.UPDATE_TIME</code>.
     */
    public final TableField<VariantOccupationRecord, Timestamp> UPDATE_TIME = createField("UPDATE_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38), this, "");

    /**
     * Create a <code>SANDDB.VARIANT_OCCUPATION</code> table reference
     */
    public VariantOccupation() {
        this(DSL.name("VARIANT_OCCUPATION"), null);
    }

    /**
     * Create an aliased <code>SANDDB.VARIANT_OCCUPATION</code> table reference
     */
    public VariantOccupation(String alias) {
        this(DSL.name(alias), VARIANT_OCCUPATION);
    }

    /**
     * Create an aliased <code>SANDDB.VARIANT_OCCUPATION</code> table reference
     */
    public VariantOccupation(Name alias) {
        this(alias, VARIANT_OCCUPATION);
    }

    private VariantOccupation(Name alias, Table<VariantOccupationRecord> aliased) {
        this(alias, aliased, null);
    }

    private VariantOccupation(Name alias, Table<VariantOccupationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> VariantOccupation(Table<O> child, ForeignKey<O, VariantOccupationRecord> key) {
        super(child, key, VARIANT_OCCUPATION);
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
        return Arrays.<Index>asList(Indexes.XPK_ARIANT_OCC);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<VariantOccupationRecord> getPrimaryKey() {
        return Keys.XPK_ARIANT_OCC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<VariantOccupationRecord>> getKeys() {
        return Arrays.<UniqueKey<VariantOccupationRecord>>asList(Keys.XPK_ARIANT_OCC);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VariantOccupation as(String alias) {
        return new VariantOccupation(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VariantOccupation as(Name alias) {
        return new VariantOccupation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public VariantOccupation rename(String name) {
        return new VariantOccupation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public VariantOccupation rename(Name name) {
        return new VariantOccupation(name, null);
    }
}
