/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.oracle.tables.records;


import com.sadb.generated.source.oracle.tables.Speciality;

import java.math.BigInteger;
import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class SpecialityRecord extends UpdatableRecordImpl<SpecialityRecord> implements Record9<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, Date, Date> {

    private static final long serialVersionUID = -1459648453;

    /**
     * Setter for <code>USER1.SPECIALITY.SPEC_ID</code>.
     */
    public void setSpecId(BigInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>USER1.SPECIALITY.SPEC_ID</code>.
     */
    public BigInteger getSpecId() {
        return (BigInteger) get(0);
    }

    /**
     * Setter for <code>USER1.SPECIALITY.SPEC_NAME</code>.
     */
    public void setSpecName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>USER1.SPECIALITY.SPEC_NAME</code>.
     */
    public String getSpecName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>USER1.SPECIALITY.SPEC_DEGREE</code>.
     */
    public void setSpecDegree(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>USER1.SPECIALITY.SPEC_DEGREE</code>.
     */
    public String getSpecDegree() {
        return (String) get(2);
    }

    /**
     * Setter for <code>USER1.SPECIALITY.FREE_EDUC_COUNT</code>.
     */
    public void setFreeEducCount(BigInteger value) {
        set(3, value);
    }

    /**
     * Getter for <code>USER1.SPECIALITY.FREE_EDUC_COUNT</code>.
     */
    public BigInteger getFreeEducCount() {
        return (BigInteger) get(3);
    }

    /**
     * Setter for <code>USER1.SPECIALITY.PAID_EDUC_COUNT</code>.
     */
    public void setPaidEducCount(BigInteger value) {
        set(4, value);
    }

    /**
     * Getter for <code>USER1.SPECIALITY.PAID_EDUC_COUNT</code>.
     */
    public BigInteger getPaidEducCount() {
        return (BigInteger) get(4);
    }

    /**
     * Setter for <code>USER1.SPECIALITY.SPONSORED_EDUC_COUNT</code>.
     */
    public void setSponsoredEducCount(BigInteger value) {
        set(5, value);
    }

    /**
     * Getter for <code>USER1.SPECIALITY.SPONSORED_EDUC_COUNT</code>.
     */
    public BigInteger getSponsoredEducCount() {
        return (BigInteger) get(5);
    }

    /**
     * Setter for <code>USER1.SPECIALITY.PROG_ID</code>.
     */
    public void setProgId(BigInteger value) {
        set(6, value);
    }

    /**
     * Getter for <code>USER1.SPECIALITY.PROG_ID</code>.
     */
    public BigInteger getProgId() {
        return (BigInteger) get(6);
    }

    /**
     * Setter for <code>USER1.SPECIALITY.CREAT_TIME</code>.
     */
    public void setCreatTime(Date value) {
        set(7, value);
    }

    /**
     * Getter for <code>USER1.SPECIALITY.CREAT_TIME</code>.
     */
    public Date getCreatTime() {
        return (Date) get(7);
    }

    /**
     * Setter for <code>USER1.SPECIALITY.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Date value) {
        set(8, value);
    }

    /**
     * Getter for <code>USER1.SPECIALITY.UPDATE_TIME</code>.
     */
    public Date getUpdateTime() {
        return (Date) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, Date, Date> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, Date, Date> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field1() {
        return Speciality.SPECIALITY.SPEC_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Speciality.SPECIALITY.SPEC_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Speciality.SPECIALITY.SPEC_DEGREE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field4() {
        return Speciality.SPECIALITY.FREE_EDUC_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field5() {
        return Speciality.SPECIALITY.PAID_EDUC_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field6() {
        return Speciality.SPECIALITY.SPONSORED_EDUC_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field7() {
        return Speciality.SPECIALITY.PROG_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field8() {
        return Speciality.SPECIALITY.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field9() {
        return Speciality.SPECIALITY.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component1() {
        return getSpecId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getSpecName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSpecDegree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component4() {
        return getFreeEducCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component5() {
        return getPaidEducCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component6() {
        return getSponsoredEducCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component7() {
        return getProgId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component8() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component9() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value1() {
        return getSpecId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSpecName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSpecDegree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value4() {
        return getFreeEducCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value5() {
        return getPaidEducCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value6() {
        return getSponsoredEducCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value7() {
        return getProgId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value8() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value9() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord value1(BigInteger value) {
        setSpecId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord value2(String value) {
        setSpecName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord value3(String value) {
        setSpecDegree(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord value4(BigInteger value) {
        setFreeEducCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord value5(BigInteger value) {
        setPaidEducCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord value6(BigInteger value) {
        setSponsoredEducCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord value7(BigInteger value) {
        setProgId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord value8(Date value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord value9(Date value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpecialityRecord values(BigInteger value1, String value2, String value3, BigInteger value4, BigInteger value5, BigInteger value6, BigInteger value7, Date value8, Date value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SpecialityRecord
     */
    public SpecialityRecord() {
        super(Speciality.SPECIALITY);
    }

    /**
     * Create a detached, initialised SpecialityRecord
     */
    public SpecialityRecord(BigInteger specId, String specName, String specDegree, BigInteger freeEducCount, BigInteger paidEducCount, BigInteger sponsoredEducCount, BigInteger progId, Date creatTime, Date updateTime) {
        super(Speciality.SPECIALITY);

        set(0, specId);
        set(1, specName);
        set(2, specDegree);
        set(3, freeEducCount);
        set(4, paidEducCount);
        set(5, sponsoredEducCount);
        set(6, progId);
        set(7, creatTime);
        set(8, updateTime);
    }
}
