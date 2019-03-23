/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.DbRecord;

import java.math.BigInteger;
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
public class Db extends TableImpl<DbRecord> {

    private static final long serialVersionUID = 211896953;

    /**
     * The reference instance of <code>SANDDB.DB</code>
     */
    public static final Db DB = new Db();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DbRecord> getRecordType() {
        return DbRecord.class;
    }

    /**
     * The column <code>SANDDB.DB.ID</code>.
     */
    public final TableField<DbRecord, BigInteger> ID = createField("ID", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.DB.NAME</code>.
     */
    public final TableField<DbRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * Create a <code>SANDDB.DB</code> table reference
     */
    public Db() {
        this(DSL.name("DB"), null);
    }

    /**
     * Create an aliased <code>SANDDB.DB</code> table reference
     */
    public Db(String alias) {
        this(DSL.name(alias), DB);
    }

    /**
     * Create an aliased <code>SANDDB.DB</code> table reference
     */
    public Db(Name alias) {
        this(alias, DB);
    }

    private Db(Name alias, Table<DbRecord> aliased) {
        this(alias, aliased, null);
    }

    private Db(Name alias, Table<DbRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Db(Table<O> child, ForeignKey<O, DbRecord> key) {
        super(child, key, DB);
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
        return Arrays.<Index>asList(Indexes.SYS_C005372);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DbRecord> getPrimaryKey() {
        return Keys.SYS_C005372;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DbRecord>> getKeys() {
        return Arrays.<UniqueKey<DbRecord>>asList(Keys.SYS_C005372);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Db as(String alias) {
        return new Db(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Db as(Name alias) {
        return new Db(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Db rename(String name) {
        return new Db(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Db rename(Name name) {
        return new Db(name, null);
    }
}