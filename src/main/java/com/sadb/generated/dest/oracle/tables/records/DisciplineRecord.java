/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle.tables.records;


import com.sadb.generated.dest.oracle.tables.Discipline;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class DisciplineRecord extends UpdatableRecordImpl<DisciplineRecord> implements Record8<Long, String, BigDecimal, BigDecimal, BigDecimal, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = -36264865;

    /**
     * Setter for <code>SANDDB.DISCIPLINE.DISCIPLINE_ID</code>.
     */
    public void setDisciplineId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>SANDDB.DISCIPLINE.DISCIPLINE_ID</code>.
     */
    public Long getDisciplineId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>SANDDB.DISCIPLINE.DISCIPLINE_NAME</code>.
     */
    public void setDisciplineName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SANDDB.DISCIPLINE.DISCIPLINE_NAME</code>.
     */
    public String getDisciplineName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SANDDB.DISCIPLINE.LECTIONS_HOURS</code>.
     */
    public void setLectionsHours(BigDecimal value) {
        set(2, value);
    }

    /**
     * Getter for <code>SANDDB.DISCIPLINE.LECTIONS_HOURS</code>.
     */
    public BigDecimal getLectionsHours() {
        return (BigDecimal) get(2);
    }

    /**
     * Setter for <code>SANDDB.DISCIPLINE.PRACTICALS_HOURS</code>.
     */
    public void setPracticalsHours(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>SANDDB.DISCIPLINE.PRACTICALS_HOURS</code>.
     */
    public BigDecimal getPracticalsHours() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>SANDDB.DISCIPLINE.LABS_HOUES</code>.
     */
    public void setLabsHoues(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>SANDDB.DISCIPLINE.LABS_HOUES</code>.
     */
    public BigDecimal getLabsHoues() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>SANDDB.DISCIPLINE.EDUCATION_STANDART_TYPE</code>.
     */
    public void setEducationStandartType(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>SANDDB.DISCIPLINE.EDUCATION_STANDART_TYPE</code>.
     */
    public String getEducationStandartType() {
        return (String) get(5);
    }

    /**
     * Setter for <code>SANDDB.DISCIPLINE.CREAT_TIME</code>.
     */
    public void setCreatTime(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>SANDDB.DISCIPLINE.CREAT_TIME</code>.
     */
    public Timestamp getCreatTime() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>SANDDB.DISCIPLINE.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>SANDDB.DISCIPLINE.UPDATE_TIME</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, BigDecimal, BigDecimal, BigDecimal, String, Timestamp, Timestamp> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, BigDecimal, BigDecimal, BigDecimal, String, Timestamp, Timestamp> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Discipline.DISCIPLINE.DISCIPLINE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Discipline.DISCIPLINE.DISCIPLINE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field3() {
        return Discipline.DISCIPLINE.LECTIONS_HOURS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field4() {
        return Discipline.DISCIPLINE.PRACTICALS_HOURS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field5() {
        return Discipline.DISCIPLINE.LABS_HOUES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Discipline.DISCIPLINE.EDUCATION_STANDART_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return Discipline.DISCIPLINE.CREAT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return Discipline.DISCIPLINE.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getDisciplineId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getDisciplineName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component3() {
        return getLectionsHours();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component4() {
        return getPracticalsHours();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component5() {
        return getLabsHoues();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getEducationStandartType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component7() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getDisciplineId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDisciplineName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value3() {
        return getLectionsHours();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value4() {
        return getPracticalsHours();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value5() {
        return getLabsHoues();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getEducationStandartType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getCreatTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value1(Long value) {
        setDisciplineId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value2(String value) {
        setDisciplineName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value3(BigDecimal value) {
        setLectionsHours(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value4(BigDecimal value) {
        setPracticalsHours(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value5(BigDecimal value) {
        setLabsHoues(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value6(String value) {
        setEducationStandartType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value7(Timestamp value) {
        setCreatTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord value8(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineRecord values(Long value1, String value2, BigDecimal value3, BigDecimal value4, BigDecimal value5, String value6, Timestamp value7, Timestamp value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DisciplineRecord
     */
    public DisciplineRecord() {
        super(Discipline.DISCIPLINE);
    }

    /**
     * Create a detached, initialised DisciplineRecord
     */
    public DisciplineRecord(Long disciplineId, String disciplineName, BigDecimal lectionsHours, BigDecimal practicalsHours, BigDecimal labsHoues, String educationStandartType, Timestamp creatTime, Timestamp updateTime) {
        super(Discipline.DISCIPLINE);

        set(0, disciplineId);
        set(1, disciplineName);
        set(2, lectionsHours);
        set(3, practicalsHours);
        set(4, labsHoues);
        set(5, educationStandartType);
        set(6, creatTime);
        set(7, updateTime);
    }
}
