/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables.records;


import com.sadb.generated.dest.oracle.tables.WeekDay;

import java.sql.Timestamp;

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
public class WeekDayRecord extends UpdatableRecordImpl<WeekDayRecord> implements Record4<Long, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = -2112459357;

    /**
     * Setter for <code>SANDDB.WEEK_DAY.WEEK_DAY_ID</code>.
     */
    public void setWeekDayId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>SANDDB.WEEK_DAY.WEEK_DAY_ID</code>.
     */
    public Long getWeekDayId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>SANDDB.WEEK_DAY.DAY</code>.
     */
    public void setDay(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SANDDB.WEEK_DAY.DAY</code>.
     */
    public String getDay() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SANDDB.WEEK_DAY.CREAT_TIME</code>.
     */
    public void setCreatTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>SANDDB.WEEK_DAY.CREAT_TIME</code>.
     */
    public Timestamp getCreatTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>SANDDB.WEEK_DAY.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>SANDDB.WEEK_DAY.UPDATE_TIME</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, Timestamp, Timestamp> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, Timestamp, Timestamp> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return WeekDay.WEEK_DAY.WEEK_DAY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return WeekDay.WEEK_DAY.DAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return WeekDay.WEEK_DAY.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return WeekDay.WEEK_DAY.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getWeekDayId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getDay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getWeekDayId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WeekDayRecord value1(Long value) {
        setWeekDayId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WeekDayRecord value2(String value) {
        setDay(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WeekDayRecord value3(Timestamp value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WeekDayRecord value4(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WeekDayRecord values(Long value1, String value2, Timestamp value3, Timestamp value4) {
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
     * Create a detached WeekDayRecord
     */
    public WeekDayRecord() {
        super(WeekDay.WEEK_DAY);
    }

    /**
     * Create a detached, initialised WeekDayRecord
     */
    public WeekDayRecord(Long weekDayId, String day, Timestamp creatTime, Timestamp updateTime) {
        super(WeekDay.WEEK_DAY);

        set(0, weekDayId);
        set(1, day);
        set(2, creatTime);
        set(3, updateTime);
    }
}