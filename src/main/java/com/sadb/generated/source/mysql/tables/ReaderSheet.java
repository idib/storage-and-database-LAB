/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.mysql.tables;


import com.sadb.generated.source.mysql.Conference;
import com.sadb.generated.source.mysql.Indexes;
import com.sadb.generated.source.mysql.Keys;
import com.sadb.generated.source.mysql.tables.records.ReaderSheetRecord;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
public class ReaderSheet extends TableImpl<ReaderSheetRecord> {

    private static final long serialVersionUID = -704678159;

    /**
     * The reference instance of <code>conference.Reader_sheet</code>
     */
    public static final ReaderSheet READER_SHEET = new ReaderSheet();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReaderSheetRecord> getRecordType() {
        return ReaderSheetRecord.class;
    }

    /**
     * The column <code>conference.Reader_sheet.id</code>.
     */
    public final TableField<ReaderSheetRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>conference.Reader_sheet.participant_id</code>.
     */
    public final TableField<ReaderSheetRecord, Integer> PARTICIPANT_ID = createField("participant_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>conference.Reader_sheet.Title_book</code>.
     */
    public final TableField<ReaderSheetRecord, String> TITLE_BOOK = createField("Title_book", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>conference.Reader_sheet.Date_take</code>.
     */
    public final TableField<ReaderSheetRecord, Date> DATE_TAKE = createField("Date_take", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>conference.Reader_sheet.Date_put</code>.
     */
    public final TableField<ReaderSheetRecord, Date> DATE_PUT = createField("Date_put", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>conference.Reader_sheet.data_update</code>.
     */
    public final TableField<ReaderSheetRecord, Timestamp> DATA_UPDATE = createField("data_update", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>conference.Reader_sheet.data_create</code>.
     */
    public final TableField<ReaderSheetRecord, Timestamp> DATA_CREATE = createField("data_create", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>conference.Reader_sheet</code> table reference
     */
    public ReaderSheet() {
        this(DSL.name("Reader_sheet"), null);
    }

    /**
     * Create an aliased <code>conference.Reader_sheet</code> table reference
     */
    public ReaderSheet(String alias) {
        this(DSL.name(alias), READER_SHEET);
    }

    /**
     * Create an aliased <code>conference.Reader_sheet</code> table reference
     */
    public ReaderSheet(Name alias) {
        this(alias, READER_SHEET);
    }

    private ReaderSheet(Name alias, Table<ReaderSheetRecord> aliased) {
        this(alias, aliased, null);
    }

    private ReaderSheet(Name alias, Table<ReaderSheetRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ReaderSheet(Table<O> child, ForeignKey<O, ReaderSheetRecord> key) {
        super(child, key, READER_SHEET);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Conference.CONFERENCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.READER_SHEET_PRIMARY, Indexes.READER_SHEET_READER_SHEET_FK0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ReaderSheetRecord, Integer> getIdentity() {
        return Keys.IDENTITY_READER_SHEET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ReaderSheetRecord> getPrimaryKey() {
        return Keys.KEY_READER_SHEET_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ReaderSheetRecord>> getKeys() {
        return Arrays.<UniqueKey<ReaderSheetRecord>>asList(Keys.KEY_READER_SHEET_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ReaderSheetRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ReaderSheetRecord, ?>>asList(Keys.READER_SHEET_FK0);
    }

    public Participant participant() {
        return new Participant(this, Keys.READER_SHEET_FK0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReaderSheet as(String alias) {
        return new ReaderSheet(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReaderSheet as(Name alias) {
        return new ReaderSheet(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ReaderSheet rename(String name) {
        return new ReaderSheet(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ReaderSheet rename(Name name) {
        return new ReaderSheet(name, null);
    }
}
