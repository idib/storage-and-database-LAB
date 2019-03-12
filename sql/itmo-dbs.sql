CREATE TABLE student (
	id numeric PRIMARY KEY,
	FIO varchar (255) NOT NULL,
	university varchar (255),
	education_form varchar (255),
	education_place varchar (255),
	speciality varchar(255),
	semester numeric,
	creation_date timestamp,
	updation_date timestamp
);

CREATE TABLE teacher (
	id numeric PRIMARY KEY,
	FIO varchar (255) NOT NULL,
	creation_date timestamp,
	updation_date timestamp
);

CREATE TABLE discipline (
	discipline_id numeric PRIMARY KEY,
	discipline_name varchar(255),
	lections_hours numeric,
	practicals_hours numeric,
	labs_houes numeric,
	education_standart_type varchar(255),
	creation_date timestamp,
	updation_date timestamp
);

CREATE TABLE results (
	student_id numeric REFERENCES student(id),
	discipline_id numeric REFERENCES discipline(discipline_id),
	control_form varchar(255),
	result float,
	result_date date,
	teacher_id numeric REFERENCES teacher(id),
	creation_date timestamp,
	updation_date timestamp
);


