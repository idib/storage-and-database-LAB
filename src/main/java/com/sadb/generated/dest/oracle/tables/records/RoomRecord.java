/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables.records;


import com.sadb.generated.dest.oracle.tables.Room;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class RoomRecord extends UpdatableRecordImpl<RoomRecord> implements Record6<Long, String, Long, Long, Timestamp, Timestamp> {

    private static final long serialVersionUID = -616357535;

    /**
     * Setter for <code>SANDDB.ROOM.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>SANDDB.ROOM.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>SANDDB.ROOM.NUMBERROOM</code>.
     */
    public void setNumberroom(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SANDDB.ROOM.NUMBERROOM</code>.
     */
    public String getNumberroom() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SANDDB.ROOM.MAX_STUDENT</code>.
     */
    public void setMaxStudent(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>SANDDB.ROOM.MAX_STUDENT</code>.
     */
    public Long getMaxStudent() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>SANDDB.ROOM.BLOCK_ID</code>.
     */
    public void setBlockId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>SANDDB.ROOM.BLOCK_ID</code>.
     */
    public Long getBlockId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>SANDDB.ROOM.DATE_UPDATE</code>.
     */
    public void setDateUpdate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>SANDDB.ROOM.DATE_UPDATE</code>.
     */
    public Timestamp getDateUpdate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>SANDDB.ROOM.DATE_CREATE</code>.
     */
    public void setDateCreate(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>SANDDB.ROOM.DATE_CREATE</code>.
     */
    public Timestamp getDateCreate() {
        return (Timestamp) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, Long, Long, Timestamp, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, Long, Long, Timestamp, Timestamp> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Room.ROOM.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Room.ROOM.NUMBERROOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return Room.ROOM.MAX_STUDENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return Room.ROOM.BLOCK_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Room.ROOM.DATE_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Room.ROOM.DATE_CREATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getNumberroom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getMaxStudent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component4() {
        return getBlockId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getDateUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getDateCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getNumberroom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getMaxStudent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getBlockId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getDateUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getDateCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoomRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoomRecord value2(String value) {
        setNumberroom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoomRecord value3(Long value) {
        setMaxStudent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoomRecord value4(Long value) {
        setBlockId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoomRecord value5(Timestamp value) {
        setDateUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoomRecord value6(Timestamp value) {
        setDateCreate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoomRecord values(Long value1, String value2, Long value3, Long value4, Timestamp value5, Timestamp value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RoomRecord
     */
    public RoomRecord() {
        super(Room.ROOM);
    }

    /**
     * Create a detached, initialised RoomRecord
     */
    public RoomRecord(Long id, String numberroom, Long maxStudent, Long blockId, Timestamp dateUpdate, Timestamp dateCreate) {
        super(Room.ROOM);

        set(0, id);
        set(1, numberroom);
        set(2, maxStudent);
        set(3, blockId);
        set(4, dateUpdate);
        set(5, dateCreate);
    }
}
