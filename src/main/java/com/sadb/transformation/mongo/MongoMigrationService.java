package com.sadb.transformation.mongo;

import com.mongodb.client.*;
import com.sadb.generated.dest.oracle.tables.EventType;
import com.sadb.generated.dest.oracle.tables.Room;
import com.sadb.generated.dest.oracle.tables.Student;
import com.sadb.generated.dest.oracle.tables.records.*;
import com.sadb.transformation.ConnectionManager;
import org.bson.Document;
import org.jooq.*;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.sadb.generated.dest.oracle.Tables.*;
import static org.jooq.impl.DSL.max;

@Service
public class MongoMigrationService {
	private static final String _id = "_id";
	private static final String _name = "name";
	private static final String _address = "address";
	private static final String _date_update = "date_update";
	private static final String _date_checkout = "date_checkout";
	private static final String _date_checkin = "date_checkin";
	private static final String _date_create = "date_create";
	private static final String _date_recursion = "date_recursion";
	private static final String _blocks = "blocks";
	private static final String _floor = "floor";
	private static final String _date_disinsection = "date_disinsection";
	private static final String _rooms = "rooms";
	private static final String _number = "number";
	private static final String _max_student = "max_student";
	private static final String _students = "students";
	private static final String _secondName = "secondName";
	private static final String _surname = "surname";
	private static final String _form_education = "form_education";
	private static final String _event = "event";
	private static final String _date = "date";
	private static final String _event_type = "event_type";


	private static final String DBNAME = "labs";
	private static final String mongoClientURI = System.getenv("source_mongo_uri");
	private static final BigInteger numberDB = new BigInteger("1");

	private final DSLContext contextOracle = DSL.using(ConnectionManager.getDestDBConnection(), SQLDialect.ORACLE);

	private static final Map<String, Long> eventTypeMap = new HashMap<>();

	public static void main(String[] args) throws ParseException {
		DSLContext contextOracle = DSL.using(ConnectionManager.getDestDBConnection(), SQLDialect.ORACLE);

		contextOracle.delete(ROOM).where("1=1").execute();
		contextOracle.delete(BLOCK).where("1=1").execute();
		contextOracle.delete(DORMITORY).where("1=1").execute();
		contextOracle.delete(EVENTS).where("1=1").execute();
		contextOracle.delete(EVENT_TYPE).where("1=1").execute();


		MongoMigrationService m = new MongoMigrationService();
		m.process();


//		MongoMigrationService m = new MongoMigrationService();
//		System.out.println(m.getEventType("зашелS"));

	}

	public Timestamp getTimestamp(java.util.Date date) {
		return date == null ? null : new java.sql.Timestamp(date.getTime());
	}

	private static java.sql.Date getSqlDate(Date uDate) {
		if (uDate == null)
			return null;
		return new java.sql.Date(uDate.getTime());
	}

