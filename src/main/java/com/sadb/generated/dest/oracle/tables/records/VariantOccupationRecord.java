/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables.records;


import com.sadb.generated.dest.oracle.tables.VariantOccupation;

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
public class VariantOccupationRecord extends UpdatableRecordImpl<VariantOccupationRecord> implements Record4<Long, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = -647696717;

    /**
     * Setter for <code>SANDDB.VARIANT_OCCUPATION.VARIANT_OCCUPATION_ID</code>.
     */
    public void setVariantOccupationId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>SANDDB.VARIANT_OCCUPATION.VARIANT_OCCUPATION_ID</code>.
     */
    public Long getVariantOccupationId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>SANDDB.VARIANT_OCCUPATION.VAR_OCC_TYPE</code>.
     */
    public void setVarOccType(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SANDDB.VARIANT_OCCUPATION.VAR_OCC_TYPE</code>.
     */
    public String getVarOccType() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SANDDB.VARIANT_OCCUPATION.CREAT_TIME</code>.
     */
    public void setCreatTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>SANDDB.VARIANT_OCCUPATION.CREAT_TIME</code>.
     */
    public Timestamp getCreatTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>SANDDB.VARIANT_OCCUPATION.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>SANDDB.VARIANT_OCCUPATION.UPDATE_TIME</code>.
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
        return VariantOccupation.VARIANT_OCCUPATION.VARIANT_OCCUPATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return VariantOccupation.VARIANT_OCCUPATION.VAR_OCC_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return VariantOccupation.VARIANT_OCCUPATION.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return VariantOccupation.VARIANT_OCCUPATION.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getVariantOccupationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getVarOccType();
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
        return getVariantOccupationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getVarOccType();
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
    public VariantOccupationRecord value1(Long value) {
        setVariantOccupationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VariantOccupationRecord value2(String value) {
        setVarOccType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VariantOccupationRecord value3(Timestamp value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VariantOccupationRecord value4(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VariantOccupationRecord values(Long value1, String value2, Timestamp value3, Timestamp value4) {
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
     * Create a detached VariantOccupationRecord
     */
    public VariantOccupationRecord() {
        super(VariantOccupation.VARIANT_OCCUPATION);
    }

    /**
     * Create a detached, initialised VariantOccupationRecord
     */
    public VariantOccupationRecord(Long variantOccupationId, String varOccType, Timestamp creatTime, Timestamp updateTime) {
        super(VariantOccupation.VARIANT_OCCUPATION);

        set(0, variantOccupationId);
        set(1, varOccType);
        set(2, creatTime);
        set(3, updateTime);
    }
}
