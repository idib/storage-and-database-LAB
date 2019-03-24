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
import com.sadb.generated.source.mysql.tables.records.ConferenceRecord;
import com.sadb.generated.source.mysql.tables.records.ListParticipantProjectRecord;
import com.sadb.generated.source.mysql.tables.records.ListParticipantRecord;
import com.sadb.generated.source.mysql.tables.records.ParticipantRecord;
import com.sadb.generated.source.mysql.tables.records.PublicationsRecord;
import com.sadb.generated.source.mysql.tables.records.ReaderSheetRecord;
import com.sadb.generated.source.mysql.tables.records.ScientificProjectRecord;
import com.sadb.generated.source.mysql.tables.records.TypeEditionRecord;
import com.sadb.generated.source.mysql.tables.records.TypePositionRecord;
import com.sadb.generated.source.mysql.tables.records.TypePublicationRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>conference</code> schema.
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

    public static final Identity<ConferenceRecord, Integer> IDENTITY_CONFERENCE_ = Identities0.IDENTITY_CONFERENCE_;
    public static final Identity<ParticipantRecord, Integer> IDENTITY_PARTICIPANT = Identities0.IDENTITY_PARTICIPANT;
    public static final Identity<PublicationsRecord, Integer> IDENTITY_PUBLICATIONS = Identities0.IDENTITY_PUBLICATIONS;
    public static final Identity<ReaderSheetRecord, Integer> IDENTITY_READER_SHEET = Identities0.IDENTITY_READER_SHEET;
    public static final Identity<ScientificProjectRecord, Integer> IDENTITY_SCIENTIFIC_PROJECT = Identities0.IDENTITY_SCIENTIFIC_PROJECT;
    public static final Identity<TypeEditionRecord, Integer> IDENTITY_TYPE_EDITION = Identities0.IDENTITY_TYPE_EDITION;
    public static final Identity<TypePositionRecord, Integer> IDENTITY_TYPE_POSITION = Identities0.IDENTITY_TYPE_POSITION;
    public static final Identity<TypePublicationRecord, Integer> IDENTITY_TYPE_PUBLICATION = Identities0.IDENTITY_TYPE_PUBLICATION;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ConferenceRecord> KEY_CONFERENCE_PRIMARY = UniqueKeys0.KEY_CONFERENCE_PRIMARY;
    public static final UniqueKey<ParticipantRecord> KEY_PARTICIPANT_PRIMARY = UniqueKeys0.KEY_PARTICIPANT_PRIMARY;
    public static final UniqueKey<PublicationsRecord> KEY_PUBLICATIONS_PRIMARY = UniqueKeys0.KEY_PUBLICATIONS_PRIMARY;
    public static final UniqueKey<ReaderSheetRecord> KEY_READER_SHEET_PRIMARY = UniqueKeys0.KEY_READER_SHEET_PRIMARY;
    public static final UniqueKey<ScientificProjectRecord> KEY_SCIENTIFIC_PROJECT_PRIMARY = UniqueKeys0.KEY_SCIENTIFIC_PROJECT_PRIMARY;
    public static final UniqueKey<TypeEditionRecord> KEY_TYPE_EDITION_PRIMARY = UniqueKeys0.KEY_TYPE_EDITION_PRIMARY;
    public static final UniqueKey<TypePositionRecord> KEY_TYPE_POSITION_PRIMARY = UniqueKeys0.KEY_TYPE_POSITION_PRIMARY;
    public static final UniqueKey<TypePublicationRecord> KEY_TYPE_PUBLICATION_PRIMARY = UniqueKeys0.KEY_TYPE_PUBLICATION_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ListParticipantRecord, ParticipantRecord> LIST_PARTICIPANT_FK0 = ForeignKeys0.LIST_PARTICIPANT_FK0;
    public static final ForeignKey<ListParticipantRecord, ConferenceRecord> LIST_PARTICIPANT_FK1 = ForeignKeys0.LIST_PARTICIPANT_FK1;
    public static final ForeignKey<ListParticipantProjectRecord, ParticipantRecord> LIST_PARTICIPANT_PROJECT_FK0 = ForeignKeys0.LIST_PARTICIPANT_PROJECT_FK0;
    public static final ForeignKey<ListParticipantProjectRecord, ScientificProjectRecord> LIST_PARTICIPANT_PROJECT_FK1 = ForeignKeys0.LIST_PARTICIPANT_PROJECT_FK1;
    public static final ForeignKey<ParticipantRecord, TypePositionRecord> PARTICIPANT_FK0 = ForeignKeys0.PARTICIPANT_FK0;
    public static final ForeignKey<PublicationsRecord, TypeEditionRecord> PUBLICATIONS_FK0 = ForeignKeys0.PUBLICATIONS_FK0;
    public static final ForeignKey<PublicationsRecord, ParticipantRecord> PUBLICATIONS_FK1 = ForeignKeys0.PUBLICATIONS_FK1;
    public static final ForeignKey<PublicationsRecord, TypePublicationRecord> PUBLICATIONS_FK2 = ForeignKeys0.PUBLICATIONS_FK2;
    public static final ForeignKey<ReaderSheetRecord, ParticipantRecord> READER_SHEET_FK0 = ForeignKeys0.READER_SHEET_FK0;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ConferenceRecord, Integer> IDENTITY_CONFERENCE_ = Internal.createIdentity(Conference.CONFERENCE_, Conference.CONFERENCE_.ID);
        public static Identity<ParticipantRecord, Integer> IDENTITY_PARTICIPANT = Internal.createIdentity(Participant.PARTICIPANT, Participant.PARTICIPANT.ID);
        public static Identity<PublicationsRecord, Integer> IDENTITY_PUBLICATIONS = Internal.createIdentity(Publications.PUBLICATIONS, Publications.PUBLICATIONS.ID);
        public static Identity<ReaderSheetRecord, Integer> IDENTITY_READER_SHEET = Internal.createIdentity(ReaderSheet.READER_SHEET, ReaderSheet.READER_SHEET.ID);
        public static Identity<ScientificProjectRecord, Integer> IDENTITY_SCIENTIFIC_PROJECT = Internal.createIdentity(ScientificProject.SCIENTIFIC_PROJECT, ScientificProject.SCIENTIFIC_PROJECT.ID);
        public static Identity<TypeEditionRecord, Integer> IDENTITY_TYPE_EDITION = Internal.createIdentity(TypeEdition.TYPE_EDITION, TypeEdition.TYPE_EDITION.ID);
        public static Identity<TypePositionRecord, Integer> IDENTITY_TYPE_POSITION = Internal.createIdentity(TypePosition.TYPE_POSITION, TypePosition.TYPE_POSITION.ID);
        public static Identity<TypePublicationRecord, Integer> IDENTITY_TYPE_PUBLICATION = Internal.createIdentity(TypePublication.TYPE_PUBLICATION, TypePublication.TYPE_PUBLICATION.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ConferenceRecord> KEY_CONFERENCE_PRIMARY = Internal.createUniqueKey(Conference.CONFERENCE_, "KEY_Conference_PRIMARY", Conference.CONFERENCE_.ID);
        public static final UniqueKey<ParticipantRecord> KEY_PARTICIPANT_PRIMARY = Internal.createUniqueKey(Participant.PARTICIPANT, "KEY_Participant_PRIMARY", Participant.PARTICIPANT.ID);
        public static final UniqueKey<PublicationsRecord> KEY_PUBLICATIONS_PRIMARY = Internal.createUniqueKey(Publications.PUBLICATIONS, "KEY_Publications_PRIMARY", Publications.PUBLICATIONS.ID);
        public static final UniqueKey<ReaderSheetRecord> KEY_READER_SHEET_PRIMARY = Internal.createUniqueKey(ReaderSheet.READER_SHEET, "KEY_Reader_sheet_PRIMARY", ReaderSheet.READER_SHEET.ID);
        public static final UniqueKey<ScientificProjectRecord> KEY_SCIENTIFIC_PROJECT_PRIMARY = Internal.createUniqueKey(ScientificProject.SCIENTIFIC_PROJECT, "KEY_Scientific_project_PRIMARY", ScientificProject.SCIENTIFIC_PROJECT.ID);
        public static final UniqueKey<TypeEditionRecord> KEY_TYPE_EDITION_PRIMARY = Internal.createUniqueKey(TypeEdition.TYPE_EDITION, "KEY_Type_edition_PRIMARY", TypeEdition.TYPE_EDITION.ID);
        public static final UniqueKey<TypePositionRecord> KEY_TYPE_POSITION_PRIMARY = Internal.createUniqueKey(TypePosition.TYPE_POSITION, "KEY_Type_position_PRIMARY", TypePosition.TYPE_POSITION.ID);
        public static final UniqueKey<TypePublicationRecord> KEY_TYPE_PUBLICATION_PRIMARY = Internal.createUniqueKey(TypePublication.TYPE_PUBLICATION, "KEY_Type_publication_PRIMARY", TypePublication.TYPE_PUBLICATION.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ListParticipantRecord, ParticipantRecord> LIST_PARTICIPANT_FK0 = Internal.createForeignKey(com.sadb.generated.source.mysql.Keys.KEY_PARTICIPANT_PRIMARY, ListParticipant.LIST_PARTICIPANT, "List_participant_fk0", ListParticipant.LIST_PARTICIPANT.PARTICIPANT_ID);
        public static final ForeignKey<ListParticipantRecord, ConferenceRecord> LIST_PARTICIPANT_FK1 = Internal.createForeignKey(com.sadb.generated.source.mysql.Keys.KEY_CONFERENCE_PRIMARY, ListParticipant.LIST_PARTICIPANT, "List_participant_fk1", ListParticipant.LIST_PARTICIPANT.CONFERENCE_ID);
        public static final ForeignKey<ListParticipantProjectRecord, ParticipantRecord> LIST_PARTICIPANT_PROJECT_FK0 = Internal.createForeignKey(com.sadb.generated.source.mysql.Keys.KEY_PARTICIPANT_PRIMARY, ListParticipantProject.LIST_PARTICIPANT_PROJECT, "List_participant_project_fk0", ListParticipantProject.LIST_PARTICIPANT_PROJECT.PARTICIPANT_ID);
        public static final ForeignKey<ListParticipantProjectRecord, ScientificProjectRecord> LIST_PARTICIPANT_PROJECT_FK1 = Internal.createForeignKey(com.sadb.generated.source.mysql.Keys.KEY_SCIENTIFIC_PROJECT_PRIMARY, ListParticipantProject.LIST_PARTICIPANT_PROJECT, "List_participant_project_fk1", ListParticipantProject.LIST_PARTICIPANT_PROJECT.PROJECT_ID);
        public static final ForeignKey<ParticipantRecord, TypePositionRecord> PARTICIPANT_FK0 = Internal.createForeignKey(com.sadb.generated.source.mysql.Keys.KEY_TYPE_POSITION_PRIMARY, Participant.PARTICIPANT, "Participant_fk0", Participant.PARTICIPANT.POSITION_ID);
        public static final ForeignKey<PublicationsRecord, TypeEditionRecord> PUBLICATIONS_FK0 = Internal.createForeignKey(com.sadb.generated.source.mysql.Keys.KEY_TYPE_EDITION_PRIMARY, Publications.PUBLICATIONS, "Publications_fk0", Publications.PUBLICATIONS.EDITION_ID);
        public static final ForeignKey<PublicationsRecord, ParticipantRecord> PUBLICATIONS_FK1 = Internal.createForeignKey(com.sadb.generated.source.mysql.Keys.KEY_PARTICIPANT_PRIMARY, Publications.PUBLICATIONS, "Publications_fk1", Publications.PUBLICATIONS.PARTICIPANT_ID);
        public static final ForeignKey<PublicationsRecord, TypePublicationRecord> PUBLICATIONS_FK2 = Internal.createForeignKey(com.sadb.generated.source.mysql.Keys.KEY_TYPE_PUBLICATION_PRIMARY, Publications.PUBLICATIONS, "Publications_fk2", Publications.PUBLICATIONS.ID_TYPE_PUBLICATION);
        public static final ForeignKey<ReaderSheetRecord, ParticipantRecord> READER_SHEET_FK0 = Internal.createForeignKey(com.sadb.generated.source.mysql.Keys.KEY_PARTICIPANT_PRIMARY, ReaderSheet.READER_SHEET, "Reader_sheet_fk0", ReaderSheet.READER_SHEET.PARTICIPANT_ID);
    }
}
