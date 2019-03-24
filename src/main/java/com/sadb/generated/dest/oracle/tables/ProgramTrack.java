/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.ProgramTrackRecord;

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
public class ProgramTrack extends TableImpl<ProgramTrackRecord> {

    private static final long serialVersionUID = -2007053086;

    /**
     * The reference instance of <code>SANDDB.PROGRAM_TRACK</code>
     */
    public static final ProgramTrack PROGRAM_TRACK = new ProgramTrack();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProgramTrackRecord> getRecordType() {
        return ProgramTrackRecord.class;
    }

    /**
     * The column <code>SANDDB.PROGRAM_TRACK.PROG_ID</code>.
     */
    public final TableField<ProgramTrackRecord, Long> PROG_ID = createField("PROG_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.PROGRAM_TRACK.FAC_ID</code>.
     */
    public final TableField<ProgramTrackRecord, Long> FAC_ID = createField("FAC_ID", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>SANDDB.PROGRAM_TRACK.PROGM_NAME</code>.
     */
    public final TableField<ProgramTrackRecord, String> PROGM_NAME = createField("PROGM_NAME", org.jooq.impl.SQLDataType.VARCHAR(150), this, "");

    /**
     * The column <code>SANDDB.PROGRAM_TRACK.PROGRAM_TRACK_NUM</code>.
     */
    public final TableField<ProgramTrackRecord, String> PROGRAM_TRACK_NUM = createField("PROGRAM_TRACK_NUM", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>SANDDB.PROGRAM_TRACK.PROGM_TYPE</code>.
     */
    public final TableField<ProgramTrackRecord, String> PROGM_TYPE = createField("PROGM_TYPE", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>SANDDB.PROGRAM_TRACK.CREAT_TIME</code>.
     */
    public final TableField<ProgramTrackRecord, Timestamp> CREAT_TIME = createField("CREAT_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38), this, "");

    /**
     * The column <code>SANDDB.PROGRAM_TRACK.UPDATE_TIME</code>.
     */
    public final TableField<ProgramTrackRecord, Timestamp> UPDATE_TIME = createField("UPDATE_TIME", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38), this, "");

    /**
     * Create a <code>SANDDB.PROGRAM_TRACK</code> table reference
     */
    public ProgramTrack() {
        this(DSL.name("PROGRAM_TRACK"), null);
    }

    /**
     * Create an aliased <code>SANDDB.PROGRAM_TRACK</code> table reference
     */
    public ProgramTrack(String alias) {
        this(DSL.name(alias), PROGRAM_TRACK);
    }

    /**
     * Create an aliased <code>SANDDB.PROGRAM_TRACK</code> table reference
     */
    public ProgramTrack(Name alias) {
        this(alias, PROGRAM_TRACK);
    }

    private ProgramTrack(Name alias, Table<ProgramTrackRecord> aliased) {
        this(alias, aliased, null);
    }

    private ProgramTrack(Name alias, Table<ProgramTrackRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ProgramTrack(Table<O> child, ForeignKey<O, ProgramTrackRecord> key) {
        super(child, key, PROGRAM_TRACK);
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
        return Arrays.<Index>asList(Indexes.XPK_PROGRAM_TRACK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProgramTrackRecord> getPrimaryKey() {
        return Keys.XPK_PROGRAM_TRACK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProgramTrackRecord>> getKeys() {
        return Arrays.<UniqueKey<ProgramTrackRecord>>asList(Keys.XPK_PROGRAM_TRACK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ProgramTrackRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ProgramTrackRecord, ?>>asList(Keys.R_4);
    }

    public Faculty faculty() {
        return new Faculty(this, Keys.R_4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProgramTrack as(String alias) {
        return new ProgramTrack(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProgramTrack as(Name alias) {
        return new ProgramTrack(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ProgramTrack rename(String name) {
        return new ProgramTrack(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ProgramTrack rename(Name name) {
        return new ProgramTrack(name, null);
    }
}
