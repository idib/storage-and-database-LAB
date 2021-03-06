/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables;


import com.sadb.generated.dest.oracle.Indexes;
import com.sadb.generated.dest.oracle.Keys;
import com.sadb.generated.dest.oracle.Sanddb;
import com.sadb.generated.dest.oracle.tables.records.PublicationsRecord;

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
public class Publications extends TableImpl<PublicationsRecord> {

    private static final long serialVersionUID = 118832508;

    /**
     * The reference instance of <code>SANDDB.PUBLICATIONS</code>
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
     * The column <code>SANDDB.PUBLICATIONS.ID</code>.
     */
    public final TableField<PublicationsRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.TITLE_EDITION</code>.
     */
    public final TableField<PublicationsRecord, String> TITLE_EDITION = createField("TITLE_EDITION", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.LANGUAGE_PUBLICATION</code>.
     */
    public final TableField<PublicationsRecord, String> LANGUAGE_PUBLICATION = createField("LANGUAGE_PUBLICATION", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.VOLUME_EDITION</code>.
     */
    public final TableField<PublicationsRecord, String> VOLUME_EDITION = createField("VOLUME_EDITION", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.PLACE_EDITON</code>.
     */
    public final TableField<PublicationsRecord, String> PLACE_EDITON = createField("PLACE_EDITON", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.EDITION_ID</code>.
     */
    public final TableField<PublicationsRecord, Long> EDITION_ID = createField("EDITION_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.CO_AUTHORS</code>.
     */
    public final TableField<PublicationsRecord, String> CO_AUTHORS = createField("CO_AUTHORS", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.CITATION_INDEX</code>.
     */
    public final TableField<PublicationsRecord, Double> CITATION_INDEX = createField("CITATION_INDEX", org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.DATA_PUBLICATION</code>.
     */
    public final TableField<PublicationsRecord, Date> DATA_PUBLICATION = createField("DATA_PUBLICATION", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.PARTICIPANT_ID</code>.
     */
    public final TableField<PublicationsRecord, Long> PARTICIPANT_ID = createField("PARTICIPANT_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.ID_TYPE_PUBLICATION</code>.
     */
    public final TableField<PublicationsRecord, Long> ID_TYPE_PUBLICATION = createField("ID_TYPE_PUBLICATION", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.DATA_UPDATE</code>.
     */
    public final TableField<PublicationsRecord, Timestamp> DATA_UPDATE = createField("DATA_UPDATE", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38).nullable(false), this, "");

    /**
     * The column <code>SANDDB.PUBLICATIONS.DATA_CREATE</code>.
     */
    public final TableField<PublicationsRecord, Timestamp> DATA_CREATE = createField("DATA_CREATE", org.jooq.impl.SQLDataType.TIMESTAMP.precision(38).nullable(false), this, "");

    /**
     * Create a <code>SANDDB.PUBLICATIONS</code> table reference
     */
    public Publications() {
        this(DSL.name("PUBLICATIONS"), null);
    }

    /**
     * Create an aliased <code>SANDDB.PUBLICATIONS</code> table reference
     */
    public Publications(String alias) {
        this(DSL.name(alias), PUBLICATIONS);
    }

    /**
     * Create an aliased <code>SANDDB.PUBLICATIONS</code> table reference
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
        return Sanddb.SANDDB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SYS_C005186);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PublicationsRecord> getPrimaryKey() {
        return Keys.SYS_C005186;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PublicationsRecord>> getKeys() {
        return Arrays.<UniqueKey<PublicationsRecord>>asList(Keys.SYS_C005186);
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

    public Student student() {
        return new Student(this, Keys.PUBLICATIONS_FK1);
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
