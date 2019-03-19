/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables.records;


import com.sadb.generated.dest.oracle.tables.ClassRoom;

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
public class ClassRoomRecord extends UpdatableRecordImpl<ClassRoomRecord> implements Record4<Long, Long, Timestamp, Timestamp> {

    private static final long serialVersionUID = -285904267;

    /**
     * Setter for <code>SANDDB.CLASS_ROOM.CLASS_ID</code>.
     */
    public void setClassId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>SANDDB.CLASS_ROOM.CLASS_ID</code>.
     */
    public Long getClassId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>SANDDB.CLASS_ROOM.CLASS_NUMBER</code>.
     */
    public void setClassNumber(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>SANDDB.CLASS_ROOM.CLASS_NUMBER</code>.
     */
    public Long getClassNumber() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>SANDDB.CLASS_ROOM.CREAT_TIME</code>.
     */
    public void setCreatTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>SANDDB.CLASS_ROOM.CREAT_TIME</code>.
     */
    public Timestamp getCreatTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>SANDDB.CLASS_ROOM.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>SANDDB.CLASS_ROOM.UPDATE_TIME</code>.
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
    public Row4<Long, Long, Timestamp, Timestamp> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, Long, Timestamp, Timestamp> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ClassRoom.CLASS_ROOM.CLASS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return ClassRoom.CLASS_ROOM.CLASS_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return ClassRoom.CLASS_ROOM.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return ClassRoom.CLASS_ROOM.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getClassId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getClassNumber();
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
        return getClassId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getClassNumber();
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
    public ClassRoomRecord value1(Long value) {
        setClassId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassRoomRecord value2(Long value) {
        setClassNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassRoomRecord value3(Timestamp value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassRoomRecord value4(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassRoomRecord values(Long value1, Long value2, Timestamp value3, Timestamp value4) {
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
     * Create a detached ClassRoomRecord
     */
    public ClassRoomRecord() {
        super(ClassRoom.CLASS_ROOM);
    }

    /**
     * Create a detached, initialised ClassRoomRecord
     */
    public ClassRoomRecord(Long classId, Long classNumber, Timestamp creatTime, Timestamp updateTime) {
        super(ClassRoom.CLASS_ROOM);

        set(0, classId);
        set(1, classNumber);
        set(2, creatTime);
        set(3, updateTime);
    }
}
