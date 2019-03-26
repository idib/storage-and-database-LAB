/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.oracle.tables.records;


import com.sadb.generated.source.oracle.tables.Groups;

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
public class GroupsRecord extends UpdatableRecordImpl<GroupsRecord> implements Record9<BigInteger, BigInteger, String, BigInteger, Date, Date, BigInteger, Date, Date> {

    private static final long serialVersionUID = -2038224191;

    /**
     * Setter for <code>USER1.GROUPS.GROUP_ID</code>.
     */
    public void setGroupId(BigInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>USER1.GROUPS.GROUP_ID</code>.
     */
    public BigInteger getGroupId() {
        return (BigInteger) get(0);
    }

    /**
     * Setter for <code>USER1.GROUPS.SPEC_ID</code>.
     */
    public void setSpecId(BigInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>USER1.GROUPS.SPEC_ID</code>.
     */
    public BigInteger getSpecId() {
        return (BigInteger) get(1);
    }

    /**
     * Setter for <code>USER1.GROUPS.GROUP_NUM</code>.
     */
    public void setGroupNum(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>USER1.GROUPS.GROUP_NUM</code>.
     */
    public String getGroupNum() {
        return (String) get(2);
    }

    /**
     * Setter for <code>USER1.GROUPS.COURSE</code>.
     */
    public void setCourse(BigInteger value) {
        set(3, value);
    }

    /**
     * Getter for <code>USER1.GROUPS.COURSE</code>.
     */
    public BigInteger getCourse() {
        return (BigInteger) get(3);
    }

    /**
     * Setter for <code>USER1.GROUPS.EDUCATION_TIME_FROM</code>.
     */
    public void setEducationTimeFrom(Date value) {
        set(4, value);
    }

    /**
     * Getter for <code>USER1.GROUPS.EDUCATION_TIME_FROM</code>.
     */
    public Date getEducationTimeFrom() {
        return (Date) get(4);
    }

    /**
     * Setter for <code>USER1.GROUPS.EDUCATION_TIME_TO</code>.
     */
    public void setEducationTimeTo(Date value) {
        set(5, value);
    }

    /**
     * Getter for <code>USER1.GROUPS.EDUCATION_TIME_TO</code>.
     */
    public Date getEducationTimeTo() {
        return (Date) get(5);
    }

    /**
     * Setter for <code>USER1.GROUPS.ACADEM_YEAR_ID</code>.
     */
    public void setAcademYearId(BigInteger value) {
        set(6, value);
    }

    /**
     * Getter for <code>USER1.GROUPS.ACADEM_YEAR_ID</code>.
     */
    public BigInteger getAcademYearId() {
        return (BigInteger) get(6);
    }

    /**
     * Setter for <code>USER1.GROUPS.CREAT_TIME</code>.
     */
    public void setCreatTime(Date value) {
        set(7, value);
    }

    /**
     * Getter for <code>USER1.GROUPS.CREAT_TIME</code>.
     */
    public Date getCreatTime() {
        return (Date) get(7);
    }

    /**
     * Setter for <code>USER1.GROUPS.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Date value) {
        set(8, value);
    }

    /**
     * Getter for <code>USER1.GROUPS.UPDATE_TIME</code>.
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
    public Row9<BigInteger, BigInteger, String, BigInteger, Date, Date, BigInteger, Date, Date> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<BigInteger, BigInteger, String, BigInteger, Date, Date, BigInteger, Date, Date> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field1() {
        return Groups.GROUPS.GROUP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field2() {
        return Groups.GROUPS.SPEC_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Groups.GROUPS.GROUP_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field4() {
        return Groups.GROUPS.COURSE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field5() {
        return Groups.GROUPS.EDUCATION_TIME_FROM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field6() {
        return Groups.GROUPS.EDUCATION_TIME_TO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field7() {
        return Groups.GROUPS.ACADEM_YEAR_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field8() {
        return Groups.GROUPS.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field9() {
        return Groups.GROUPS.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component1() {
        return getGroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component2() {
        return getSpecId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getGroupNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component4() {
        return getCourse();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component5() {
        return getEducationTimeFrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component6() {
        return getEducationTimeTo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component7() {
        return getAcademYearId();
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
        return getGroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value2() {
        return getSpecId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getGroupNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value4() {
        return getCourse();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value5() {
        return getEducationTimeFrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value6() {
        return getEducationTimeTo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value7() {
        return getAcademYearId();
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
    public GroupsRecord value1(BigInteger value) {
        setGroupId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsRecord value2(BigInteger value) {
        setSpecId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsRecord value3(String value) {
        setGroupNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsRecord value4(BigInteger value) {
        setCourse(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsRecord value5(Date value) {
        setEducationTimeFrom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsRecord value6(Date value) {
        setEducationTimeTo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsRecord value7(BigInteger value) {
        setAcademYearId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsRecord value8(Date value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsRecord value9(Date value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsRecord values(BigInteger value1, BigInteger value2, String value3, BigInteger value4, Date value5, Date value6, BigInteger value7, Date value8, Date value9) {
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
     * Create a detached GroupsRecord
     */
    public GroupsRecord() {
        super(Groups.GROUPS);
    }

    /**
     * Create a detached, initialised GroupsRecord
     */
    public GroupsRecord(BigInteger groupId, BigInteger specId, String groupNum, BigInteger course, Date educationTimeFrom, Date educationTimeTo, BigInteger academYearId, Date creatTime, Date updateTime) {
        super(Groups.GROUPS);

        set(0, groupId);
        set(1, specId);
        set(2, groupNum);
        set(3, course);
        set(4, educationTimeFrom);
        set(5, educationTimeTo);
        set(6, academYearId);
        set(7, creatTime);
        set(8, updateTime);
    }
}