CREATE TABLE `Type_position` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Name` varchar(255) NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Participant` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Name` varchar(255) NOT NULL,
	`Surname` varchar(255) NOT NULL,
	`Secondname` varchar(255) NOT NULL,
	`position_id` int NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Conference` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Name` varchar(255) NOT NULL,
	`Venue` varchar(255) NOT NULL,
	`date_conference` DATE NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Publications` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Title_edition` varchar(255) NOT NULL,
	`Language_publication` varchar(255) NOT NULL,
	`Volume_edition` varchar(255) NOT NULL,
	`Place_editon` varchar(255) NOT NULL,
	`edition_id` int NOT NULL,
	`Co_authors` varchar(255) NOT NULL,
	`Citation_index` FLOAT NOT NULL,
	`Data_publication` DATE NOT NULL,
	`participant_id` int NOT NULL,
	`id_type_publication` int NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Type_edition` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Name` varchar(255) NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Type_publication` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Name` varchar(255) NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Scientific_project` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Name` varchar(255) NOT NULL,
	`Period_participation` varchar(255) NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Reader_sheet` (
	`id` int NOT NULL AUTO_INCREMENT,
	`participant_id` int NOT NULL,
	`Title_book` varchar(255) NOT NULL,
	`Date_take` DATE NOT NULL,
	`Date_put` DATE NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `List_participant` (
	`participant_id` int NOT NULL,
	`conference_id` int NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL
);

CREATE TABLE `List_participant_project` (
	`participant_id` int NOT NULL,
	`project_id` int NOT NULL,
	`data_update` DATETIME NOT NULL,
	`data_create` DATETIME NOT NULL
);

ALTER TABLE `Participant` ADD CONSTRAINT `Participant_fk0` FOREIGN KEY (`position_id`) REFERENCES `Type_position`(`id`);

ALTER TABLE `Publications` ADD CONSTRAINT `Publications_fk0` FOREIGN KEY (`edition_id`) REFERENCES `Type_edition`(`id`);

ALTER TABLE `Publications` ADD CONSTRAINT `Publications_fk1` FOREIGN KEY (`participant_id`) REFERENCES `Participant`(`id`);

ALTER TABLE `Publications` ADD CONSTRAINT `Publications_fk2` FOREIGN KEY (`id_type_publication`) REFERENCES `Type_publication`(`id`);

ALTER TABLE `Reader_sheet` ADD CONSTRAINT `Reader_sheet_fk0` FOREIGN KEY (`participant_id`) REFERENCES `Participant`(`id`);

ALTER TABLE `List_participant` ADD CONSTRAINT `List_participant_fk0` FOREIGN KEY (`participant_id`) REFERENCES `Participant`(`id`);

ALTER TABLE `List_participant` ADD CONSTRAINT `List_participant_fk1` FOREIGN KEY (`conference_id`) REFERENCES `Conference`(`id`);

ALTER TABLE `List_participant_project` ADD CONSTRAINT `List_participant_project_fk0` FOREIGN KEY (`participant_id`) REFERENCES `Participant`(`id`);

ALTER TABLE `List_participant_project` ADD CONSTRAINT `List_participant_project_fk1` FOREIGN KEY (`project_id`) REFERENCES `Scientific_project`(`id`);



INSERT INTO `type_position` VALUES (1,'Доцент','2019-02-26 10:27:33','2019-02-26 10:27:29'),(2,'Бакалавр','2019-02-26 10:27:35','2019-02-26 10:27:30'),(3,'Магистр','2019-02-26 10:27:36','2019-02-26 10:27:31');

INSERT INTO `participant` VALUES (1,'Иван','Иванович','Иванов',1,'2019-02-26 10:23:09','2019-02-26 10:23:01'),(2,'Константин','Валерьевич ','Степанов',3,'2019-02-26 10:23:09','2019-02-26 10:23:03'),(3,'Дмитрий ','Владиславович','Зимин',2,'2019-02-26 10:23:11','2019-02-26 10:23:05'),(4,'Анатолий ','Константинович','Барсуков',1,'2019-02-26 10:23:12','2019-02-26 10:23:06'),(5,'Виктор','Анатольевич','Дубровский',2,'2019-02-26 10:23:13','2019-02-26 10:23:07');

INSERT INTO `conference` VALUES (1,'Международная научная конференция “Высокие технологии и инновации в науке”','Санкт-Петербург','2019-03-23','2019-02-26 13:12:24','2019-02-26 13:12:24'),(2,'Конференция “НАУЧНЫЕ ОСНОВЫ ИННОВАЦИОННОЙ ЭКОНОМИКИ”','Санкт-Петербург','2019-02-26','2019-02-26 13:12:53','2019-02-26 13:12:39');

INSERT INTO `list_participant` VALUES (1,1,'2019-02-26 10:19:15','2019-02-26 10:19:08'),(2,2,'2019-02-26 10:19:16','2019-02-26 10:19:09'),(3,1,'2019-02-26 10:19:17','2019-02-26 10:19:11'),(4,2,'2019-02-26 10:19:19','2019-02-26 10:19:12'),(5,2,'2019-02-26 10:19:20','2019-02-26 10:19:13');

INSERT INTO `reader_sheet` VALUES (1,1,'Букварь','2019-02-03','2019-02-14','2019-02-26 10:25:13','2019-02-26 10:24:58'),(2,2,'Сказки ','2019-02-02','2019-02-16','2019-02-26 10:25:14','2019-02-26 10:25:02'),(3,3,'Арифметика','2019-02-07','2019-02-28','2019-02-26 10:25:15','2019-02-26 10:25:10'),(4,4,'Базы данных ','2019-02-08','2019-02-22','2019-02-26 10:25:16','2019-02-26 10:25:10'),(5,5,'java','2019-02-09','2019-02-21','2019-02-26 10:25:17','2019-02-26 10:25:12');

INSERT INTO `scientific_project` VALUES (1,'Исследование движения астероидов ','3 месяца','2019-02-26 10:26:08','2019-02-26 10:26:04'),(2,'Разработка програмно-аппаратного средства для автоматического распознования эмоций человека','6 месяцев','2019-02-26 10:26:09','2019-02-26 10:26:06');

INSERT INTO `list_participant_project` VALUES (1,1,'2019-02-26 10:21:53','2019-02-26 10:21:44'),(2,1,'2019-02-26 10:21:57','2019-02-26 10:21:46'),(3,2,'2019-02-26 10:21:58','2019-02-26 10:21:48'),(4,2,'2019-02-26 10:22:00','2019-02-26 10:21:50'),(5,2,'2019-02-26 10:22:01','2019-02-26 10:21:51');

INSERT INTO `type_edition` VALUES (1,'ВАК','2019-02-26 10:26:59','2019-02-26 10:26:56'),(2,'РИНЦ','2019-02-26 10:27:00','2019-02-26 10:26:58');

INSERT INTO `type_publication` VALUES (1,'Статья','2019-02-26 10:28:18','2019-02-26 10:28:14'),(2,'Тезисы','2019-02-26 10:28:19','2019-02-26 10:28:16');

INSERT INTO `publications` VALUES (1,' Голографический фотоотверждаемый нанокомпозит и оптические элементы на его основе','Русский','5 листов','Санкт-Петербург',2,'-',3,'2018-02-09',1,1,'2019-02-26 10:24:04','2019-02-26 10:24:01'),(2,' Исследование структуры сингулярных пучков с полуцелыми топологическими зарядами в оптически неоднородных и анизотропных средах','Русский','7 листов','Санкт-Петербург',1,'-',2,'2018-04-19',2,2,'2019-02-26 10:24:06','2019-02-26 10:24:03');