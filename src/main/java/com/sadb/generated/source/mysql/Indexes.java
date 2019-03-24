/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.source.mysql;


import com.sadb.generated.source.mysql.tables.Conference;
import com.sadb.generated.source.mysql.tables.ListParticipant;
import com.sadb.generated.source.mysql.tables.ListParticipantProject;
import com.sadb.generated.source.mysql.tables.Participant;
import com.sadb.generated.source.mysql.tables.Publications;
import com.sadb.generated.source.mysql.tables.ReaderSheet;
import com.sadb.generated.source.mysql.tables.ScientificProject;
import com.sadb.generated.source.mysql.tables.TypeEdition;
import com.sadb.generated.source.mysql.tables.TypePosition;
import com.sadb.generated.source.mysql.tables.TypePublication;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>conference</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index CONFERENCE_PRIMARY = Indexes0.CONFERENCE_PRIMARY;
    public static final Index LIST_PARTICIPANT_LIST_PARTICIPANT_FK0 = Indexes0.LIST_PARTICIPANT_LIST_PARTICIPANT_FK0;
    public static final Index LIST_PARTICIPANT_LIST_PARTICIPANT_FK1 = Indexes0.LIST_PARTICIPANT_LIST_PARTICIPANT_FK1;
    public static final Index LIST_PARTICIPANT_PROJECT_LIST_PARTICIPANT_PROJECT_FK0 = Indexes0.LIST_PARTICIPANT_PROJECT_LIST_PARTICIPANT_PROJECT_FK0;
    public static final Index LIST_PARTICIPANT_PROJECT_LIST_PARTICIPANT_PROJECT_FK1 = Indexes0.LIST_PARTICIPANT_PROJECT_LIST_PARTICIPANT_PROJECT_FK1;
    public static final Index PARTICIPANT_PARTICIPANT_FK0 = Indexes0.PARTICIPANT_PARTICIPANT_FK0;
    public static final Index PARTICIPANT_PRIMARY = Indexes0.PARTICIPANT_PRIMARY;
    public static final Index PUBLICATIONS_PRIMARY = Indexes0.PUBLICATIONS_PRIMARY;
    public static final Index PUBLICATIONS_PUBLICATIONS_FK0 = Indexes0.PUBLICATIONS_PUBLICATIONS_FK0;
    public static final Index PUBLICATIONS_PUBLICATIONS_FK1 = Indexes0.PUBLICATIONS_PUBLICATIONS_FK1;
    public static final Index PUBLICATIONS_PUBLICATIONS_FK2 = Indexes0.PUBLICATIONS_PUBLICATIONS_FK2;
    public static final Index READER_SHEET_PRIMARY = Indexes0.READER_SHEET_PRIMARY;
    public static final Index READER_SHEET_READER_SHEET_FK0 = Indexes0.READER_SHEET_READER_SHEET_FK0;
    public static final Index SCIENTIFIC_PROJECT_PRIMARY = Indexes0.SCIENTIFIC_PROJECT_PRIMARY;
    public static final Index TYPE_EDITION_PRIMARY = Indexes0.TYPE_EDITION_PRIMARY;
    public static final Index TYPE_POSITION_PRIMARY = Indexes0.TYPE_POSITION_PRIMARY;
    public static final Index TYPE_PUBLICATION_PRIMARY = Indexes0.TYPE_PUBLICATION_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index CONFERENCE_PRIMARY = Internal.createIndex("PRIMARY", Conference.CONFERENCE_, new OrderField[] { Conference.CONFERENCE_.ID }, true);
        public static Index LIST_PARTICIPANT_LIST_PARTICIPANT_FK0 = Internal.createIndex("List_participant_fk0", ListParticipant.LIST_PARTICIPANT, new OrderField[] { ListParticipant.LIST_PARTICIPANT.PARTICIPANT_ID }, false);
        public static Index LIST_PARTICIPANT_LIST_PARTICIPANT_FK1 = Internal.createIndex("List_participant_fk1", ListParticipant.LIST_PARTICIPANT, new OrderField[] { ListParticipant.LIST_PARTICIPANT.CONFERENCE_ID }, false);
        public static Index LIST_PARTICIPANT_PROJECT_LIST_PARTICIPANT_PROJECT_FK0 = Internal.createIndex("List_participant_project_fk0", ListParticipantProject.LIST_PARTICIPANT_PROJECT, new OrderField[] { ListParticipantProject.LIST_PARTICIPANT_PROJECT.PARTICIPANT_ID }, false);
        public static Index LIST_PARTICIPANT_PROJECT_LIST_PARTICIPANT_PROJECT_FK1 = Internal.createIndex("List_participant_project_fk1", ListParticipantProject.LIST_PARTICIPANT_PROJECT, new OrderField[] { ListParticipantProject.LIST_PARTICIPANT_PROJECT.PROJECT_ID }, false);
        public static Index PARTICIPANT_PARTICIPANT_FK0 = Internal.createIndex("Participant_fk0", Participant.PARTICIPANT, new OrderField[] { Participant.PARTICIPANT.POSITION_ID }, false);
        public static Index PARTICIPANT_PRIMARY = Internal.createIndex("PRIMARY", Participant.PARTICIPANT, new OrderField[] { Participant.PARTICIPANT.ID }, true);
        public static Index PUBLICATIONS_PRIMARY = Internal.createIndex("PRIMARY", Publications.PUBLICATIONS, new OrderField[] { Publications.PUBLICATIONS.ID }, true);
        public static Index PUBLICATIONS_PUBLICATIONS_FK0 = Internal.createIndex("Publications_fk0", Publications.PUBLICATIONS, new OrderField[] { Publications.PUBLICATIONS.EDITION_ID }, false);
        public static Index PUBLICATIONS_PUBLICATIONS_FK1 = Internal.createIndex("Publications_fk1", Publications.PUBLICATIONS, new OrderField[] { Publications.PUBLICATIONS.PARTICIPANT_ID }, false);
        public static Index PUBLICATIONS_PUBLICATIONS_FK2 = Internal.createIndex("Publications_fk2", Publications.PUBLICATIONS, new OrderField[] { Publications.PUBLICATIONS.ID_TYPE_PUBLICATION }, false);
        public static Index READER_SHEET_PRIMARY = Internal.createIndex("PRIMARY", ReaderSheet.READER_SHEET, new OrderField[] { ReaderSheet.READER_SHEET.ID }, true);
        public static Index READER_SHEET_READER_SHEET_FK0 = Internal.createIndex("Reader_sheet_fk0", ReaderSheet.READER_SHEET, new OrderField[] { ReaderSheet.READER_SHEET.PARTICIPANT_ID }, false);
        public static Index SCIENTIFIC_PROJECT_PRIMARY = Internal.createIndex("PRIMARY", ScientificProject.SCIENTIFIC_PROJECT, new OrderField[] { ScientificProject.SCIENTIFIC_PROJECT.ID }, true);
        public static Index TYPE_EDITION_PRIMARY = Internal.createIndex("PRIMARY", TypeEdition.TYPE_EDITION, new OrderField[] { TypeEdition.TYPE_EDITION.ID }, true);
        public static Index TYPE_POSITION_PRIMARY = Internal.createIndex("PRIMARY", TypePosition.TYPE_POSITION, new OrderField[] { TypePosition.TYPE_POSITION.ID }, true);
        public static Index TYPE_PUBLICATION_PRIMARY = Internal.createIndex("PRIMARY", TypePublication.TYPE_PUBLICATION, new OrderField[] { TypePublication.TYPE_PUBLICATION.ID }, true);
    }
}
