package com.sadb.transformation.mysql;

import java.util.*;

import com.sadb.generated.dest.oracle.tables.*;
import com.sadb.generated.dest.oracle.tables.records.*;
import com.sadb.generated.source.mysql.tables.records.ConferenceRecord;
import com.sadb.generated.source.mysql.tables.records.ListParticipantRecord;
import com.sadb.generated.source.mysql.tables.records.ParticipantRecord;
import com.sadb.generated.source.mysql.tables.records.TypePositionRecord;


import com.sadb.transformation.ConnectionManager;
import org.jooq.*;
import org.jooq.Statement;
import org.jooq.impl.DSL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.sadb.generated.dest.oracle.Tables.*;

import static com.sadb.generated.source.mysql.Tables.CONFERENCE_;
import static com.sadb.generated.source.mysql.Tables.TYPE_POSITION;
import static com.sadb.generated.source.mysql.Tables.PARTICIPANT;
import static com.sadb.generated.source.mysql.Tables.LIST_PARTICIPANT;
import static com.sadb.generated.source.mysql.Tables.SCIENTIFIC_PROJECT;
import static com.sadb.generated.source.mysql.Tables.LIST_PARTICIPANT_PROJECT;
import static com.sadb.generated.source.mysql.Tables.READER_SHEET;
import static com.sadb.generated.source.mysql.Tables.TYPE_PUBLICATION;
import static com.sadb.generated.source.mysql.Tables.TYPE_EDITION;
import static com.sadb.generated.source.mysql.Tables.PUBLICATIONS;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class MysqlMigrationService {
	private static final String URL = "jdbc:mysql://conference.cakqhkplapqx.eu-central-1.rds.amazonaws.com:3306/conference";
	private static final String USER = "db_itmo";
	private static final String PASSWORD = "qwerty14";
//	private static final String URL = System.getenv("aws_mysql_url");
//	private static final String USER = System.getenv("aws_mysql_user");
//	private static final String PASSWORD = System.getenv("aws_mysql_password");

		private static final Integer MYSQL_DB_ID = 3;

	@Scheduled(fixedDelayString = "#{ 120 * 1000}", initialDelayString = "#30*1000")
	public void process() throws ClassNotFoundException, SQLException {

		Timestamp syncStartTime = new Timestamp(new Date().getTime());

		List<TableRecord<?>> toInsert = new ArrayList<>();
		List<UpdatableRecord<?>> toUpdate = new ArrayList<>();

		// Connect to Mysql
		Connection connectionMysql = getSourceMysqlConnection();

		// Connect to Oracle
		Connection connectionOracle = ConnectionManager.getDestDBConnection();

		// Create context
		DSLContext contextMysql = DSL.using(connectionMysql, SQLDialect.MYSQL);
		DSLContext contextOracle = DSL.using(connectionOracle, SQLDialect.ORACLE);

		// Get last sync time

		Result<SyncLogRecord> logRecords = contextOracle
				.select()
				.from(SYNC_LOG)
				.where(SYNC_LOG.DB_TYPE.eq(BigInteger.valueOf(MYSQL_DB_ID )))
				.orderBy(SYNC_LOG.TIMESTAMP.asc())
				.fetch().into(SYNC_LOG);

		Timestamp lastMysqlSync = logRecords.get(0).getTimestamp();


		// PROCESSING

		// CONFERENCE CONFERENCE CONFERENCE CONFERENCE CONFERENCE
		Result<ConferenceRecord> mysqlConference =
				contextMysql.select().from(CONFERENCE_).where(CONFERENCE_.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(CONFERENCE_);

		Result<com.sadb.generated.dest.oracle.tables.records.ConferenceRecord> oraclConference =
				contextOracle.select().from(CONFERENCE).fetch().into(CONFERENCE);

		processConference(
				mysqlConference,
				oraclConference,
				toInsert,
				toUpdate);

		//TYPE_POSITION TYPE_POSITION TYPE_POSITION
		Result<TypePositionRecord> mysqlTypePosition =
				contextMysql.select().from(TYPE_POSITION).where(TYPE_POSITION.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(TYPE_POSITION);
		Result<com.sadb.generated.dest.oracle.tables.records.TypePositionRecord> typePosition =
				contextOracle.select().from(TypePosition.TYPE_POSITION).fetch().into(TypePosition.TYPE_POSITION);


		processTypePosition(
				mysqlTypePosition,
				typePosition,
				toInsert,
				toUpdate);

		// PARTICIPANT PARTICIPANT PARTICIPANT
		Result<ParticipantRecord> mysqlParticipant =
				contextMysql.select().from(PARTICIPANT).where(PARTICIPANT.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(PARTICIPANT);
		Result<StudentRecord> oracleStudents =
				contextOracle.select().from(Student.STUDENT).fetch().into(Student.STUDENT);
		Result<com.sadb.generated.dest.oracle.tables.records.TypePositionRecord> typePositionForms =
				contextOracle.select().from(TypePosition.TYPE_POSITION).fetch().into(TypePosition.TYPE_POSITION);

		processParticipant(
				mysqlParticipant,
				oracleStudents,
				typePositionForms,
				toInsert,
				toUpdate);

		//LIST_PARTICIPATNT LIST_PARTICIPATNT  LIST_PARTICIPATNT

		Result<ListParticipantRecord> mysqlListParticipant =
				contextMysql.select().from(LIST_PARTICIPANT).where(LIST_PARTICIPANT.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(LIST_PARTICIPANT);
		Result<com.sadb.generated.dest.oracle.tables.records.ListParticipantRecord> oraclelListParticipant =
				contextOracle.select().from(ListParticipant.LIST_PARTICIPANT).fetch().into(ListParticipant.LIST_PARTICIPANT);
		Result<StudentRecord> oracleStudentsForms=
				contextOracle.select().from(Student.STUDENT).fetch().into(Student.STUDENT);
		processListParticipant(
				mysqlListParticipant,
				oraclelListParticipant,
				oracleStudents,
				oraclConference,
				toInsert,
				toUpdate);

		//SCIENTIFIC PROJECT SCIENTIFIC PROJECT  SCIENTIFIC PROJECT
		Result<com.sadb.generated.source.mysql.tables.records.ScientificProjectRecord> mysqlScientificProject =
				contextMysql.select().from(SCIENTIFIC_PROJECT).where(SCIENTIFIC_PROJECT.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(SCIENTIFIC_PROJECT);

		Result<com.sadb.generated.dest.oracle.tables.records.ScientificProjectRecord> oracleScientificProject =
				contextOracle.select().from(ScientificProject.SCIENTIFIC_PROJECT).fetch().into(ScientificProject.SCIENTIFIC_PROJECT);

		processScientificProject(
				mysqlScientificProject,
				oracleScientificProject,
				toInsert,
				toUpdate);

		//LIST_PARTICIPATION_PROJECT
		Result<com.sadb.generated.source.mysql.tables.records.ListParticipantProjectRecord> mysqlListParticipantProject =
				contextMysql.select().from(LIST_PARTICIPANT_PROJECT).where(LIST_PARTICIPANT_PROJECT.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(LIST_PARTICIPANT_PROJECT);

		Result<com.sadb.generated.dest.oracle.tables.records.ListParticipantProjectRecord> oraclelListParticipantProject =
				contextOracle.select().from(ListParticipantProject.LIST_PARTICIPANT_PROJECT).fetch().into(ListParticipantProject.LIST_PARTICIPANT_PROJECT);

		processListParticipantProject(
				mysqlListParticipantProject,
				oraclelListParticipantProject,
				oracleStudents,
				oracleScientificProject,
				toInsert,
				toUpdate);

		//READER_SHEET
		Result<com.sadb.generated.source.mysql.tables.records.ReaderSheetRecord> mysqlReaderSheet =
				contextMysql.select().from(READER_SHEET).where(READER_SHEET.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(READER_SHEET);
		//
		Result<com.sadb.generated.dest.oracle.tables.records.ReaderSheetRecord> oraclelReaderSheet =
				contextOracle.select().from(ReaderSheet.READER_SHEET).fetch().into(ReaderSheet.READER_SHEET);

		processReaderSheet(
				mysqlReaderSheet,
				oraclelReaderSheet,
				oracleStudents,
				toInsert,
				toUpdate);

		// TYPE_PUBLICATION TYPE_PUBLICATION TYPE_PUBLICATION
		Result<com.sadb.generated.source.mysql.tables.records.TypePublicationRecord> mysqlTypePublication =
				contextMysql.select().from(TYPE_PUBLICATION).where(TYPE_PUBLICATION.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(TYPE_PUBLICATION);

		Result<com.sadb.generated.dest.oracle.tables.records.TypePublicationRecord> oracleTypePublication =
				contextOracle.select().from(TypePublication.TYPE_PUBLICATION).fetch().into(TypePublication.TYPE_PUBLICATION);

		processTypePublication(
				mysqlTypePublication,
				oracleTypePublication,
				toInsert,
				toUpdate);

		// TYPE_EDITION TYPE_EDITION TYPE_EDITION
		Result<com.sadb.generated.source.mysql.tables.records.TypeEditionRecord> mysqlTypeEdition =
				contextMysql.select().from(TYPE_EDITION).where(TYPE_EDITION.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(TYPE_EDITION);

		Result<com.sadb.generated.dest.oracle.tables.records.TypeEditionRecord> oracleTypeEdition =
				contextOracle.select().from(TypeEdition.TYPE_EDITION).fetch().into(TypeEdition.TYPE_EDITION);

		processTypeEdition(
				mysqlTypeEdition,
				oracleTypeEdition,
				toInsert,
				toUpdate);

		//PUBLICATION PUBLICATION PUBLICATION
		Result<com.sadb.generated.source.mysql.tables.records.PublicationsRecord> mysqlPublications =
				contextMysql.select().from(PUBLICATIONS).where(PUBLICATIONS.DATA_UPDATE.ge(Timestamp.from(lastMysqlSync.toInstant()))).fetch().into(PUBLICATIONS);

		Result<com.sadb.generated.dest.oracle.tables.records.PublicationsRecord> oraclePublications =
				contextOracle.select().from(Publications.PUBLICATIONS).fetch().into(Publications.PUBLICATIONS);

		processPublications(
				mysqlPublications,
				oraclePublications,
				oracleTypeEdition,
				oracleTypePublication,
				oracleStudents,
				toInsert,
				toUpdate);

		SyncLogRecord syncLogRecord = new SyncLogRecord();
		syncLogRecord.setDbType(BigInteger.valueOf(MYSQL_DB_ID));
		syncLogRecord.setTimestamp(syncStartTime);

		toInsert.add(syncLogRecord);


		if (!toInsert.isEmpty()) {
			contextOracle.batchInsert(toInsert).execute();
		}
		if (!toUpdate.isEmpty()) {
			contextOracle.batchUpdate(toUpdate).execute();
		}

	}


	private  void processConference(List<ConferenceRecord> mysqlConference,
					  List<com.sadb.generated.dest.oracle.tables.records.ConferenceRecord> oracleConferences,
					  List<TableRecord<?>> toInsert,
					  List<UpdatableRecord<?>> toUpdate){

		// Build id -> updateTime map
		Map<Integer, Timestamp> conferenceIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.ConferenceRecord> conferenceIdToRecordMap = new HashMap<>();

		oracleConferences.forEach(oracleConference -> {
			conferenceIdToUpdatedDateMap.put(oracleConference.getId().intValue(), oracleConference.getDataUpdate());
			conferenceIdToRecordMap.put(oracleConference.getId().intValue(), oracleConference);

		});

		for (ConferenceRecord mysqlConferenceRecord : mysqlConference) {
			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlConferenceRecord.getDataUpdate().toLocalDateTime());
			Timestamp oracleRecordUpdateDate = conferenceIdToUpdatedDateMap.get(mysqlConferenceRecord.getId().intValue());

			// if oracleRecordUpdateDate == null -> insert new record
			// if oracleUpdateTime after postgresUpdateTime -> Ignore
			// if oracleUpdateTime before postgresUpdateTime -> Update current record
			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {

				com.sadb.generated.dest.oracle.tables.records.ConferenceRecord oldRecord = conferenceIdToRecordMap.get(mysqlConferenceRecord.getId().intValue());

				com.sadb.generated.dest.oracle.tables.records.ConferenceRecord conferenceRecord;
				Mode mode;
				if (oldRecord == null) {
					conferenceRecord = new com.sadb.generated.dest.oracle.tables.records.ConferenceRecord();
					conferenceRecord.setId(mysqlConferenceRecord.getId().longValue());
					mode = Mode.INSERT;
				} else {
					conferenceRecord = oldRecord;
					conferenceRecord.changed(true);
					mode = Mode.UPDATE;
				}

				conferenceRecord.setId(mysqlConferenceRecord.getId().longValue());
				conferenceRecord.setName(mysqlConferenceRecord.getName());
				conferenceRecord.setVenue(mysqlConferenceRecord.getVenue());
				conferenceRecord.setDateConference(mysqlConferenceRecord.getDateConference());
				conferenceRecord.setDataCreate(Timestamp.valueOf(mysqlConferenceRecord.getDataCreate().toLocalDateTime()));
				conferenceRecord.setDataUpdate(mysqlRecordUpdateDate);

				if (mode == Mode.INSERT) {
					toInsert.add(conferenceRecord);
				} else {
					toUpdate.add(conferenceRecord);
				}
				/*if (oracleRecordUpdateDate == null) {
					toInsert.add(conferenceRecord);
				} else if (mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {
					toUpdate.add(conferenceRecord);
				}*/
			}
		}
	}

	private void processTypePosition(Result<TypePositionRecord> mysqlTypePosition, Result<com.sadb.generated.dest.oracle.tables.records.TypePositionRecord> oracleTypePosition, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {

		// Build id -> updateTime map
		Map<Integer, Timestamp> typePositionIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.TypePositionRecord> typePositionIdToRecordMap = new HashMap<>();

		oracleTypePosition.forEach(oracleTypePositions -> {
			typePositionIdToUpdatedDateMap.put(oracleTypePositions.getId().intValue(), oracleTypePositions.getDataUpdate());
			typePositionIdToRecordMap.put(oracleTypePositions.getId().intValue(), oracleTypePositions);

		});

		for (TypePositionRecord mysqlTypePositionRecord : mysqlTypePosition) {
			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlTypePositionRecord.getDataUpdate().toLocalDateTime());
			Timestamp oracleRecordUpdateDate = typePositionIdToUpdatedDateMap.get(mysqlTypePositionRecord.getId().intValue());

			// if oracleRecordUpdateDate == null -> insert new record
			// if oracleUpdateTime after postgresUpdateTime -> Ignore
			// if oracleUpdateTime before postgresUpdateTime -> Update current record
			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {

				com.sadb.generated.dest.oracle.tables.records.TypePositionRecord oldRecord = typePositionIdToRecordMap.get(mysqlTypePositionRecord.getId().intValue());

				com.sadb.generated.dest.oracle.tables.records.TypePositionRecord typePositionRecord;
				Mode mode;
				if (oldRecord == null) {
					typePositionRecord = new com.sadb.generated.dest.oracle.tables.records.TypePositionRecord();
					typePositionRecord.setId(mysqlTypePositionRecord.getId().longValue());
					mode = Mode.INSERT;
				} else {
					typePositionRecord = oldRecord;
					typePositionRecord.changed(true);
					mode = Mode.UPDATE;
				}


				typePositionRecord.setName(mysqlTypePositionRecord.getName());
				typePositionRecord.setDataCreate(Timestamp.valueOf(mysqlTypePositionRecord.getDataCreate().toLocalDateTime()));
				typePositionRecord.setDataUpdate(mysqlRecordUpdateDate);

				if (mode == Mode.INSERT) {
					toInsert.add(typePositionRecord);
				} else {
					toUpdate.add(typePositionRecord);
				}
//				if (oracleRecordUpdateDate == null) {
//					toInsert.add(typePositionRecord);
//				} else if (mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {
//					toUpdate.add(typePositionRecord);
//				}
			}
		}
	}

	private void processParticipant(Result<ParticipantRecord> mysqlParticipant, Result<StudentRecord> oracleStudents, Result<com.sadb.generated.dest.oracle.tables.records.TypePositionRecord> typePositionForms, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {

		Map<Integer, Timestamp> studentIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, StudentRecord> studentIdToRecordMap = new HashMap<>();

		AtomicReference<Integer> maxId = new AtomicReference<>(1);
		Map<String, Integer> positionFormNameToIdMap = new HashMap<>();

		oracleStudents.forEach(oracleStudent -> {
			studentIdToUpdatedDateMap.put(oracleStudent.getId().intValue(), oracleStudent.getUpdationDate());
			studentIdToRecordMap.put(oracleStudent.getId().intValue(), oracleStudent);
		});

		typePositionForms.forEach(typePositionForm -> {
			positionFormNameToIdMap.put(typePositionForm.getName(), typePositionForm.getId().intValue());

		});
			for (ParticipantRecord mysqlParticipantRecord : mysqlParticipant) {

				Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlParticipantRecord.getDataUpdate().toLocalDateTime());
				Timestamp oracleRecordUpdateDate = studentIdToUpdatedDateMap.get(mysqlParticipantRecord.getId().intValue());

				// if oracleRecordUpdateDate == null -> insert new record
				// if oracleUpdateTime after postgresUpdateTime -> Ignore
				// if oracleUpdateTime before postgresUpdateTime -> Update current record
				if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {

					StudentRecord oldRecord = studentIdToRecordMap.get(mysqlParticipantRecord.getId().intValue());

					StudentRecord studentRecord;
					Mode mode;
					BigDecimal ID = new BigDecimal(mysqlParticipantRecord.getId().intValue());
					if (oldRecord == null) {
						studentRecord = new StudentRecord();
						studentRecord.setId(ID);
						mode = Mode.INSERT;
					} else {
						studentRecord = oldRecord;
						studentRecord.changed(true);
						mode = Mode.UPDATE;
					}

					studentRecord.setUpdationDate(mysqlRecordUpdateDate);
					studentRecord.setCreationDate(Timestamp.valueOf(mysqlParticipantRecord.getDataCreate().toLocalDateTime()));

					Integer formId = mysqlParticipantRecord.getPositionId();
					studentRecord.setPositionId(formId.longValue());

					if (mode == Mode.INSERT) {
						toInsert.add(studentRecord);
					} else {
						toUpdate.add(studentRecord);
					}
				}

			}




	}

	private void processListParticipant(Result<ListParticipantRecord> mysqlListParticipant, Result<com.sadb.generated.dest.oracle.tables.records.ListParticipantRecord> oraclelListParticipant, Result<StudentRecord> oracleStudents, Result<com.sadb.generated.dest.oracle.tables.records.ConferenceRecord> oraclConference, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {

		Map<Integer, Timestamp> listParticipantIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.ListParticipantRecord> listParticipantIdToRecordMap = new HashMap<>();

		Map<Integer, com.sadb.generated.dest.oracle.tables.records.ConferenceRecord> conferenceIdToRecordMap = new HashMap<>();
		Map<Integer, StudentRecord> studentIdToRecordMap = new HashMap<>();

		oraclelListParticipant.forEach(oracleListPart -> {
			listParticipantIdToUpdatedDateMap.put( oracleListPart.getParticipantId().intValue(),oracleListPart.getDataUpdate());
			listParticipantIdToRecordMap.put(oracleListPart.getParticipantId().intValue(), oracleListPart);
		});
		oracleStudents.forEach(oracleStudent -> {
			studentIdToRecordMap.put(oracleStudent.getId().intValue(), oracleStudent);
		});

		oraclConference.forEach(oracleConference -> {
			conferenceIdToRecordMap.put(oracleConference.getId().intValue(), oracleConference);

		});

		for (ListParticipantRecord mysqlListParticipantRecord : mysqlListParticipant) {

			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlListParticipantRecord.getDataUpdate().toLocalDateTime());
			Timestamp oracleRecordUpdateDate = listParticipantIdToUpdatedDateMap.get(mysqlListParticipantRecord.getParticipantId().intValue());

			// if oracleRecordUpdateDate == null -> insert new record
			// if oracleUpdateTime after postgresUpdateTime -> Ignore
			// if oracleUpdateTime before postgresUpdateTime -> Update current record
			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {



				com.sadb.generated.dest.oracle.tables.records.ListParticipantRecord oldRecord = listParticipantIdToRecordMap.get(mysqlListParticipantRecord.getParticipantId());
				com.sadb.generated.dest.oracle.tables.records.ListParticipantRecord listParticipantRecord;
				Mode mode;
				if (oldRecord == null) {
					listParticipantRecord = new com.sadb.generated.dest.oracle.tables.records.ListParticipantRecord();
					mode = Mode.INSERT;
				} else {
					listParticipantRecord = oldRecord;
					listParticipantRecord.changed(true);
					mode = Mode.UPDATE;
				}

				listParticipantRecord.setParticipantId(mysqlListParticipantRecord.getParticipantId().longValue());
				listParticipantRecord.setConferenceId(mysqlListParticipantRecord.getConferenceId().longValue());
				listParticipantRecord.setDataUpdate(mysqlRecordUpdateDate);
				listParticipantRecord.setDataCreate(Timestamp.valueOf(mysqlListParticipantRecord.getDataCreate().toLocalDateTime()));


				if (mode == Mode.INSERT) {
					toInsert.add(listParticipantRecord);
				} else  {
					toUpdate.add((UpdatableRecord<?>) listParticipantRecord);
				}
			}

		}
	}

	private void processScientificProject(Result<com.sadb.generated.source.mysql.tables.records.ScientificProjectRecord> mysqlScientificProject, Result<ScientificProjectRecord> oracleScientificProject, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {

		// Build id -> updateTime map
		Map<Integer, Timestamp> scientificProjectIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, ScientificProjectRecord> scientificProjectIdToRecordMap = new HashMap<>();

		oracleScientificProject.forEach(oracleScientificProjects -> {
			scientificProjectIdToUpdatedDateMap.put(oracleScientificProjects.getId().intValue(), oracleScientificProjects.getDataUpdate());
			scientificProjectIdToRecordMap.put(oracleScientificProjects.getId().intValue(), oracleScientificProjects);

		});

		for (com.sadb.generated.source.mysql.tables.records.ScientificProjectRecord mysqlScientificProjectRecord : mysqlScientificProject) {
			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlScientificProjectRecord.getDataUpdate().toLocalDateTime());
			Timestamp oracleRecordUpdateDate = scientificProjectIdToUpdatedDateMap.get(mysqlScientificProjectRecord.getId().intValue());

			// if oracleRecordUpdateDate == null -> insert new record
			// if oracleUpdateTime after postgresUpdateTime -> Ignore
			// if oracleUpdateTime before postgresUpdateTime -> Update current record
			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {

				ScientificProjectRecord oldRecord = scientificProjectIdToRecordMap.get(mysqlScientificProjectRecord.getId().intValue());

				ScientificProjectRecord scientificProjectRecord;
				Mode mode;
				if (oldRecord == null) {
					scientificProjectRecord = new ScientificProjectRecord();
					scientificProjectRecord.setId(mysqlScientificProjectRecord.getId().longValue());
					mode = Mode.INSERT;
				} else {
					scientificProjectRecord = oldRecord;
					scientificProjectRecord.changed(true);
					mode = Mode.UPDATE;
				}

				scientificProjectRecord.setId(mysqlScientificProjectRecord.getId().longValue());
				scientificProjectRecord.setName(mysqlScientificProjectRecord.getName());
				scientificProjectRecord.setPeriodParticipation(mysqlScientificProjectRecord.getPeriodParticipation());
				scientificProjectRecord.setDataCreate(Timestamp.valueOf(mysqlScientificProjectRecord.getDataCreate().toLocalDateTime()));
				scientificProjectRecord.setDataUpdate(mysqlRecordUpdateDate);

				if (mode == Mode.INSERT) {
					toInsert.add(scientificProjectRecord);
				} else {
					toUpdate.add(scientificProjectRecord);
				}

			}
		}
	}

	private void processListParticipantProject(Result<com.sadb.generated.source.mysql.tables.records.ListParticipantProjectRecord> mysqlListParticipantProject, Result<ListParticipantProjectRecord> oraclelListParticipantProject, Result<StudentRecord> oracleStudents, Result<ScientificProjectRecord> oracleScientificProject, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {

		Map<Integer, Timestamp> listParticipantProjectIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.ListParticipantProjectRecord> listParticipantProjectIdToRecordMap = new HashMap<>();

		Map<Integer, com.sadb.generated.dest.oracle.tables.records.ScientificProjectRecord> scientificProjectIdToRecordMap = new HashMap<>();
		Map<Integer, StudentRecord> studentIdToRecordMap = new HashMap<>();

		oraclelListParticipantProject.forEach(oracleListPartProj -> {
			listParticipantProjectIdToUpdatedDateMap.put( oracleListPartProj.getParticipantId().intValue(),oracleListPartProj.getDataUpdate());
			listParticipantProjectIdToRecordMap.put(oracleListPartProj.getParticipantId().intValue(), oracleListPartProj);
		});
		oracleStudents.forEach(oracleStudent -> {
			studentIdToRecordMap.put(oracleStudent.getId().intValue(), oracleStudent);
		});

		oracleScientificProject.forEach(oracleScientificProjects -> {
			scientificProjectIdToRecordMap.put(oracleScientificProjects.getId().intValue(), oracleScientificProjects);

		});
		for (com.sadb.generated.source.mysql.tables.records.ListParticipantProjectRecord mysqlListParticipantProjectRecord : mysqlListParticipantProject) {

			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlListParticipantProjectRecord.getDataUpdate().toLocalDateTime());
			Timestamp oracleRecordUpdateDate = listParticipantProjectIdToUpdatedDateMap.get(mysqlListParticipantProjectRecord.getParticipantId().intValue());

			// if oracleRecordUpdateDate == null -> insert new record
			// if oracleUpdateTime after postgresUpdateTime -> Ignore
			// if oracleUpdateTime before postgresUpdateTime -> Update current record
			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {



				com.sadb.generated.dest.oracle.tables.records.ListParticipantProjectRecord oldRecord = listParticipantProjectIdToRecordMap.get(mysqlListParticipantProjectRecord.getParticipantId());
				com.sadb.generated.dest.oracle.tables.records.ListParticipantProjectRecord listParticipantProjectRecord;
				Mode mode;
				if (oldRecord == null) {
					listParticipantProjectRecord = new com.sadb.generated.dest.oracle.tables.records.ListParticipantProjectRecord();
					mode = Mode.INSERT;
				} else {
					listParticipantProjectRecord = oldRecord;
					listParticipantProjectRecord.changed(true);
					mode = Mode.UPDATE;
				}

				listParticipantProjectRecord.setParticipantId(mysqlListParticipantProjectRecord.getParticipantId().longValue());
				listParticipantProjectRecord.setProjectId(mysqlListParticipantProjectRecord.getProjectId().longValue());
				listParticipantProjectRecord.setDataUpdate(mysqlRecordUpdateDate);
				listParticipantProjectRecord.setDataCreate(Timestamp.valueOf(mysqlListParticipantProjectRecord.getDataCreate().toLocalDateTime()));


				if (mode == Mode.INSERT) {
					toInsert.add(listParticipantProjectRecord);
				} else  {
					toUpdate.add((UpdatableRecord<?>) listParticipantProjectRecord);
				}
			}
		}
	}

	private void processReaderSheet(Result<com.sadb.generated.source.mysql.tables.records.ReaderSheetRecord> mysqlReaderSheet, Result<ReaderSheetRecord> oraclelReaderSheet, Result<StudentRecord> oracleStudents, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {
		Map<Integer, Timestamp> readerSheetIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.ReaderSheetRecord> readerSheetIdToRecordMap = new HashMap<>();

		Map<Integer, StudentRecord> studentIdToRecordMap = new HashMap<>();

		oraclelReaderSheet.forEach(oracleReaderSheets-> {
			readerSheetIdToUpdatedDateMap.put( oracleReaderSheets.getParticipantId().intValue(),oracleReaderSheets.getDataUpdate());
			readerSheetIdToRecordMap.put(oracleReaderSheets.getParticipantId().intValue(), oracleReaderSheets);
		});
		oracleStudents.forEach(oracleStudent -> {
			studentIdToRecordMap.put(oracleStudent.getId().intValue(), oracleStudent);
		});
		for (com.sadb.generated.source.mysql.tables.records.ReaderSheetRecord mysqlReaderSheetRecord : mysqlReaderSheet) {

			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlReaderSheetRecord.getDataUpdate().toLocalDateTime());
			Timestamp oracleRecordUpdateDate = readerSheetIdToUpdatedDateMap.get(mysqlReaderSheetRecord.getParticipantId().intValue());

			// if oracleRecordUpdateDate == null -> insert new record
			// if oracleUpdateTime after postgresUpdateTime -> Ignore
			// if oracleUpdateTime before postgresUpdateTime -> Update current record
			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {



				com.sadb.generated.dest.oracle.tables.records.ReaderSheetRecord oldRecord = readerSheetIdToRecordMap.get(mysqlReaderSheetRecord.getParticipantId());
				com.sadb.generated.dest.oracle.tables.records.ReaderSheetRecord readerSheetRecord;
				Mode mode;
				if (oldRecord == null) {
					readerSheetRecord = new com.sadb.generated.dest.oracle.tables.records.ReaderSheetRecord();
					readerSheetRecord.setId(mysqlReaderSheetRecord.getId().longValue());
					mode = Mode.INSERT;
				} else {
					readerSheetRecord = oldRecord;
					readerSheetRecord.changed(true);
					mode = Mode.UPDATE;
				}

				readerSheetRecord.setParticipantId(mysqlReaderSheetRecord.getParticipantId().longValue());
				readerSheetRecord.setTitleBook(mysqlReaderSheetRecord.getTitleBook());
				readerSheetRecord.setDateTake(mysqlReaderSheetRecord.getDateTake());
				readerSheetRecord.setDatePut(mysqlReaderSheetRecord.getDatePut());
				readerSheetRecord.setDataUpdate(mysqlRecordUpdateDate);
				readerSheetRecord.setDataCreate(Timestamp.valueOf(mysqlReaderSheetRecord.getDataCreate().toLocalDateTime()));


				if (mode == Mode.INSERT) {
					toInsert.add(readerSheetRecord);
				} else  {
					toUpdate.add(readerSheetRecord);
				}
			}
		}
	}

	private void processTypePublication(Result<com.sadb.generated.source.mysql.tables.records.TypePublicationRecord> mysqlTypePublication, Result<TypePublicationRecord> oracleTypePublication, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {
		// Build id -> updateTime map
		Map<Integer, Timestamp> typePublicationIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.TypePublicationRecord> typePublicationIdToRecordMap = new HashMap<>();

		oracleTypePublication.forEach(oraclePublication -> {
			typePublicationIdToUpdatedDateMap.put(oraclePublication.getId().intValue(), oraclePublication.getDataUpdate());
			typePublicationIdToRecordMap.put(oraclePublication.getId().intValue(), oraclePublication);

		});

		for (com.sadb.generated.source.mysql.tables.records.TypePublicationRecord mysqlTypePublicationRecord : mysqlTypePublication) {
			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlTypePublicationRecord.getDataUpdate().toLocalDateTime());
			Timestamp oracleRecordUpdateDate = typePublicationIdToUpdatedDateMap.get(mysqlTypePublicationRecord.getId().intValue());

			// if oracleRecordUpdateDate == null -> insert new record
			// if oracleUpdateTime after postgresUpdateTime -> Ignore
			// if oracleUpdateTime before postgresUpdateTime -> Update current record
			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {

				com.sadb.generated.dest.oracle.tables.records.TypePublicationRecord oldRecord = typePublicationIdToRecordMap.get(mysqlTypePublicationRecord.getId().intValue());

				com.sadb.generated.dest.oracle.tables.records.TypePublicationRecord typePublicationRecord;
				Mode mode;
				if (oldRecord == null) {
					typePublicationRecord = new com.sadb.generated.dest.oracle.tables.records.TypePublicationRecord();
					typePublicationRecord.setId(mysqlTypePublicationRecord.getId().longValue());
					mode = Mode.INSERT;
				} else {
					typePublicationRecord = oldRecord;
					typePublicationRecord.changed(true);
					mode = Mode.UPDATE;
				}


				typePublicationRecord.setName(mysqlTypePublicationRecord.getName());
				typePublicationRecord.setDataCreate(Timestamp.valueOf(mysqlTypePublicationRecord.getDataCreate().toLocalDateTime()));
				typePublicationRecord.setDataUpdate(mysqlRecordUpdateDate);

				if (mode == Mode.INSERT) {
					toInsert.add(typePublicationRecord);
				} else {
					toUpdate.add(typePublicationRecord);
				}
//				if (oracleRecordUpdateDate == null) {
//					toInsert.add(typePositionRecord);
//				} else if (mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {
//					toUpdate.add(typePositionRecord);
//				}
			}
		}
	}

	private void processTypeEdition(Result<com.sadb.generated.source.mysql.tables.records.TypeEditionRecord> mysqlTypeEdition, Result<TypeEditionRecord> oracleTypeEdition, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {
// Build id -> updateTime map
		Map<Integer, Timestamp> typeEditionIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.TypeEditionRecord> typeEditionIdToRecordMap = new HashMap<>();

		oracleTypeEdition.forEach(oracleEdition -> {
			typeEditionIdToUpdatedDateMap.put(oracleEdition.getId().intValue(), oracleEdition.getDataUpdate());
			typeEditionIdToRecordMap.put(oracleEdition.getId().intValue(), oracleEdition);

		});

		for (com.sadb.generated.source.mysql.tables.records.TypeEditionRecord mysqlTypeEditionRecord : mysqlTypeEdition) {
			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlTypeEditionRecord.getDataUpdate().toLocalDateTime());
			Timestamp oracleRecordUpdateDate = typeEditionIdToUpdatedDateMap.get(mysqlTypeEditionRecord.getId().intValue());

			// if oracleRecordUpdateDate == null -> insert new record
			// if oracleUpdateTime after postgresUpdateTime -> Ignore
			// if oracleUpdateTime before postgresUpdateTime -> Update current record
			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {

				com.sadb.generated.dest.oracle.tables.records.TypeEditionRecord oldRecord = typeEditionIdToRecordMap.get(mysqlTypeEditionRecord.getId().intValue());

				com.sadb.generated.dest.oracle.tables.records.TypeEditionRecord typeEditionRecord;
				Mode mode;
				if (oldRecord == null) {
					typeEditionRecord = new com.sadb.generated.dest.oracle.tables.records.TypeEditionRecord();
					typeEditionRecord.setId(mysqlTypeEditionRecord.getId().longValue());
					mode = Mode.INSERT;
				} else {
					typeEditionRecord = oldRecord;
					typeEditionRecord.changed(true);
					mode = Mode.UPDATE;
				}


				typeEditionRecord.setName(mysqlTypeEditionRecord.getName());
				typeEditionRecord.setDataCreate(Timestamp.valueOf(mysqlTypeEditionRecord.getDataCreate().toLocalDateTime()));
				typeEditionRecord.setDataUpdate(mysqlRecordUpdateDate);

				if (mode == Mode.INSERT) {
					toInsert.add(typeEditionRecord);
				} else {
					toUpdate.add(typeEditionRecord);
				}
//				if (oracleRecordUpdateDate == null) {
//					toInsert.add(typePositionRecord);
//				} else if (mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {
//					toUpdate.add(typePositionRecord);
//				}
			}
		}
	}

	private void processPublications(Result<com.sadb.generated.source.mysql.tables.records.PublicationsRecord> mysqlPublications, Result<PublicationsRecord> oraclePublications, Result<TypeEditionRecord> oracleTypeEdition, Result<TypePublicationRecord> oracleTypePublication, Result<StudentRecord> oracleStudents, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {
		Map<Integer, Timestamp> publicationsIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.PublicationsRecord> publicationsIdToRecordMap = new HashMap<>();

		Map<String, Integer> positionFormNameToIdMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.TypeEditionRecord> typeEditionIdToRecordMap = new HashMap<>();
		Map<Integer, StudentRecord> studentIdToRecordMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.TypePublicationRecord> typePublicationIdToRecordMap = new HashMap<>();

		oraclePublications.forEach(oracleConference -> {
			publicationsIdToUpdatedDateMap.put(oracleConference.getId().intValue(), oracleConference.getDataUpdate());
			publicationsIdToRecordMap.put(oracleConference.getId().intValue(), oracleConference);

		});
		oracleTypePublication.forEach(oraclePublication -> {
			typePublicationIdToRecordMap.put(oraclePublication.getId().intValue(), oraclePublication);

		});
		oracleTypeEdition.forEach(oracleEdition -> {
			typeEditionIdToRecordMap.put(oracleEdition.getId().intValue(), oracleEdition);

		});
		oracleStudents.forEach(oracleStudent -> {
			studentIdToRecordMap.put(oracleStudent.getId().intValue(), oracleStudent);
		});


		for (com.sadb.generated.source.mysql.tables.records.PublicationsRecord mysqlPublicationsRecord : mysqlPublications) {
			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlPublicationsRecord.getDataUpdate().toLocalDateTime());
			Timestamp oracleRecordUpdateDate = publicationsIdToUpdatedDateMap.get(mysqlPublicationsRecord.getId().intValue());


			// if oracleRecordUpdateDate == null -> insert new record
			// if oracleUpdateTime after postgresUpdateTime -> Ignore
			// if oracleUpdateTime before postgresUpdateTime -> Update current record
			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {

				com.sadb.generated.dest.oracle.tables.records.PublicationsRecord oldRecord = publicationsIdToRecordMap.get(mysqlPublicationsRecord.getId().intValue());

				com.sadb.generated.dest.oracle.tables.records.PublicationsRecord publicationsRecord;
				Mode mode;
				if (oldRecord == null) {
					publicationsRecord = new PublicationsRecord();
					publicationsRecord.setId(mysqlPublicationsRecord.getId().longValue());
					mode = Mode.INSERT;
				} else {
					publicationsRecord = oldRecord;
					publicationsRecord.changed(true);
					mode = Mode.UPDATE;
				}

				publicationsRecord.setTitleEdition(mysqlPublicationsRecord.getTitleEdition());
				publicationsRecord.setLanguagePublication(mysqlPublicationsRecord.getLanguagePublication());
				publicationsRecord.setVolumeEdition(mysqlPublicationsRecord.getVolumeEdition());
				publicationsRecord.setPlaceEditon(mysqlPublicationsRecord.getPlaceEditon());
				publicationsRecord.setEditionId(mysqlPublicationsRecord.getEditionId().longValue());
				publicationsRecord.setCoAuthors(mysqlPublicationsRecord.getCoAuthors());
				publicationsRecord.setCitationIndex(mysqlPublicationsRecord.getCitationIndex());
				publicationsRecord.setDataPublication(mysqlPublicationsRecord.getDataPublication());
				publicationsRecord.setParticipantId(mysqlPublicationsRecord.getParticipantId().longValue());
				publicationsRecord.setIdTypePublication(mysqlPublicationsRecord.getIdTypePublication().longValue());
				publicationsRecord.setDataCreate(Timestamp.valueOf(mysqlPublicationsRecord.getDataCreate().toLocalDateTime()));
				publicationsRecord.setDataUpdate(mysqlRecordUpdateDate);

				if (mode == Mode.INSERT) {
					toInsert.add(publicationsRecord);
				} else {
					toUpdate.add(publicationsRecord);
				}
			}

		}
	}

	private Connection getSourceMysqlConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	private static enum Mode {
		INSERT, UPDATE
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		MysqlMigrationService m = new MysqlMigrationService();
		m.process();
	}
}