	@Scheduled(fixedDelayString = "#{ 120 * 1000}", initialDelayString = "#{ 60 * 1000}")
	public void process() throws ParseException {

		List<TableRecord<?>> toInsert = new LinkedList<>();
		List<UpdatableRecord<?>> toUpdate = new LinkedList<>();
		List<StudentRecord> onlyStudent = new LinkedList<>();
		List<TableRecord<?>> lastToInsert = new LinkedList<>();
		List<UpdatableRecord<?>> lastToUpdate = new LinkedList<>();

		MongoClient mongoClient = MongoClients.create(mongoClientURI);

		System.out.println(mongoClientURI);

		MongoDatabase database = mongoClient.getDatabase(DBNAME);

		MongoCollection<Document> dormitories = database.getCollection("dormitory");
		MongoCollection<Document> students = database.getCollection("student");

		Record1<Timestamp> recortLastSync = contextOracle
				.select(max(SYNC_LOG.TIMESTAMP))
				.from(SYNC_LOG)
				.where(SYNC_LOG.DB_TYPE.eq(numberDB))
				.fetchOne();


		Date dateLastUpdate = new Date(recortLastSync.value1().getTime());

		MongoCursor<Document> cursor = dormitories.find().iterator();

		Date curDateUpdate;
		Date curDateCreate;
		Date curDateRecursion;
		Map<Long, StudentRecord> std = new HashMap<>();
		Map<String, EventsRecord> eventMap = new HashMap<>();
		try {
			for (Document dorm : dormitories.find()) {
				long idDorm = dorm.getInteger(_id);
				curDateUpdate = dorm.getDate(_date_update);
				curDateCreate = dorm.getDate(_date_create);
				curDateRecursion = dorm.getDate(_date_recursion);

				if (curDateCreate.after(dateLastUpdate) || curDateUpdate.after(dateLastUpdate)) {
					String name = dorm.getString(_name);
					String address = dorm.getString(_address);

					DormitoryRecord dormitoryRecord = new DormitoryRecord(idDorm, name, address, getTimestamp(curDateUpdate), getTimestamp(curDateCreate));

					if (curDateCreate.after(dateLastUpdate))
						toInsert.add(dormitoryRecord);
					else
						toUpdate.add(dormitoryRecord);
				}

				if (curDateRecursion.after(dateLastUpdate)) {
					for (Document block : dorm.getList(_blocks, Document.class)) {
						long idBlock = block.getInteger(_id);
						curDateUpdate = block.getDate(_date_update);
						curDateCreate = block.getDate(_date_create);
						curDateRecursion = dorm.getDate(_date_recursion);

						if (curDateCreate.after(dateLastUpdate) || curDateUpdate.after(dateLastUpdate)) {
							long floor = block.getInteger(_floor);
							Date date_disinsection = block.getDate(_date_disinsection);

							BlockRecord blockRecord = new BlockRecord(idBlock, floor, getSqlDate(date_disinsection), idDorm, getTimestamp(curDateUpdate), getTimestamp(curDateCreate));

							if (curDateCreate.after(dateLastUpdate))
								toInsert.add(blockRecord);
							else
								toUpdate.add(blockRecord);
						}

						if (curDateRecursion.after(dateLastUpdate)) {
							for (Document room : block.getList(_rooms, Document.class)) {
								long idRoom = room.getInteger(_id);
								curDateUpdate = room.getDate(_date_update);
								curDateCreate = room.getDate(_date_create);
								curDateRecursion = dorm.getDate(_date_recursion);

								if (curDateCreate.after(dateLastUpdate) || curDateUpdate.after(dateLastUpdate)) {
									String number = room.getString(_number);
									long max_student = room.getInteger(_max_student);

									RoomRecord roomRecord = new RoomRecord(idRoom, number, max_student, idBlock, getTimestamp(curDateUpdate), getTimestamp(curDateCreate));

									if (curDateCreate.after(dateLastUpdate))
										toInsert.add(roomRecord);
									else
										toUpdate.add(roomRecord);

									if (curDateRecursion.after(dateLastUpdate)) {
										for (Integer idStudent : room.getList(_students, Integer.class)) {

											StudentRecord studentRecord = new StudentRecord();
											studentRecord.setId(new BigDecimal(idStudent));
											studentRecord.setRoomId(idRoom);
											std.put(idStudent.longValue(), studentRecord);


											try {
												contextOracle.update(STUDENT).set(STUDENT.ROOM_ID, idRoom)
														.where(STUDENT.ID.eq(studentRecord.getId())).execute();

											} catch (DataAccessException e) {
//												e.printStackTrace();
											}
										}
									}
								}
							}
						}
					}
				}
			}

			for (Document student : students.find()) {
				long idStudent = student.getInteger(_id);
				curDateUpdate = student.getDate(_date_update);
				curDateCreate = student.getDate(_date_create);
				curDateRecursion = student.getDate(_date_recursion);

				if (curDateCreate.after(dateLastUpdate) || curDateUpdate.after(dateLastUpdate)) {
					String name = student.getString(_name);
					String secondName = student.getString(_secondName);
					String surname = student.getString(_surname);
					String form_education = student.getString(_form_education);
					Date dateCheckIn = student.getDate(_date_checkin);
					Date dateCheckOut = student.getDate(_date_checkout);


					StudentRecord stRecord = std.getOrDefault(idStudent, new StudentRecord());
					stRecord.setId(new BigDecimal(idStudent));
					stRecord.setName(name);
					stRecord.setSurname(surname);
					stRecord.setSecondName(secondName);
					stRecord.setFormEducation(form_education);
					stRecord.setDateCheckin(getSqlDate(dateCheckIn));
					stRecord.setDateCheckout(getSqlDate(dateCheckOut));
					stRecord.setCreationDate(getTimestamp(curDateCreate));
					stRecord.setUpdationDate(getTimestamp(curDateUpdate));

					onlyStudent.add(stRecord);


				}

				if (curDateRecursion.after(dateLastUpdate)) {
					for (Document event : student.getList(_event, Document.class)) {
						long idEvent = student.getInteger(_id);
						curDateUpdate = student.getDate(_date_update);
						curDateCreate = student.getDate(_date_create);


						if (curDateCreate.after(dateLastUpdate) || curDateUpdate.after(dateLastUpdate)) {
							String event_type = event.getString(_event_type);
							Date date = event.getDate(_date);


							EventsRecord eRecord = new EventsRecord();
							eRecord.setId(idEvent);
							eRecord.setStudentId(idStudent);
							eRecord.setDatetime(getTimestamp(date));
							eRecord.setDateCreate(getTimestamp(curDateCreate));
							eRecord.setDateUpdate(getTimestamp(curDateUpdate));
							eRecord.setEventTypeId(getEventType(event_type));


							if (curDateCreate.after(dateLastUpdate))
								lastToInsert.add(eRecord);
							else
								lastToUpdate.add(eRecord);


						}
					}
				}
			}

		} finally {
			cursor.close();
		}

		if (!onlyStudent.isEmpty()) {
			compareConflict(onlyStudent, toInsert, toUpdate);
		}

		if (!toInsert.isEmpty()) {
			contextOracle.batchInsert(toInsert).execute();
			contextOracle.batchInsert(lastToInsert).execute();

		}
		if (!toUpdate.isEmpty()) {
			contextOracle.batchUpdate(toUpdate).execute();
			contextOracle.batchInsert(lastToUpdate).execute();
		}

		contextOracle
				.insertInto(SYNC_LOG, SYNC_LOG.DB_TYPE, SYNC_LOG.TIMESTAMP)
				.values(numberDB, getCurrentTimestamp())
				.execute();


	}

