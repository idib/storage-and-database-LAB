package com.sadb.transformation.mysql;


import com.sadb.generated.dest.oracle.tables.Publications;
import com.sadb.generated.dest.oracle.tables.TypePosition;
import com.sadb.generated.dest.oracle.tables.records.*;
import com.sadb.generated.source.mysql.tables.TypePublication;
import com.sadb.generated.source.mysql.tables.records.ConferenceRecord;
import com.sadb.generated.source.mysql.tables.records.ListParticipantProjectRecord;
import com.sadb.generated.source.mysql.tables.records.ListParticipantRecord;
import com.sadb.generated.source.mysql.tables.records.ParticipantRecord;
import com.sadb.generated.source.mysql.tables.records.ReaderSheetRecord;
import com.sadb.generated.source.mysql.tables.records.ScientificProjectRecord;
import com.sadb.generated.source.mysql.tables.records.TypeEditionRecord;
import com.sadb.generated.source.mysql.tables.records.TypePositionRecord;
import com.sadb.generated.source.mysql.tables.records.TypePublicationRecord;


import com.sadb.transformation.ConnectionManager;
import org.jooq.*;
//import org.jooq.Statement;
import org.jooq.impl.DSL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.*;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.sadb.generated.dest.oracle.Tables.*;

import static com.sadb.generated.source.mysql.Tables.CONFERENCE_;
import static com.sadb.generated.source.mysql.Tables.TYPE_POSITION;
import static com.sadb.generated.source.mysql.Tables.PARTICIPANT;
import static com.sadb.generated.source.mysql.Tables.PUBLICATIONS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class MysqlMigrationService {
	private static final String URL = "jdbc:mysql://conference.cakqhkplapqx.eu-central-1.rds.amazonaws.com:3306/conference";
	private static final String USER = "db_itmo";
	private static final String PASSWORD = "qwerty14";
//	private static final String URL = System.getenv("aws_mysql_url");
//	private static final String USER = System.getenv("aws_mysql_user");
//	private static final String PASSWORD = System.getenv("aws_mysql_password");
	private static Statement stmt;
	private static ResultSet rs;

	@Scheduled(fixedDelayString = "#{ 70 * 1000}")
	public void process() throws SQLException {

		List<TableRecord<?>> toInsert = new ArrayList<>();
		List<UpdatableRecord<?>> toUpdate = new ArrayList<>();
		String query = "select count(*) from Participant";

		// Connect to Mysql
//        Class.forName(JDBC_DRIVER);

		Connection connectionMysql = getSourceMysqlConnection();

		// Connect to Oracle
		Connection connectionOracle = ConnectionManager.getDestDBConnection();

		// Create context
		DSLContext contextMysql = DSL.using(connectionMysql, SQLDialect.MYSQL);
		DSLContext contextOracle = DSL.using(connectionOracle, SQLDialect.ORACLE);


//		// getting Statement object to execute query
//		stmt = connectionMysql.createStatement();
//
//		// executing SELECT query
//		rs = stmt.executeQuery(query);
//
//		while (rs.next()) {
//			int count = rs.getInt(1);
//			System.out.println("Total number of books in the table : " + count);
//		}

		// CONFERENCE CONFERENCE CONFERENCE CONFERENCE CONFERENCE
		Result<ConferenceRecord> mysqlConference =
				contextMysql.select().from(CONFERENCE_).fetch().into(CONFERENCE_);

		Result<com.sadb.generated.dest.oracle.tables.records.ConferenceRecord> oraclConference =
				contextOracle.select().from(CONFERENCE).fetch().into(CONFERENCE);

		processConference(
				mysqlConference,
				oraclConference,
				toInsert,
				toUpdate);

		//TYPE_POSITION TYPE_POSITION TYPE_POSITION
		Result<TypePositionRecord> mysqlTypePosition =
				contextMysql.select().from(TYPE_POSITION).fetch().into(TYPE_POSITION);
		Result<com.sadb.generated.dest.oracle.tables.records.TypePositionRecord> typePosition =
				contextOracle.select().from(com.sadb.generated.dest.oracle.tables.TypePosition.TYPE_POSITION).fetch().into(com.sadb.generated.dest.oracle.tables.TypePosition.TYPE_POSITION);


		processTypePosition(
				mysqlTypePosition,
				typePosition,
				toInsert,
				toUpdate);

		//PARTICIPANT
		Result<ParticipantRecord> mysqlParticipant =
				contextMysql.select().from(PARTICIPANT).fetch().into(PARTICIPANT);
		Result<StudentRecord> oracleStudents =
				contextOracle.select().from(STUDENT).fetch().into(STUDENT);
		Result<com.sadb.generated.dest.oracle.tables.records.TypePositionRecord> typePositionForms =
				contextOracle.select().from(com.sadb.generated.dest.oracle.tables.TypePosition.TYPE_POSITION).fetch().into(com.sadb.generated.dest.oracle.tables.TypePosition.TYPE_POSITION);

		processParticipant(
				mysqlParticipant,
				oracleStudents,
				typePositionForms,
				toInsert,
				toUpdate);

//		//PUBLICATIONS com.sadb.generated.source.mysql.tables.records.
//		Result<com.sadb.generated.source.mysql.tables.records.PublicationsRecord> mysqlPublications =
//				contextMysql.select().from(PUBLICATIONS).fetch().into(PUBLICATIONS);
//		Result<PublicationsRecord> oraclePublications =
//				contextOracle.select().from(Publications.PUBLICATIONS).fetch().into(Publications.PUBLICATIONS);
//
//		processPublications(
//				mysqlPublications,
//				oraclePublications,
//				toInsert,
//				toUpdate);

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
				if (oldRecord == null) {
					conferenceRecord = new com.sadb.generated.dest.oracle.tables.records.ConferenceRecord();
				} else {
					conferenceRecord = oldRecord;
					conferenceRecord.changed(true);
				}

				conferenceRecord.setId(mysqlConferenceRecord.getId().longValue());
				conferenceRecord.setName(mysqlConferenceRecord.getName());
				conferenceRecord.setVenue(mysqlConferenceRecord.getVenue());
				conferenceRecord.setDateConference(mysqlConferenceRecord.getDateConference());
				conferenceRecord.setDataCreate(Timestamp.valueOf(mysqlConferenceRecord.getDataCreate().toLocalDateTime()));
				conferenceRecord.setDataUpdate(mysqlRecordUpdateDate);

				if (oracleRecordUpdateDate == null) {
					toInsert.add(conferenceRecord);
				} else if (mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {
					toUpdate.add(conferenceRecord);
				}
			}
		}
	}

	private void processTypePosition(Result<TypePositionRecord> mysqlTypePosition, Result<com.sadb.generated.dest.oracle.tables.records.TypePositionRecord> oracleTypePosition, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {

		// Build id -> updateTime map
		Map<Integer, Timestamp> typePositionIdToUpdatedDateMap = new HashMap<>();
		Map<Integer, com.sadb.generated.dest.oracle.tables.records.TypePositionRecord> typePositionIdToRecordMap = new HashMap<>();

		oracleTypePosition.forEach(oracleConference -> {
			typePositionIdToUpdatedDateMap.put(oracleConference.getId().intValue(), oracleConference.getDataUpdate());
			typePositionIdToRecordMap.put(oracleConference.getId().intValue(), oracleConference);

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
				if (oldRecord == null) {
					typePositionRecord = new com.sadb.generated.dest.oracle.tables.records.TypePositionRecord();
				} else {
					typePositionRecord = oldRecord;
					typePositionRecord.changed(true);
				}

				typePositionRecord.setId(mysqlTypePositionRecord.getId().longValue());
				typePositionRecord.setName(mysqlTypePositionRecord.getName());
				typePositionRecord.setDataCreate(Timestamp.valueOf(mysqlTypePositionRecord.getDataCreate().toLocalDateTime()));
				typePositionRecord.setDataUpdate(mysqlRecordUpdateDate);

				if (oracleRecordUpdateDate == null) {
					toInsert.add(typePositionRecord);
				} else if (mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {
					toUpdate.add(typePositionRecord);
				}
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
			if (typePositionForm.getId() > maxId.get()) {
				maxId.set(typePositionForm.getId().intValue() + 1);
			}

			for (ParticipantRecord mysqlParticipantRecord : mysqlParticipant) {

				Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlParticipantRecord.getDataUpdate().toLocalDateTime());
				Timestamp oracleRecordUpdateDate = studentIdToUpdatedDateMap.get(mysqlParticipantRecord.getId().intValue());

				// if oracleRecordUpdateDate == null -> insert new record
				// if oracleUpdateTime after postgresUpdateTime -> Ignore
				// if oracleUpdateTime before postgresUpdateTime -> Update current record
				if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {

					StudentRecord oldRecord = studentIdToRecordMap.get(mysqlParticipantRecord.getId().intValue());

					StudentRecord studentRecord;
					if (oldRecord == null) {
						studentRecord = new StudentRecord();
					} else {
						studentRecord = oldRecord;
						studentRecord.changed(true);
					}


					BigDecimal ID = new BigDecimal(mysqlParticipantRecord.getId().intValue());

					studentRecord.setId(ID);
					studentRecord.setSurname(mysqlParticipantRecord.getSurname());
					studentRecord.setName(mysqlParticipantRecord.getName());
					studentRecord.setSecondName(mysqlParticipantRecord.getSecondname());
					studentRecord.setUpdationDate(mysqlRecordUpdateDate);
					studentRecord.setCreationDate(Timestamp.valueOf(mysqlParticipantRecord.getDataCreate().toLocalDateTime()));

					Integer formId = mysqlParticipantRecord.getPositionId();
//					if (formId == null) {
//						TypePositionRecord record = new TypePositionRecord();
//						//FormEducationRecord record = new FormEducationRecord();
//						record.setId(maxId.get().intValue());
//						record.setName(mysqlParticipantRecord.getName());
//						// TODO set dates
//						Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//						record.setDataCreate(timestamp);
//						record.setDataUpdate(timestamp);
//
//						toInsert.add(record);
//					}

					studentRecord.setPositionId(formId.longValue());





					if (oracleRecordUpdateDate == null) {
						toInsert.add(studentRecord);
					} else if (mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {
						toUpdate.add(studentRecord);
					}
				}

			}
		});



	}
//	private void processPublications(Result<com.sadb.generated.source.mysql.tables.records.PublicationsRecord> mysqlPublications, Result<PublicationsRecord> oraclePublications, List<TableRecord<?>> toInsert, List<UpdatableRecord<?>> toUpdate) {
//
//		// Build id -> updateTime map
//		Map<Integer, Timestamp> publicationsIdToUpdatedDateMap = new HashMap<>();
//		Map<Integer, com.sadb.generated.dest.oracle.tables.records.PublicationsRecord> publicationsIdToRecordMap = new HashMap<>();
//
//		oraclePublications.forEach(oracleConference -> {
//			publicationsIdToUpdatedDateMap.put(oracleConference.getId().intValue(), oracleConference.getDataUpdate());
//			publicationsIdToRecordMap.put(oracleConference.getId().intValue(), oracleConference);
//
//		});
//
//
//		for (com.sadb.generated.source.mysql.tables.records.PublicationsRecord mysqlPublicationsRecord : mysqlPublications) {
//			Timestamp mysqlRecordUpdateDate = Timestamp.valueOf(mysqlPublicationsRecord.getDataUpdate().toLocalDateTime());
//			Timestamp oracleRecordUpdateDate = publicationsIdToUpdatedDateMap.get(mysqlPublicationsRecord.getId().intValue());
//
//			// if oracleRecordUpdateDate == null -> insert new record
//			// if oracleUpdateTime after postgresUpdateTime -> Ignore
//			// if oracleUpdateTime before postgresUpdateTime -> Update current record
//			if (oracleRecordUpdateDate == null || mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {
//
//				com.sadb.generated.dest.oracle.tables.records.PublicationsRecord oldRecord = publicationsIdToRecordMap.get(mysqlPublicationsRecord.getId().intValue());
//
//				com.sadb.generated.dest.oracle.tables.records.PublicationsRecord publicationsRecord;
//				if (oldRecord == null) {
//					publicationsRecord = new com.sadb.generated.dest.oracle.tables.records.PublicationsRecord();
//				} else {
//					publicationsRecord = oldRecord;
//					publicationsRecord.changed(true);
//				}
//
//				publicationsRecord.setId(mysqlPublicationsRecord.getId().longValue());
//				publicationsRecord.setTitleEdition(mysqlPublicationsRecord.getTitleEdition());
//				publicationsRecord.setLanguagePublication(mysqlPublicationsRecord.getLanguagePublication());
//				publicationsRecord.setVolumeEdition(mysqlPublicationsRecord.getVolumeEdition());
//				publicationsRecord.setPlaceEditon(mysqlPublicationsRecord.getPlaceEditon());
//				publicationsRecord.setEditionId(mysqlPublicationsRecord.getEditionId().longValue());
//				publicationsRecord.setCoAuthors(mysqlPublicationsRecord.getCoAuthors());
//				publicationsRecord.setCitationIndex(mysqlPublicationsRecord.getCitationIndex());
//				publicationsRecord.setDataPublication(mysqlPublicationsRecord.getDataPublication());
//				publicationsRecord.setParticipantId(mysqlPublicationsRecord.getParticipantId().longValue());
//				publicationsRecord.setIdTypePublication(mysqlPublicationsRecord.getIdTypePublication().longValue());
//				publicationsRecord.setDataCreate(Timestamp.valueOf(mysqlPublicationsRecord.getDataCreate().toLocalDateTime()));
//				publicationsRecord.setDataUpdate(mysqlRecordUpdateDate);
//
//				if (oracleRecordUpdateDate == null) {
//					toInsert.add(publicationsRecord);
//				} else if (mysqlRecordUpdateDate.after(oracleRecordUpdateDate)) {
//					toUpdate.add(publicationsRecord);
//				}
//			}
//		}
//	}


	private Connection getSourceMysqlConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static void main(String[] args) throws SQLException {
		MysqlMigrationService m = new MysqlMigrationService();
		m.process();
	}
}



