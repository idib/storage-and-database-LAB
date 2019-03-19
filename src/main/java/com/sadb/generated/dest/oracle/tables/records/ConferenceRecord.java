/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables.records;


import com.sadb.generated.dest.oracle.tables.Conference;

import java.sql.Date;
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
public class ConferenceRecord extends UpdatableRecordImpl<ConferenceRecord> implements Record6<Long, String, String, Date, Timestamp, Timestamp> {

    private static final long serialVersionUID = -1620447064;

    /**
     * Setter for <code>SANDDB.CONFERENCE.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>SANDDB.CONFERENCE.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>SANDDB.CONFERENCE.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SANDDB.CONFERENCE.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SANDDB.CONFERENCE.VENUE</code>.
     */
    public void setVenue(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>SANDDB.CONFERENCE.VENUE</code>.
     */
    public String getVenue() {
        return (String) get(2);
    }

    /**
     * Setter for <code>SANDDB.CONFERENCE.DATE_CONFERENCE</code>.
     */
    public void setDateConference(Date value) {
        set(3, value);
    }

    /**
     * Getter for <code>SANDDB.CONFERENCE.DATE_CONFERENCE</code>.
     */
    public Date getDateConference() {
        return (Date) get(3);
    }

    /**
     * Setter for <code>SANDDB.CONFERENCE.DATA_UPDATE</code>.
     */
    public void setDataUpdate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>SANDDB.CONFERENCE.DATA_UPDATE</code>.
     */
    public Timestamp getDataUpdate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>SANDDB.CONFERENCE.DATA_CREATE</code>.
     */
    public void setDataCreate(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>SANDDB.CONFERENCE.DATA_CREATE</code>.
     */
    public Timestamp getDataCreate() {
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
    public Row6<Long, String, String, Date, Timestamp, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, String, Date, Timestamp, Timestamp> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Conference.CONFERENCE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Conference.CONFERENCE.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Conference.CONFERENCE.VENUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field4() {
        return Conference.CONFERENCE.DATE_CONFERENCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Conference.CONFERENCE.DATA_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Conference.CONFERENCE.DATA_CREATE;
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
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getVenue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component4() {
        return getDateConference();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getDataUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getDataCreate();
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
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getVenue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value4() {
        return getDateConference();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getDataUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getDataCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConferenceRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConferenceRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConferenceRecord value3(String value) {
        setVenue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConferenceRecord value4(Date value) {
        setDateConference(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConferenceRecord value5(Timestamp value) {
        setDataUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConferenceRecord value6(Timestamp value) {
        setDataCreate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConferenceRecord values(Long value1, String value2, String value3, Date value4, Timestamp value5, Timestamp value6) {
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
     * Create a detached ConferenceRecord
     */
    public ConferenceRecord() {
        super(Conference.CONFERENCE);
    }

    /**
     * Create a detached, initialised ConferenceRecord
     */
    public ConferenceRecord(Long id, String name, String venue, Date dateConference, Timestamp dataUpdate, Timestamp dataCreate) {
        super(Conference.CONFERENCE);

        set(0, id);
        set(1, name);
        set(2, venue);
        set(3, dateConference);
        set(4, dataUpdate);
        set(5, dataCreate);
    }
}
