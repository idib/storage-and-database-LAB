/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.postgres.tables;


import com.sadb.generated.source.postgres.Indexes;
import com.sadb.generated.source.postgres.Keys;
import com.sadb.generated.source.postgres.Public;
import com.sadb.generated.source.postgres.tables.records.SrcPgsSudentRecord;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
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
public class SrcPgsSudent extends TableImpl<SrcPgsSudentRecord> {

    private static final long serialVersionUID = 902471394;

    /**
     * The reference instance of <code>public.src_pgs_sudent</code>
     */
    public static final SrcPgsSudent SRC_PGS_SUDENT = new SrcPgsSudent();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SrcPgsSudentRecord> getRecordType() {
        return SrcPgsSudentRecord.class;
    }

    /**
     * The column <code>public.src_pgs_sudent.id</code>.
     */
    public final TableField<SrcPgsSudentRecord, BigDecimal> ID = createField("id", org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.src_pgs_sudent.fio</code>.
     */
    public final TableField<SrcPgsSudentRecord, String> FIO = createField("fio", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.src_pgs_sudent.university</code>.
     */
    public final TableField<SrcPgsSudentRecord, String> UNIVERSITY = createField("university", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.src_pgs_sudent.education_form</code>.
     */
    public final TableField<SrcPgsSudentRecord, String> EDUCATION_FORM = createField("education_form", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.src_pgs_sudent.education_place</code>.
     */
    public final TableField<SrcPgsSudentRecord, String> EDUCATION_PLACE = createField("education_place", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.src_pgs_sudent.speciality</code>.
     */
    public final TableField<SrcPgsSudentRecord, String> SPECIALITY = createField("speciality", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.src_pgs_sudent.semester</code>.
     */
    public final TableField<SrcPgsSudentRecord, BigDecimal> SEMESTER = createField("semester", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * The column <code>public.src_pgs_sudent.created_at</code>.
     */
    public final TableField<SrcPgsSudentRecord, OffsetDateTime> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * The column <code>public.src_pgs_sudent.updated_at</code>.
     */
    public final TableField<SrcPgsSudentRecord, OffsetDateTime> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * Create a <code>public.src_pgs_sudent</code> table reference
     */
    public SrcPgsSudent() {
        this(DSL.name("src_pgs_sudent"), null);
    }

    /**
     * Create an aliased <code>public.src_pgs_sudent</code> table reference
     */
    public SrcPgsSudent(String alias) {
        this(DSL.name(alias), SRC_PGS_SUDENT);
    }

    /**
     * Create an aliased <code>public.src_pgs_sudent</code> table reference
     */
    public SrcPgsSudent(Name alias) {
        this(alias, SRC_PGS_SUDENT);
    }

    private SrcPgsSudent(Name alias, Table<SrcPgsSudentRecord> aliased) {
        this(alias, aliased, null);
    }

    private SrcPgsSudent(Name alias, Table<SrcPgsSudentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SrcPgsSudent(Table<O> child, ForeignKey<O, SrcPgsSudentRecord> key) {
        super(child, key, SRC_PGS_SUDENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SRC_PGS_SUDENT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SrcPgsSudentRecord> getPrimaryKey() {
        return Keys.SRC_PGS_SUDENT_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SrcPgsSudentRecord>> getKeys() {
        return Arrays.<UniqueKey<SrcPgsSudentRecord>>asList(Keys.SRC_PGS_SUDENT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudent as(String alias) {
        return new SrcPgsSudent(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudent as(Name alias) {
        return new SrcPgsSudent(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SrcPgsSudent rename(String name) {
        return new SrcPgsSudent(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SrcPgsSudent rename(Name name) {
        return new SrcPgsSudent(name, null);
    }
}