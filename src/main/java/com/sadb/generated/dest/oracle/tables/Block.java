/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.BlockRecord;

import java.sql.Date;
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
public class Block extends TableImpl<BlockRecord> {

    private static final long serialVersionUID = 1806237780;

    /**
     * The reference instance of <code>SANDDB.BLOCK</code>
     */
    public static final Block BLOCK = new Block();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BlockRecord> getRecordType() {
        return BlockRecord.class;
    }

    /**
     * The column <code>SANDDB.BLOCK.ID</code>.
     */
    public final TableField<BlockRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.BLOCK.FLOOR</code>.
     */
    public final TableField<BlockRecord, Long> FLOOR = createField("FLOOR", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.BLOCK.DATE_DISINSECTION</code>.
     */
    public final TableField<BlockRecord, Date> DATE_DISINSECTION = createField("DATE_DISINSECTION", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>SANDDB.BLOCK.DORM_ID</code>.
     */
    public final TableField<BlockRecord, Long> DORM_ID = createField("DORM_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.BLOCK.DATE_UPDATE</code>.
     */
    public final TableField<BlockRecord, Timestamp> DATE_UPDATE = createField("DATE_UPDATE", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>SANDDB.BLOCK.DATE_CREATE</code>.
     */
    public final TableField<BlockRecord, Timestamp> DATE_CREATE = createField("DATE_CREATE", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>SANDDB.BLOCK</code> table reference
     */
    public Block() {
        this(DSL.name("BLOCK"), null);
    }

    /**
     * Create an aliased <code>SANDDB.BLOCK</code> table reference
     */
    public Block(String alias) {
        this(DSL.name(alias), BLOCK);
    }

    /**
     * Create an aliased <code>SANDDB.BLOCK</code> table reference
     */
    public Block(Name alias) {
        this(alias, BLOCK);
    }

    private Block(Name alias, Table<BlockRecord> aliased) {
        this(alias, aliased, null);
    }

    private Block(Name alias, Table<BlockRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Block(Table<O> child, ForeignKey<O, BlockRecord> key) {
        super(child, key, BLOCK);
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
        return Arrays.<Index>asList(Indexes.BLOCK_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BlockRecord> getPrimaryKey() {
        return Keys.BLOCK_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BlockRecord>> getKeys() {
        return Arrays.<UniqueKey<BlockRecord>>asList(Keys.BLOCK_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<BlockRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BlockRecord, ?>>asList(Keys.BLOCK_FK0);
    }

    public Dormitory dormitory() {
        return new Dormitory(this, Keys.BLOCK_FK0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Block as(String alias) {
        return new Block(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Block as(Name alias) {
        return new Block(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Block rename(String name) {
        return new Block(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Block rename(Name name) {
        return new Block(name, null);
    }
}
