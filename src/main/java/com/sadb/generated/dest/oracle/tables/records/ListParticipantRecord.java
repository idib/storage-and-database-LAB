/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables.records;


import com.sadb.generated.dest.oracle.tables.ListParticipant;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


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
public class ListParticipantRecord extends TableRecordImpl<ListParticipantRecord> implements Record4<Long, Long, Timestamp, Timestamp> {

    private static final long serialVersionUID = 556075120;

    /**
     * Setter for <code>SANDDB.LIST_PARTICIPANT.PARTICIPANT_ID</code>.
     */
    public void setParticipantId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>SANDDB.LIST_PARTICIPANT.PARTICIPANT_ID</code>.
     */
    public Long getParticipantId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>SANDDB.LIST_PARTICIPANT.CONFERENCE_ID</code>.
     */
    public void setConferenceId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>SANDDB.LIST_PARTICIPANT.CONFERENCE_ID</code>.
     */
    public Long getConferenceId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>SANDDB.LIST_PARTICIPANT.DATA_UPDATE</code>.
     */
    public void setDataUpdate(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>SANDDB.LIST_PARTICIPANT.DATA_UPDATE</code>.
     */
    public Timestamp getDataUpdate() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>SANDDB.LIST_PARTICIPANT.DATA_CREATE</code>.
     */
    public void setDataCreate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>SANDDB.LIST_PARTICIPANT.DATA_CREATE</code>.
     */
    public Timestamp getDataCreate() {
        return (Timestamp) get(3);
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
        return ListParticipant.LIST_PARTICIPANT.PARTICIPANT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return ListParticipant.LIST_PARTICIPANT.CONFERENCE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return ListParticipant.LIST_PARTICIPANT.DATA_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return ListParticipant.LIST_PARTICIPANT.DATA_CREATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getParticipantId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getConferenceId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getDataUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getDataCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getParticipantId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getConferenceId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getDataUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getDataCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListParticipantRecord value1(Long value) {
        setParticipantId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListParticipantRecord value2(Long value) {
        setConferenceId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListParticipantRecord value3(Timestamp value) {
        setDataUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListParticipantRecord value4(Timestamp value) {
        setDataCreate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListParticipantRecord values(Long value1, Long value2, Timestamp value3, Timestamp value4) {
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
     * Create a detached ListParticipantRecord
     */
    public ListParticipantRecord() {
        super(ListParticipant.LIST_PARTICIPANT);
    }

    /**
     * Create a detached, initialised ListParticipantRecord
     */
    public ListParticipantRecord(Long participantId, Long conferenceId, Timestamp dataUpdate, Timestamp dataCreate) {
        super(ListParticipant.LIST_PARTICIPANT);

        set(0, participantId);
        set(1, conferenceId);
        set(2, dataUpdate);
        set(3, dataCreate);
    }
}