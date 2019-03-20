/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.DormitoryRecord;

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
public class Dormitory extends TableImpl<DormitoryRecord> {

    private static final long serialVersionUID = 216443705;

    /**
     * The reference instance of <code>SANDDB.DORMITORY</code>
     */
    public static final Dormitory DORMITORY = new Dormitory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DormitoryRecord> getRecordType() {
        return DormitoryRecord.class;
    }

    /**
     * The column <code>SANDDB.DORMITORY.ID</code>.
     */
    public final TableField<DormitoryRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.DORMITORY.NAME</code>.
     */
    public final TableField<DormitoryRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>SANDDB.DORMITORY.ADDRESS</code>.
     */
    public final TableField<DormitoryRecord, String> ADDRESS = createField("ADDRESS", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>SANDDB.DORMITORY.DATE_UPDATE</code>.
     */
    public final TableField<DormitoryRecord, Timestamp> DATE_UPDATE = createField("DATE_UPDATE", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>SANDDB.DORMITORY.DATE_CREATE</code>.
     */
    public final TableField<DormitoryRecord, Timestamp> DATE_CREATE = createField("DATE_CREATE", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>SANDDB.DORMITORY</code> table reference
     */
    public Dormitory() {
        this(DSL.name("DORMITORY"), null);
    }

    /**
     * Create an aliased <code>SANDDB.DORMITORY</code> table reference
     */
    public Dormitory(String alias) {
        this(DSL.name(alias), DORMITORY);
    }

    /**
     * Create an aliased <code>SANDDB.DORMITORY</code> table reference
     */
    public Dormitory(Name alias) {
        this(alias, DORMITORY);
    }

    private Dormitory(Name alias, Table<DormitoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Dormitory(Name alias, Table<DormitoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Dormitory(Table<O> child, ForeignKey<O, DormitoryRecord> key) {
        super(child, key, DORMITORY);
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
        return Arrays.<Index>asList(Indexes.DORMITORY_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DormitoryRecord> getPrimaryKey() {
        return Keys.DORMITORY_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DormitoryRecord>> getKeys() {
        return Arrays.<UniqueKey<DormitoryRecord>>asList(Keys.DORMITORY_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dormitory as(String alias) {
        return new Dormitory(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dormitory as(Name alias) {
        return new Dormitory(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Dormitory rename(String name) {
        return new Dormitory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Dormitory rename(Name name) {
        return new Dormitory(name, null);
    }
}
