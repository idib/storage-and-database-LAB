package com.SADB;

import com.SADB.Entities.Exampe.tables.Car;
import com.SADB.Entities.Exampe.tables.records.CarRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.SADB.Entities.Exampe.Tables.CAR;


public class ExampleMain {


	public static void main(final String[] args) {
		String userName = "postgres";
		String password = "1234";
		String url = "jdbc:postgresql://localhost:5432/wst";
		String url1 = "jdbc:postgresql://localhost:5432/test1";

		// конектимся к бд 1
		try (Connection conn = DriverManager.getConnection(url, userName, password)) {

			DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
			System.out.println("connection to WST");

			// берем все записи
			Result<CarRecord> result = create.select().from(CAR).fetch().into(CAR);

			System.out.println(result);


			System.out.println(result.size());

			// пример 2 Сразу кастуем к нужному обекту
			for (CarRecord r : result) {


				System.out.println("ID: " + r.getId() + " name: " + r.getName() + " wheelbase: " + r.getWheelbase());
			}
			System.out.println(result.size());


			// конектимся к бд 2
			try (Connection conn1 = DriverManager.getConnection(url1, userName, password)) {

				DSLContext create1 = DSL.using(conn, SQLDialect.POSTGRES);
				System.out.println("connection to test1");

				//все записи из бд1 запихиваем в бд2
				create1.insertInto(CAR)
						.select(create.selectFrom(CAR));

				System.out.println("inserted");


				// берем все записиm из бд 2
				// более извращенный вывод
				Result<Record> result1 = create1.select().from(CAR).fetch();
				for (Record r : result1) {
					Long id = r.getValue(CAR.ID);
					String name = r.getValue(CAR.NAME);
					Integer wb = r.getValue(CAR.WHEELBASE);


					System.out.println("ID: " + id + " name: " + name + " wei: " + wb);
				}
				System.out.println(result1.size());




			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}