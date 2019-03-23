/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.mysql.tables;


import com.sadb.generated.source.mysql.Conference;
import com.sadb.generated.source.mysql.Indexes;
import com.sadb.generated.source.mysql.Keys;
import com.sadb.generated.source.mysql.tables.records.PublicationsRecord;

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
public class Publications extends TableImpl<PublicationsRecord> {

    private static final long serialVersionUID = 724946001;

    /**
     * The reference instance of <code>conference.Publications</code>
     */
    public static final Publications PUBLICATIONS = new Publications();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PublicationsRecord> getRecordType() {
        return PublicationsRecord.class;
    }

    /**
     * The column <code>conference.Publications.id</code>.
     */
    public final TableField<PublicationsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>conference.Publications.Title_edition</code>.
     */
    public final TableField<PublicationsRecord, String> TITLE_EDITION = createField("Title_edition", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>conference.Publications.Language_publication</code>.
     */
    public final TableField<PublicationsRecord, String> LANGUAGE_PUBLICATION = createField("Language_publication", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>conference.Publications.Volume_edition</code>.
     */
    public final TableField<PublicationsRecord, String> VOLUME_EDITION = createField("Volume_edition", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>conference.Publications.Place_editon</code>.
     */
    public final TableField<PublicationsRecord, String> PLACE_EDITON = createField("Place_editon", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>conference.Publications.edition_id</code>.
     */
    public final TableField<PublicationsRecord, Integer> EDITION_ID = createField("edition_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>conference.Publications.Co_authors</code>.
     */
    public final TableField<PublicationsRecord, String> CO_AUTHORS = createField("Co_authors", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>conference.Publications.Citation_index</code>.
     */
    public final TableField<PublicationsRecord, Double> CITATION_INDEX = createField("Citation_index", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>conference.Publications.Data_publication</code>.
     */
    public final TableField<PublicationsRecord, Date> DATA_PUBLICATION = createField("Data_publication", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>conference.Publications.participant_id</code>.
     */
    public final TableField<PublicationsRecord, Integer> PARTICIPANT_ID = createField("participant_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>conference.Publications.id_type_publication</code>.
     */
    public final TableField<PublicationsRecord, Integer> ID_TYPE_PUBLICATION = createField("id_type_publication", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>conference.Publications.data_update</code>.
     */
    public final TableField<PublicationsRecord, Timestamp> DATA_UPDATE = createField("data_update", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>conference.Publications.data_create</code>.
     */
    public final TableField<PublicationsRecord, Timestamp> DATA_CREATE = createField("data_create", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>conference.Publications</code> table reference
     */
    public Publications() {
        this(DSL.name("Publications"), null);
    }

    /**
     * Create an aliased <code>conference.Publications</code> table reference
     */
    public Publications(String alias) {
        this(DSL.name(alias), PUBLICATIONS);
    }

    /**
     * Create an aliased <code>conference.Publications</code> table reference
     */
    public Publications(Name alias) {
        this(alias, PUBLICATIONS);
    }

    private Publications(Name alias, Table<PublicationsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Publications(Name alias, Table<PublicationsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Publications(Table<O> child, ForeignKey<O, PublicationsRecord> key) {
        super(child, key, PUBLICATIONS);
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
        return Arrays.<Index>asList(Indexes.PUBLICATIONS_PRIMARY, Indexes.PUBLICATIONS_PUBLICATIONS_FK0, Indexes.PUBLICATIONS_PUBLICATIONS_FK1, Indexes.PUBLICATIONS_PUBLICATIONS_FK2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PublicationsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PUBLICATIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PublicationsRecord> getPrimaryKey() {
        return Keys.KEY_PUBLICATIONS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PublicationsRecord>> getKeys() {
        return Arrays.<UniqueKey<PublicationsRecord>>asList(Keys.KEY_PUBLICATIONS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PublicationsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PublicationsRecord, ?>>asList(Keys.PUBLICATIONS_FK0, Keys.PUBLICATIONS_FK1, Keys.PUBLICATIONS_FK2);
    }

    public TypeEdition typeEdition() {
        return new TypeEdition(this, Keys.PUBLICATIONS_FK0);
    }

    public Participant participant() {
        return new Participant(this, Keys.PUBLICATIONS_FK1);
    }

    public TypePublication typePublication() {
        return new TypePublication(this, Keys.PUBLICATIONS_FK2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Publications as(String alias) {
        return new Publications(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Publications as(Name alias) {
        return new Publications(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Publications rename(String name) {
        return new Publications(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Publications rename(Name name) {
        return new Publications(name, null);
    }
}