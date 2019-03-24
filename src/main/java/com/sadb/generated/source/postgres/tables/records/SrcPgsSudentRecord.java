/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.postgres.tables.records;


import com.sadb.generated.source.postgres.tables.SrcPgsSudent;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class SrcPgsSudentRecord extends UpdatableRecordImpl<SrcPgsSudentRecord> implements Record9<BigDecimal, String, String, String, String, String, BigDecimal, OffsetDateTime, OffsetDateTime> {

    private static final long serialVersionUID = -841965042;

    /**
     * Setter for <code>public.src_pgs_sudent.id</code>.
     */
    public void setId(BigDecimal value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.src_pgs_sudent.id</code>.
     */
    public BigDecimal getId() {
        return (BigDecimal) get(0);
    }

    /**
     * Setter for <code>public.src_pgs_sudent.fio</code>.
     */
    public void setFio(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.src_pgs_sudent.fio</code>.
     */
    public String getFio() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.src_pgs_sudent.university</code>.
     */
    public void setUniversity(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.src_pgs_sudent.university</code>.
     */
    public String getUniversity() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.src_pgs_sudent.education_form</code>.
     */
    public void setEducationForm(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.src_pgs_sudent.education_form</code>.
     */
    public String getEducationForm() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.src_pgs_sudent.education_place</code>.
     */
    public void setEducationPlace(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.src_pgs_sudent.education_place</code>.
     */
    public String getEducationPlace() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.src_pgs_sudent.speciality</code>.
     */
    public void setSpeciality(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.src_pgs_sudent.speciality</code>.
     */
    public String getSpeciality() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.src_pgs_sudent.semester</code>.
     */
    public void setSemester(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.src_pgs_sudent.semester</code>.
     */
    public BigDecimal getSemester() {
        return (BigDecimal) get(6);
    }

    /**
     * Setter for <code>public.src_pgs_sudent.created_at</code>.
     */
    public void setCreatedAt(OffsetDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.src_pgs_sudent.created_at</code>.
     */
    public OffsetDateTime getCreatedAt() {
        return (OffsetDateTime) get(7);
    }

    /**
     * Setter for <code>public.src_pgs_sudent.updated_at</code>.
     */
    public void setUpdatedAt(OffsetDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.src_pgs_sudent.updated_at</code>.
     */
    public OffsetDateTime getUpdatedAt() {
        return (OffsetDateTime) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<BigDecimal> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<BigDecimal, String, String, String, String, String, BigDecimal, OffsetDateTime, OffsetDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<BigDecimal, String, String, String, String, String, BigDecimal, OffsetDateTime, OffsetDateTime> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field1() {
        return SrcPgsSudent.SRC_PGS_SUDENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SrcPgsSudent.SRC_PGS_SUDENT.FIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SrcPgsSudent.SRC_PGS_SUDENT.UNIVERSITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SrcPgsSudent.SRC_PGS_SUDENT.EDUCATION_FORM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SrcPgsSudent.SRC_PGS_SUDENT.EDUCATION_PLACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return SrcPgsSudent.SRC_PGS_SUDENT.SPECIALITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field7() {
        return SrcPgsSudent.SRC_PGS_SUDENT.SEMESTER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<OffsetDateTime> field8() {
        return SrcPgsSudent.SRC_PGS_SUDENT.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<OffsetDateTime> field9() {
        return SrcPgsSudent.SRC_PGS_SUDENT.UPDATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getFio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getUniversity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getEducationForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getEducationPlace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getSpeciality();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component7() {
        return getSemester();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime component8() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime component9() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getFio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getUniversity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEducationForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getEducationPlace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getSpeciality();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value7() {
        return getSemester();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime value8() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime value9() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord value1(BigDecimal value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord value2(String value) {
        setFio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord value3(String value) {
        setUniversity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord value4(String value) {
        setEducationForm(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord value5(String value) {
        setEducationPlace(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord value6(String value) {
        setSpeciality(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord value7(BigDecimal value) {
        setSemester(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord value8(OffsetDateTime value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord value9(OffsetDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SrcPgsSudentRecord values(BigDecimal value1, String value2, String value3, String value4, String value5, String value6, BigDecimal value7, OffsetDateTime value8, OffsetDateTime value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SrcPgsSudentRecord
     */
    public SrcPgsSudentRecord() {
        super(SrcPgsSudent.SRC_PGS_SUDENT);
    }

    /**
     * Create a detached, initialised SrcPgsSudentRecord
     */
    public SrcPgsSudentRecord(BigDecimal id, String fio, String university, String educationForm, String educationPlace, String speciality, BigDecimal semester, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        super(SrcPgsSudent.SRC_PGS_SUDENT);

        set(0, id);
        set(1, fio);
        set(2, university);
        set(3, educationForm);
        set(4, educationPlace);
        set(5, speciality);
        set(6, semester);
        set(7, createdAt);
        set(8, updatedAt);
    }
}
