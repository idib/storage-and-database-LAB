/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.oracle.tables.records;


import com.sadb.generated.source.oracle.tables.Discipline;

import java.math.BigInteger;
import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class DisciplineRecord extends UpdatableRecordImpl<DisciplineRecord> implements Record4<BigInteger, String, Date, Date> {

    private static final long serialVersionUID = 1259152015;

    /**
     * Setter for <code>USER1.DISCIPLINE.DISCIPLINE_ID</code>.
     */
    public void setDisciplineId(BigInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>USER1.DISCIPLINE.DISCIPLINE_ID</code>.
     */
    public BigInteger getDisciplineId() {
        return (BigInteger) get(0);
    }

    /**
     * Setter for <code>USER1.DISCIPLINE.DISCIPLINE_NAME</code>.
     */
    public void setDisciplineName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>USER1.DISCIPLINE.DISCIPLINE_NAME</code>.
     */
    public String getDisciplineName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>USER1.DISCIPLINE.CREAT_TIME</code>.
     */
    public void setCreatTime(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>USER1.DISCIPLINE.CREAT_TIME</code>.
     */
    public Date getCreatTime() {
        return (Date) get(2);
    }

    /**
     * Setter for <code>USER1.DISCIPLINE.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Date value) {
        set(3, value);
    }

    /**
     * Getter for <code>USER1.DISCIPLINE.UPDATE_TIME</code>.
     */
    public Date getUpdateTime() {
        return (Date) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<BigInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<BigInteger, String, Date, Date> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<BigInteger, String, Date, Date> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field1() {
        return Discipline.DISCIPLINE.DISCIPLINE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Discipline.DISCIPLINE.DISCIPLINE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return Discipline.DISCIPLINE.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field4() {
        return Discipline.DISCIPLINE.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component1() {
        return getDisciplineId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getDisciplineName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component3() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component4() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value1() {
        return getDisciplineId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDisciplineName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value3() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value4() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value1(BigInteger value) {
        setDisciplineId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value2(String value) {
        setDisciplineName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value3(Date value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value4(Date value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord values(BigInteger value1, String value2, Date value3, Date value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DisciplineRecord
     */
    public DisciplineRecord() {
        super(Discipline.DISCIPLINE);
    }

    /**
     * Create a detached, initialised DisciplineRecord
     */
    public DisciplineRecord(BigInteger disciplineId, String disciplineName, Date creatTime, Date updateTime) {
        super(Discipline.DISCIPLINE);

        set(0, disciplineId);
        set(1, disciplineName);
        set(2, creatTime);
        set(3, updateTime);
    }
}
