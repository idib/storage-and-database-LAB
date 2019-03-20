/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.postgres;


import com.sadb.generated.source.postgres.tables.SrcPgsDiscipline;
import com.sadb.generated.source.postgres.tables.SrcPgsResults;
import com.sadb.generated.source.postgres.tables.SrcPgsSudent;
import com.sadb.generated.source.postgres.tables.SrcPgsTeacher;
import com.sadb.generated.source.postgres.tables.records.SrcPgsDisciplineRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsResultsRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsSudentRecord;
import com.sadb.generated.source.postgres.tables.records.SrcPgsTeacherRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<SrcPgsDisciplineRecord> SRC_PGS_DISCIPLINE_PKEY = UniqueKeys0.SRC_PGS_DISCIPLINE_PKEY;
    public static final UniqueKey<SrcPgsSudentRecord> SRC_PGS_SUDENT_PKEY = UniqueKeys0.SRC_PGS_SUDENT_PKEY;
    public static final UniqueKey<SrcPgsTeacherRecord> SRC_PGS_TEACHER_PKEY = UniqueKeys0.SRC_PGS_TEACHER_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<SrcPgsResultsRecord, SrcPgsSudentRecord> SRC_PGS_RESULTS__SRC_PGS_RESULTS_STUDENT_ID_FKEY = ForeignKeys0.SRC_PGS_RESULTS__SRC_PGS_RESULTS_STUDENT_ID_FKEY;
    public static final ForeignKey<SrcPgsResultsRecord, SrcPgsDisciplineRecord> SRC_PGS_RESULTS__SRC_PGS_RESULTS_DISCIPLINE_ID_FKEY = ForeignKeys0.SRC_PGS_RESULTS__SRC_PGS_RESULTS_DISCIPLINE_ID_FKEY;
    public static final ForeignKey<SrcPgsResultsRecord, SrcPgsTeacherRecord> SRC_PGS_RESULTS__SRC_PGS_RESULTS_TEACHER_ID_FKEY = ForeignKeys0.SRC_PGS_RESULTS__SRC_PGS_RESULTS_TEACHER_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<SrcPgsDisciplineRecord> SRC_PGS_DISCIPLINE_PKEY = Internal.createUniqueKey(SrcPgsDiscipline.SRC_PGS_DISCIPLINE, "src_pgs_discipline_pkey", SrcPgsDiscipline.SRC_PGS_DISCIPLINE.DISCIPLINE_ID);
        public static final UniqueKey<SrcPgsSudentRecord> SRC_PGS_SUDENT_PKEY = Internal.createUniqueKey(SrcPgsSudent.SRC_PGS_SUDENT, "src_pgs_sudent_pkey", SrcPgsSudent.SRC_PGS_SUDENT.ID);
        public static final UniqueKey<SrcPgsTeacherRecord> SRC_PGS_TEACHER_PKEY = Internal.createUniqueKey(SrcPgsTeacher.SRC_PGS_TEACHER, "src_pgs_teacher_pkey", SrcPgsTeacher.SRC_PGS_TEACHER.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<SrcPgsResultsRecord, SrcPgsSudentRecord> SRC_PGS_RESULTS__SRC_PGS_RESULTS_STUDENT_ID_FKEY = Internal.createForeignKey(com.sadb.generated.source.postgres.Keys.SRC_PGS_SUDENT_PKEY, SrcPgsResults.SRC_PGS_RESULTS, "src_pgs_results__src_pgs_results_student_id_fkey", SrcPgsResults.SRC_PGS_RESULTS.STUDENT_ID);
        public static final ForeignKey<SrcPgsResultsRecord, SrcPgsDisciplineRecord> SRC_PGS_RESULTS__SRC_PGS_RESULTS_DISCIPLINE_ID_FKEY = Internal.createForeignKey(com.sadb.generated.source.postgres.Keys.SRC_PGS_DISCIPLINE_PKEY, SrcPgsResults.SRC_PGS_RESULTS, "src_pgs_results__src_pgs_results_discipline_id_fkey", SrcPgsResults.SRC_PGS_RESULTS.DISCIPLINE_ID);
        public static final ForeignKey<SrcPgsResultsRecord, SrcPgsTeacherRecord> SRC_PGS_RESULTS__SRC_PGS_RESULTS_TEACHER_ID_FKEY = Internal.createForeignKey(com.sadb.generated.source.postgres.Keys.SRC_PGS_TEACHER_PKEY, SrcPgsResults.SRC_PGS_RESULTS, "src_pgs_results__src_pgs_results_teacher_id_fkey", SrcPgsResults.SRC_PGS_RESULTS.TEACHER_ID);
    }
}