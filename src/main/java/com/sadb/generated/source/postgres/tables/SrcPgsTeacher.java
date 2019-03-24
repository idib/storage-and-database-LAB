/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.postgres.tables;


import com.sadb.generated.source.postgres.Indexes;
import com.sadb.generated.source.postgres.Keys;
import com.sadb.generated.source.postgres.Public;
import com.sadb.generated.source.postgres.tables.records.SrcPgsTeacherRecord;

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
public class SrcPgsTeacher extends TableImpl<SrcPgsTeacherRecord> {

    private static final long serialVersionUID = 1689632455;

    /**
     * The reference instance of <code>public.src_pgs_teacher</code>
     */
    public static final SrcPgsTeacher SRC_PGS_TEACHER = new SrcPgsTeacher();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SrcPgsTeacherRecord> getRecordType() {
        return SrcPgsTeacherRecord.class;
    }

    /**
     * The column <code>public.src_pgs_teacher.id</code>.
     */
    public final TableField<SrcPgsTeacherRecord, BigDecimal> ID = createField("id", org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.src_pgs_teacher.fio</code>.
     */
    public final TableField<SrcPgsTeacherRecord, String> FIO = createField("fio", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.src_pgs_teacher.created_at</code>.
     */
    public final TableField<SrcPgsTeacherRecord, OffsetDateTime> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * The column <code>public.src_pgs_teacher.updated_at</code>.
     */
    public final TableField<SrcPgsTeacherRecord, OffsetDateTime> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * Create a <code>public.src_pgs_teacher</code> table reference
     */
    public SrcPgsTeacher() {
        this(DSL.name("src_pgs_teacher"), null);
    }

    /**
     * Create an aliased <code>public.src_pgs_teacher</code> table reference
     */
    public SrcPgsTeacher(String alias) {
        this(DSL.name(alias), SRC_PGS_TEACHER);
    }

    /**
     * Create an aliased <code>public.src_pgs_teacher</code> table reference
     */
    public SrcPgsTeacher(Name alias) {
        this(alias, SRC_PGS_TEACHER);
    }

    private SrcPgsTeacher(Name alias, Table<SrcPgsTeacherRecord> aliased) {
        this(alias, aliased, null);
    }

    private SrcPgsTeacher(Name alias, Table<SrcPgsTeacherRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SrcPgsTeacher(Table<O> child, ForeignKey<O, SrcPgsTeacherRecord> key) {
        super(child, key, SRC_PGS_TEACHER);
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
        return Arrays.<Index>asList(Indexes.SRC_PGS_TEACHER_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SrcPgsTeacherRecord> getPrimaryKey() {
        return Keys.SRC_PGS_TEACHER_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SrcPgsTeacherRecord>> getKeys() {
        return Arrays.<UniqueKey<SrcPgsTeacherRecord>>asList(Keys.SRC_PGS_TEACHER_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsTeacher as(String alias) {
        return new SrcPgsTeacher(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsTeacher as(Name alias) {
        return new SrcPgsTeacher(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SrcPgsTeacher rename(String name) {
        return new SrcPgsTeacher(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SrcPgsTeacher rename(Name name) {
        return new SrcPgsTeacher(name, null);
    }
}
