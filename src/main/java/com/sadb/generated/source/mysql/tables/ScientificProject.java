/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.mysql.tables;


import com.sadb.generated.source.mysql.Conference;
import com.sadb.generated.source.mysql.Indexes;
import com.sadb.generated.source.mysql.Keys;
import com.sadb.generated.source.mysql.tables.records.ScientificProjectRecord;

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
public class ScientificProject extends TableImpl<ScientificProjectRecord> {

    private static final long serialVersionUID = 326887136;

    /**
     * The reference instance of <code>conference.Scientific_project</code>
     */
    public static final ScientificProject SCIENTIFIC_PROJECT = new ScientificProject();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ScientificProjectRecord> getRecordType() {
        return ScientificProjectRecord.class;
    }

    /**
     * The column <code>conference.Scientific_project.id</code>.
     */
    public final TableField<ScientificProjectRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>conference.Scientific_project.Name</code>.
     */
    public final TableField<ScientificProjectRecord, String> NAME = createField("Name", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>conference.Scientific_project.Period_participation</code>.
     */
    public final TableField<ScientificProjectRecord, String> PERIOD_PARTICIPATION = createField("Period_participation", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>conference.Scientific_project.data_update</code>.
     */
    public final TableField<ScientificProjectRecord, Timestamp> DATA_UPDATE = createField("data_update", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>conference.Scientific_project.data_create</code>.
     */
    public final TableField<ScientificProjectRecord, Timestamp> DATA_CREATE = createField("data_create", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>conference.Scientific_project</code> table reference
     */
    public ScientificProject() {
        this(DSL.name("Scientific_project"), null);
    }

    /**
     * Create an aliased <code>conference.Scientific_project</code> table reference
     */
    public ScientificProject(String alias) {
        this(DSL.name(alias), SCIENTIFIC_PROJECT);
    }

    /**
     * Create an aliased <code>conference.Scientific_project</code> table reference
     */
    public ScientificProject(Name alias) {
        this(alias, SCIENTIFIC_PROJECT);
    }

    private ScientificProject(Name alias, Table<ScientificProjectRecord> aliased) {
        this(alias, aliased, null);
    }

    private ScientificProject(Name alias, Table<ScientificProjectRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ScientificProject(Table<O> child, ForeignKey<O, ScientificProjectRecord> key) {
        super(child, key, SCIENTIFIC_PROJECT);
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
        return Arrays.<Index>asList(Indexes.SCIENTIFIC_PROJECT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ScientificProjectRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SCIENTIFIC_PROJECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ScientificProjectRecord> getPrimaryKey() {
        return Keys.KEY_SCIENTIFIC_PROJECT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ScientificProjectRecord>> getKeys() {
        return Arrays.<UniqueKey<ScientificProjectRecord>>asList(Keys.KEY_SCIENTIFIC_PROJECT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScientificProject as(String alias) {
        return new ScientificProject(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScientificProject as(Name alias) {
        return new ScientificProject(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ScientificProject rename(String name) {
        return new ScientificProject(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ScientificProject rename(Name name) {
        return new ScientificProject(name, null);
    }
}
