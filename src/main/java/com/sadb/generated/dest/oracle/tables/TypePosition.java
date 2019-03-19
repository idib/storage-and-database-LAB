/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.TypePositionRecord;

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
public class TypePosition extends TableImpl<TypePositionRecord> {

    private static final long serialVersionUID = 1828431183;

    /**
     * The reference instance of <code>SANDDB.TYPE_POSITION</code>
     */
    public static final TypePosition TYPE_POSITION = new TypePosition();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TypePositionRecord> getRecordType() {
        return TypePositionRecord.class;
    }

    /**
     * The column <code>SANDDB.TYPE_POSITION.ID</code>.
     */
    public final TableField<TypePositionRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.TYPE_POSITION.NAME</code>.
     */
    public final TableField<TypePositionRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>SANDDB.TYPE_POSITION.DATA_UPDATE</code>.
     */
    public final TableField<TypePositionRecord, Timestamp> DATA_UPDATE = createField("DATA_UPDATE", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.TYPE_POSITION.DATA_CREATE</code>.
     */
    public final TableField<TypePositionRecord, Timestamp> DATA_CREATE = createField("DATA_CREATE", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38).nullable(false), this, "");

    /**
     * Create a <code>SANDDB.TYPE_POSITION</code> table reference
     */
    public TypePosition() {
        this(DSL.name("TYPE_POSITION"), null);
    }

    /**
     * Create an aliased <code>SANDDB.TYPE_POSITION</code> table reference
     */
    public TypePosition(String alias) {
        this(DSL.name(alias), TYPE_POSITION);
    }

    /**
     * Create an aliased <code>SANDDB.TYPE_POSITION</code> table reference
     */
    public TypePosition(Name alias) {
        this(alias, TYPE_POSITION);
    }

    private TypePosition(Name alias, Table<TypePositionRecord> aliased) {
        this(alias, aliased, null);
    }

    private TypePosition(Name alias, Table<TypePositionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TypePosition(Table<O> child, ForeignKey<O, TypePositionRecord> key) {
        super(child, key, TYPE_POSITION);
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
        return Arrays.<Index>asList(Indexes.SYS_C005165);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TypePositionRecord> getPrimaryKey() {
        return Keys.SYS_C005165;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TypePositionRecord>> getKeys() {
        return Arrays.<UniqueKey<TypePositionRecord>>asList(Keys.SYS_C005165);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypePosition as(String alias) {
        return new TypePosition(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypePosition as(Name alias) {
        return new TypePosition(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TypePosition rename(String name) {
        return new TypePosition(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TypePosition rename(Name name) {
        return new TypePosition(name, null);
    }
}
