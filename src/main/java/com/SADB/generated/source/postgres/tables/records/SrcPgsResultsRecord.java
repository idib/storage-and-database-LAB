/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.postgres.tables.records;


import com.sadb.generated.source.postgres.tables.SrcPgsResults;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.OffsetDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class SrcPgsResultsRecord extends TableRecordImpl<SrcPgsResultsRecord> implements Record8<BigDecimal, BigDecimal, String, Double, Date, BigDecimal, OffsetDateTime, OffsetDateTime> {

    private static final long serialVersionUID = -389727893;

    /**
     * Setter for <code>public.src_pgs_results.student_id</code>.
     */
    public void setStudentId(BigDecimal value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.src_pgs_results.student_id</code>.
     */
    public BigDecimal getStudentId() {
        return (BigDecimal) get(0);
    }

    /**
     * Setter for <code>public.src_pgs_results.discipline_id</code>.
     */
    public void setDisciplineId(BigDecimal value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.src_pgs_results.discipline_id</code>.
     */
    public BigDecimal getDisciplineId() {
        return (BigDecimal) get(1);
    }

    /**
     * Setter for <code>public.src_pgs_results.control_form</code>.
     */
    public void setControlForm(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.src_pgs_results.control_form</code>.
     */
    public String getControlForm() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.src_pgs_results.result</code>.
     */
    public void setResult(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.src_pgs_results.result</code>.
     */
    public Double getResult() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>public.src_pgs_results.result_date</code>.
     */
    public void setResultDate(Date value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.src_pgs_results.result_date</code>.
     */
    public Date getResultDate() {
        return (Date) get(4);
    }

    /**
     * Setter for <code>public.src_pgs_results.teacher_id</code>.
     */
    public void setTeacherId(BigDecimal value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.src_pgs_results.teacher_id</code>.
     */
    public BigDecimal getTeacherId() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>public.src_pgs_results.created_at</code>.
     */
    public void setCreatedAt(OffsetDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.src_pgs_results.created_at</code>.
     */
    public OffsetDateTime getCreatedAt() {
        return (OffsetDateTime) get(6);
    }

    /**
     * Setter for <code>public.src_pgs_results.updated_at</code>.
     */
    public void setUpdatedAt(OffsetDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.src_pgs_results.updated_at</code>.
     */
    public OffsetDateTime getUpdatedAt() {
        return (OffsetDateTime) get(7);
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<BigDecimal, BigDecimal, String, Double, Date, BigDecimal, OffsetDateTime, OffsetDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<BigDecimal, BigDecimal, String, Double, Date, BigDecimal, OffsetDateTime, OffsetDateTime> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field1() {
        return SrcPgsResults.SRC_PGS_RESULTS.STUDENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field2() {
        return SrcPgsResults.SRC_PGS_RESULTS.DISCIPLINE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SrcPgsResults.SRC_PGS_RESULTS.CONTROL_FORM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field4() {
        return SrcPgsResults.SRC_PGS_RESULTS.RESULT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field5() {
        return SrcPgsResults.SRC_PGS_RESULTS.RESULT_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field6() {
        return SrcPgsResults.SRC_PGS_RESULTS.TEACHER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<OffsetDateTime> field7() {
        return SrcPgsResults.SRC_PGS_RESULTS.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<OffsetDateTime> field8() {
        return SrcPgsResults.SRC_PGS_RESULTS.UPDATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component1() {
        return getStudentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component2() {
        return getDisciplineId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getControlForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component4() {
        return getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component5() {
        return getResultDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component6() {
        return getTeacherId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime component7() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime component8() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value1() {
        return getStudentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value2() {
        return getDisciplineId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getControlForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value4() {
        return getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value5() {
        return getResultDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value6() {
        return getTeacherId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime value7() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime value8() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsResultsRecord value1(BigDecimal value) {
        setStudentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsResultsRecord value2(BigDecimal value) {
        setDisciplineId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsResultsRecord value3(String value) {
        setControlForm(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsResultsRecord value4(Double value) {
        setResult(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsResultsRecord value5(Date value) {
        setResultDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsResultsRecord value6(BigDecimal value) {
        setTeacherId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsResultsRecord value7(OffsetDateTime value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsResultsRecord value8(OffsetDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsResultsRecord values(BigDecimal value1, BigDecimal value2, String value3, Double value4, Date value5, BigDecimal value6, OffsetDateTime value7, OffsetDateTime value8) {
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
     * Create a detached SrcPgsResultsRecord
     */
    public SrcPgsResultsRecord() {
        super(SrcPgsResults.SRC_PGS_RESULTS);
    }

    /**
     * Create a detached, initialised SrcPgsResultsRecord
     */
    public SrcPgsResultsRecord(BigDecimal studentId, BigDecimal disciplineId, String controlForm, Double result, Date resultDate, BigDecimal teacherId, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        super(SrcPgsResults.SRC_PGS_RESULTS);

        set(0, studentId);
        set(1, disciplineId);
        set(2, controlForm);
        set(3, result);
        set(4, resultDate);
        set(5, teacherId);
        set(6, createdAt);
        set(7, updatedAt);
    }
}
