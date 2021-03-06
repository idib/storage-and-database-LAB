/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.oracle.tables.records;


import com.sadb.generated.source.oracle.tables.Megafaculty;

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
public class MegafacultyRecord extends UpdatableRecordImpl<MegafacultyRecord> implements Record4<BigInteger, String, Date, Date> {

    private static final long serialVersionUID = -550107617;

    /**
     * Setter for <code>USER1.MEGAFACULTY.MEGAFAC_ID</code>.
     */
    public void setMegafacId(BigInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>USER1.MEGAFACULTY.MEGAFAC_ID</code>.
     */
    public BigInteger getMegafacId() {
        return (BigInteger) get(0);
    }

    /**
     * Setter for <code>USER1.MEGAFACULTY.MFACULTY_NAME</code>.
     */
    public void setMfacultyName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>USER1.MEGAFACULTY.MFACULTY_NAME</code>.
     */
    public String getMfacultyName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>USER1.MEGAFACULTY.CREAT_TIME</code>.
     */
    public void setCreatTime(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>USER1.MEGAFACULTY.CREAT_TIME</code>.
     */
    public Date getCreatTime() {
        return (Date) get(2);
    }

    /**
     * Setter for <code>USER1.MEGAFACULTY.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Date value) {
        set(3, value);
    }

    /**
     * Getter for <code>USER1.MEGAFACULTY.UPDATE_TIME</code>.
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
        return Megafaculty.MEGAFACULTY.MEGAFAC_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Megafaculty.MEGAFACULTY.MFACULTY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return Megafaculty.MEGAFACULTY.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field4() {
        return Megafaculty.MEGAFACULTY.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component1() {
        return getMegafacId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getMfacultyName();
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
        return getMegafacId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getMfacultyName();
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
    public MegafacultyRecord value1(BigInteger value) {
        setMegafacId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MegafacultyRecord value2(String value) {
        setMfacultyName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MegafacultyRecord value3(Date value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MegafacultyRecord value4(Date value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MegafacultyRecord values(BigInteger value1, String value2, Date value3, Date value4) {
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
     * Create a detached MegafacultyRecord
     */
    public MegafacultyRecord() {
        super(Megafaculty.MEGAFACULTY);
    }

    /**
     * Create a detached, initialised MegafacultyRecord
     */
    public MegafacultyRecord(BigInteger megafacId, String mfacultyName, Date creatTime, Date updateTime) {
        super(Megafaculty.MEGAFACULTY);

        set(0, megafacId);
        set(1, mfacultyName);
        set(2, creatTime);
        set(3, updateTime);
    }
}
