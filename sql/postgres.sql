CREATE OR REPLACE FUNCTION trigger_set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TABLE SRC_PGS_SUDENT (
	id numeric PRIMARY KEY,
	FIO varchar (255) NOT NULL,
	university varchar (255),
	education_form varchar (255),
	education_place varchar (255),
	speciality varchar(255),
	semester numeric,
	created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
	updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW());

CREATE TABLE SRC_PGS_TEACHER (
	id numeric PRIMARY KEY,
	FIO varchar (255) NOT NULL,
	created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
	updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW());

CREATE TABLE SRC_PGS_DISCIPLINE (
	discipline_id numeric PRIMARY KEY,
	discipline_name varchar(255),
	lections_hours numeric,
	practicals_hours numeric,
	labs_houes numeric,
	education_standart_type varchar(255),
	created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
	updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW());

CREATE TABLE SRC_PGS_RESULTS (
	student_id numeric REFERENCES SRC_PGS_SUDENT(id),
	discipline_id numeric REFERENCES SRC_PGS_DISCIPLINE(discipline_id),
	control_form varchar(255),
	result float,
	result_date date,
	teacher_id numeric REFERENCES SRC_PGS_TEACHER(id),
	created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
	updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW());

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON SRC_PGS_SUDENT
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON SRC_PGS_TEACHER
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON SRC_PGS_DISCIPLINE
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TRIGGER SRC_PGS_RESULTS
BEFORE UPDATE ON SRC_PGS_RESULTS
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();