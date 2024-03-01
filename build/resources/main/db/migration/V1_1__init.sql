use test;

DROP TABLE  if exists student;
CREATE TABLE `student` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` smallint NOT NULL,
  `desc` text COMMENT 'blah blah.....',
  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

select CURRENT_TIMESTAMP, CURRENT_TIMESTAMP(3),CURRENT_TIMESTAMP(1), CURRENT_TIMESTAMP(2), CURRENT_TIMESTAMP(4);

DROP TABLE  if exists instructor;
CREATE TABLE `instructor` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `left` boolean DEFAULT FALSE,
  `desc` text COMMENT 'blah blah.....',
  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE  if exists lecture_course;
CREATE TABLE `lecture_course` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `instructor_id` bigint(11) NOT NULL,
  `from` datetime DEFAULT CURRENT_TIMESTAMP,
  `to` datetime DEFAULT CURRENT_TIMESTAMP,
  `desc` text COMMENT 'blah blah.....',
  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `updated_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`)
);

DROP TABLE if exists lecture_applicants;
CREATE TABLE `lecture_applicants` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `lecture_course_id` bigint(11) NOT NULL ,
  `student_id` bigint(11) NOT NULL,
  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `updated_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`)
);

DROP TABLE if exists attendance;
CREATE TABLE `attendance` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `lecture_course_id` bigint(11) NOT NULL,
  `student_id` bigint(11) NOT NULL,
  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`)
);

ALTER TABLE lecture_course ADD COLUMN capacity smallint NOT NULL DEFAULT 50 AFTER `instructor_id`;

insert into student(name, age, created_at) values ('김철수', 25, now());
insert into instructor(name, created_at) values ('김강사', now());
insert into lecture_course(title, instructor_id, capacity, `from`, `to`) values ('java', 1, 70, '2024-03-05', '2024-03-08');
insert into lecture_applicants(lecture_course_id, student_id) values(1,1);