CREATE TABLE "dormitory" (
	"id" serial NOT NULL,
	"name" TEXT NOT NULL,
	"address" TEXT NOT NULL,
	"date_update" TIMESTAMP NOT NULL,
	"date_create" TIMESTAMP NOT NULL,
	CONSTRAINT dormitory_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "block" (
	"id" serial NOT NULL,
	"floor" integer NOT NULL,
	"date_disinsection" DATE NOT NULL,
	"dorm_id" integer NOT NULL,
	"date_update" TIMESTAMP NOT NULL,
	"date_create" TIMESTAMP NOT NULL,
	CONSTRAINT block_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "room" (
	"id" serial NOT NULL,
	"number" VARCHAR(255) NOT NULL,
	"max_student" integer NOT NULL,
	"block_id" integer NOT NULL,
	"date_update" TIMESTAMP NOT NULL,
	"date_create" TIMESTAMP NOT NULL,
	CONSTRAINT room_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "student" (
	"id" serial NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	"surname" VARCHAR(255) NOT NULL,
	"second_name" VARCHAR(255) NOT NULL,
	"room_id" integer NOT NULL,
	"concession" BINARY NOT NULL,
	"form_education" integer NOT NULL,
	"date_checkin" DATE NOT NULL,
	"date_checkout" DATE NOT NULL,
	"date_update" TIMESTAMP NOT NULL,
	"date_create" TIMESTAMP NOT NULL,
	CONSTRAINT student_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "form_education" (
	"id" serial NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	"date_update" TIMESTAMP NOT NULL,
	"date_create" TIMESTAMP NOT NULL,
	CONSTRAINT form_education_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "events" (
	"id" serial NOT NULL,
	"student_id" integer NOT NULL,
	"event_type_id" integer NOT NULL,
	"datetime" TIMESTAMP NOT NULL,
	"date_update" TIMESTAMP NOT NULL,
	"date_create" TIMESTAMP NOT NULL,
	CONSTRAINT events_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "event_type" (
	"id" serial NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	"date_update" TIMESTAMP NOT NULL,
	"date_create" TIMESTAMP NOT NULL,
	CONSTRAINT event_type_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "block" ADD CONSTRAINT "block_fk0" FOREIGN KEY ("dorm_id") REFERENCES "dormitory"("id");

ALTER TABLE "room" ADD CONSTRAINT "room_fk0" FOREIGN KEY ("block_id") REFERENCES "block"("id");

ALTER TABLE "student" ADD CONSTRAINT "student_fk0" FOREIGN KEY ("room_id") REFERENCES "room"("id");
ALTER TABLE "student" ADD CONSTRAINT "student_fk1" FOREIGN KEY ("form_education") REFERENCES "form_education"("id");


ALTER TABLE "events" ADD CONSTRAINT "events_fk0" FOREIGN KEY ("student_id") REFERENCES "student"("id");
ALTER TABLE "events" ADD CONSTRAINT "events_fk1" FOREIGN KEY ("event_type_id") REFERENCES "event_type"("id");


