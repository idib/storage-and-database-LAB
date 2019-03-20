/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables.records;


import com.sadb.generated.dest.oracle.tables.Lecturer;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
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
public class LecturerRecord extends UpdatableRecordImpl<LecturerRecord> implements Record11<Long, String, String, String, Timestamp, String, String, Timestamp, Timestamp, Timestamp, Timestamp> {

    private static final long serialVersionUID = -279941447;

    /**
     * Setter for <code>SANDDB.LECTURER.LEC_ID</code>.
     */
    public void setLecId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.LEC_ID</code>.
     */
    public Long getLecId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.SECOND_NAME</code>.
     */
    public void setSecondName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.SECOND_NAME</code>.
     */
    public String getSecondName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.FIRST_NAME</code>.
     */
    public void setFirstName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.FIRST_NAME</code>.
     */
    public String getFirstName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.PATRONYMIC_NAME</code>.
     */
    public void setPatronymicName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.PATRONYMIC_NAME</code>.
     */
    public String getPatronymicName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.BIRTH_DATE</code>.
     */
    public void setBirthDate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.BIRTH_DATE</code>.
     */
    public Timestamp getBirthDate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.BIRTH_PLACE</code>.
     */
    public void setBirthPlace(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.BIRTH_PLACE</code>.
     */
    public String getBirthPlace() {
        return (String) get(5);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.POST</code>.
     */
    public void setPost(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.POST</code>.
     */
    public String getPost() {
        return (String) get(6);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.WORK_PERIOD_FROM</code>.
     */
    public void setWorkPeriodFrom(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.WORK_PERIOD_FROM</code>.
     */
    public Timestamp getWorkPeriodFrom() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.WORK_PERIOD_TO</code>.
     */
    public void setWorkPeriodTo(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.WORK_PERIOD_TO</code>.
     */
    public Timestamp getWorkPeriodTo() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.CREAT_TIME</code>.
     */
    public void setCreatTime(Timestamp value) {
        set(9, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.CREAT_TIME</code>.
     */
    public Timestamp getCreatTime() {
        return (Timestamp) get(9);
    }

    /**
     * Setter for <code>SANDDB.LECTURER.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>SANDDB.LECTURER.UPDATE_TIME</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, Timestamp, String, String, Timestamp, Timestamp, Timestamp, Timestamp> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, Timestamp, String, String, Timestamp, Timestamp, Timestamp, Timestamp> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Lecturer.LECTURER.LEC_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Lecturer.LECTURER.SECOND_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Lecturer.LECTURER.FIRST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Lecturer.LECTURER.PATRONYMIC_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Lecturer.LECTURER.BIRTH_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Lecturer.LECTURER.BIRTH_PLACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Lecturer.LECTURER.POST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return Lecturer.LECTURER.WORK_PERIOD_FROM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return Lecturer.LECTURER.WORK_PERIOD_TO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field10() {
        return Lecturer.LECTURER.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return Lecturer.LECTURER.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getLecId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getSecondName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPatronymicName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getBirthDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getBirthPlace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getPost();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getWorkPeriodFrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component9() {
        return getWorkPeriodTo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component10() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component11() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getLecId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSecondName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPatronymicName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getBirthDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getBirthPlace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getPost();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getWorkPeriodFrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getWorkPeriodTo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value10() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value1(Long value) {
        setLecId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value2(String value) {
        setSecondName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value3(String value) {
        setFirstName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value4(String value) {
        setPatronymicName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value5(Timestamp value) {
        setBirthDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value6(String value) {
        setBirthPlace(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value7(String value) {
        setPost(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value8(Timestamp value) {
        setWorkPeriodFrom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value9(Timestamp value) {
        setWorkPeriodTo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value10(Timestamp value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord value11(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LecturerRecord values(Long value1, String value2, String value3, String value4, Timestamp value5, String value6, String value7, Timestamp value8, Timestamp value9, Timestamp value10, Timestamp value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LecturerRecord
     */
    public LecturerRecord() {
        super(Lecturer.LECTURER);
    }

    /**
     * Create a detached, initialised LecturerRecord
     */
    public LecturerRecord(Long lecId, String secondName, String firstName, String patronymicName, Timestamp birthDate, String birthPlace, String post, Timestamp workPeriodFrom, Timestamp workPeriodTo, Timestamp creatTime, Timestamp updateTime) {
        super(Lecturer.LECTURER);

        set(0, lecId);
        set(1, secondName);
        set(2, firstName);
        set(3, patronymicName);
        set(4, birthDate);
        set(5, birthPlace);
        set(6, post);
        set(7, workPeriodFrom);
        set(8, workPeriodTo);
        set(9, creatTime);
        set(10, updateTime);
    }
}
