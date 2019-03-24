package com.sadb.transformation.mongo;

import com.mongodb.client.*;
import com.sadb.generated.dest.oracle.tables.records.BlockRecord;
import com.sadb.generated.dest.oracle.tables.records.DormitoryRecord;
import com.sadb.generated.dest.oracle.tables.records.RoomRecord;
import com.sadb.generated.dest.oracle.tables.records.StudentRecord;
import com.sadb.transformation.ConnectionManager;
import org.bson.Document;
import org.jooq.*;
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

@Service
public class MongoMigrationService {
	private static final String _id = "_id";
	private static final String _name = "name";
	private static final String _address = "address";
	private static final String _date_update = "date_update";
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

	public static void main(String[] args) throws ParseException {
		Connection connectionOracle = ConnectionManager.getDestDBConnection();
		DSLContext contextOracle = DSL.using(connectionOracle, SQLDialect.ORACLE);


		contextOracle.delete(ROOM).where("1=1");
		contextOracle.delete(BLOCK).where("1=1");
		contextOracle.delete(DORMITORY).where("1=1");


		MongoMigrationService m = new MongoMigrationService();
		m.process();
	}

	public Timestamp getTimestamp(java.util.Date date) {
		return date == null ? null : new java.sql.Timestamp(date.getTime());
	}

	private static java.sql.Date getSqlDate(Date uDate) {
		return new java.sql.Date(uDate.getTime());
	}

	//	@Scheduled(fixedDelayString = "#{ 60 * 1000}")
	public void process() throws ParseException {
		Connection connectionOracle = ConnectionManager.getDestDBConnection();
		DSLContext contextOracle = DSL.using(connectionOracle, SQLDialect.ORACLE);


		List<TableRecord<?>> toInsert = new ArrayList<>();
		List<UpdatableRecord<?>> toUpdate = new ArrayList<>();

		MongoClient mongoClient = MongoClients.create(mongoClientURI);

		System.out.println(mongoClientURI);

		MongoDatabase database = mongoClient.getDatabase(DBNAME);

		MongoCollection<Document> dormitories = database.getCollection("dormitory");


		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date dateLastUpdate = simpleDateFormat.parse("2019-02-25");

		MongoCursor<Document> cursor = dormitories.find().iterator();

		Date curDateUpdate;
		Date curDateCreate;
		Date curDateRecursion;
		Map<Long, StudentRecord> std = new HashMap<>();
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

				if (curDateRecursion.after(dateLastUpdate))
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

						if (curDateRecursion.after(dateLastUpdate))
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

									if (curDateRecursion.after(dateLastUpdate))
										for (Integer idStudent : room.getList(_students, Integer.class)) {

											StudentRecord studentRecord = new StudentRecord();
											studentRecord.setId(new BigDecimal(idStudent));
											studentRecord.setRoomId(idRoom);
											std.put(idStudent.longValue(), studentRecord);

										}
								}
							}
					}
			}
		} finally {
			cursor.close();
		}


		if (!toInsert.isEmpty()) {
			contextOracle.batchInsert(toInsert).execute();

		}
		if (!toUpdate.isEmpty()) {
			contextOracle.batchUpdate(toUpdate).execute();
		}


		System.out.println("finish");
	}
}