	private void compareConflict(List<StudentRecord> onlyStudent,
	                             List<TableRecord<?>> toInsert,
	                             List<UpdatableRecord<?>> toUpdate) {
		Map<BigDecimal, StudentRecord> mapStudents = new HashMap<>();
		List<BigDecimal> ids = onlyStudent.stream().map(x -> {
			mapStudents.put(x.getId(), x);
			return x.getId();
		}).collect(Collectors.toList());
		Result<StudentRecord> oldStudents = contextOracle.selectFrom(STUDENT).where(STUDENT.ID.in(ids)).fetch();

		StudentRecord newStudent;
		for (StudentRecord oldStudent : oldStudents) {
			newStudent = mapStudents.get(oldStudent.getId());

			if (oldStudent.getDateCheckin() != newStudent.getDateCheckin())
				oldStudent.setDateCheckin(newStudent.getDateCheckin());

			if (oldStudent.getDateCheckout() != newStudent.getDateCheckout())
				oldStudent.setDateCheckout(newStudent.getDateCheckout());

			oldStudent.setRoomId(newStudent.getRoomId());


			if (newStudent.getUpdationDate().after(oldStudent.getUpdationDate())) {
				oldStudent.setName(newStudent.getName());
				oldStudent.setSecondName(newStudent.getSecondName());
				oldStudent.setSurname(newStudent.getSurname());
				oldStudent.setFormEducation(newStudent.getFormEducation());
			} else {
				oldStudent.setUpdationDate(newStudent.getUpdationDate());
			}
			mapStudents.remove(oldStudent.getId());
			toUpdate.add(oldStudent);
		}


		for (Map.Entry<BigDecimal, StudentRecord> entry : mapStudents.entrySet()) {
			toInsert.add(entry.getValue());
		}
	}


	public Long getEventType(String event_type) {
		if (eventTypeMap.isEmpty())
			setupEventTypeMap();
		Long id = eventTypeMap.get(event_type);
		if (id == null)
			id = addEventType(event_type);
		return id;
	}

	private Long addEventType(String event_type) {
		Record res = contextOracle.selectFrom(EVENT_TYPE).where(EVENT_TYPE.NAME.eq(event_type)).fetchOne();
		Long id;
		if (res != null) {
			id = res.getValue(EVENT_TYPE.ID);
			eventTypeMap.put(event_type, id);
		} else {

			EventTypeRecord record = new EventTypeRecord();
			record.setName(event_type);
			Timestamp t = getCurrentTimestamp();
			record.setDateCreate(t);
			record.setDateUpdate(t);

			Record1<Long> rr = contextOracle.select(max(EVENT_TYPE.ID)).from(EVENT_TYPE).fetchOne();

			if (rr.value1() == null) {
				id = 1L;
			} else {
				id = rr.value1() + 1;
			}
			record.setId(id);

			contextOracle.insertInto(EVENT_TYPE).set(record).execute();

			eventTypeMap.put(event_type, id);
		}
		return id;
	}

	private void setupEventTypeMap() {
		Result<EventTypeRecord> list = contextOracle.selectFrom(EVENT_TYPE).fetch();
		for (EventTypeRecord record : list) {
			eventTypeMap.put(
					record.getName(),
					record.getId());
		}
	}


	private Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}
