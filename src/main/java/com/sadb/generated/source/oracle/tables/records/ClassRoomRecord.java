/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.oracle.tables.records;


import com.sadb.generated.source.oracle.tables.ClassRoom;

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
public class ClassRoomRecord extends UpdatableRecordImpl<ClassRoomRecord> implements Record4<BigInteger, BigInteger, Date, Date> {

    private static final long serialVersionUID = 504910315;

    /**
     * Setter for <code>USER1.CLASS_ROOM.CLASS_ID</code>.
     */
    public void setClassId(BigInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>USER1.CLASS_ROOM.CLASS_ID</code>.
     */
    public BigInteger getClassId() {
        return (BigInteger) get(0);
    }

    /**
     * Setter for <code>USER1.CLASS_ROOM.CLASS_NUMBER</code>.
     */
    public void setClassNumber(BigInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>USER1.CLASS_ROOM.CLASS_NUMBER</code>.
     */
    public BigInteger getClassNumber() {
        return (BigInteger) get(1);
    }

    /**
     * Setter for <code>USER1.CLASS_ROOM.CREAT_TIME</code>.
     */
    public void setCreatTime(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>USER1.CLASS_ROOM.CREAT_TIME</code>.
     */
    public Date getCreatTime() {
        return (Date) get(2);
    }

    /**
     * Setter for <code>USER1.CLASS_ROOM.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Date value) {
        set(3, value);
    }

    /**
     * Getter for <code>USER1.CLASS_ROOM.UPDATE_TIME</code>.
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
    public Row4<BigInteger, BigInteger, Date, Date> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<BigInteger, BigInteger, Date, Date> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field1() {
        return ClassRoom.CLASS_ROOM.CLASS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field2() {
        return ClassRoom.CLASS_ROOM.CLASS_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return ClassRoom.CLASS_ROOM.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field4() {
        return ClassRoom.CLASS_ROOM.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component1() {
        return getClassId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component2() {
        return getClassNumber();
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
        return getClassId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value2() {
        return getClassNumber();
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
    public ClassRoomRecord value1(BigInteger value) {
        setClassId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassRoomRecord value2(BigInteger value) {
        setClassNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassRoomRecord value3(Date value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassRoomRecord value4(Date value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassRoomRecord values(BigInteger value1, BigInteger value2, Date value3, Date value4) {
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
    public ClassRoomRecord(BigInteger classId, BigInteger classNumber, Date creatTime, Date updateTime) {
        super(ClassRoom.CLASS_ROOM);

        set(0, classId);
        set(1, classNumber);
        set(2, creatTime);
        set(3, updateTime);
    }
}
