/*
SELECT *
FROM pg_catalog.pg_tables
WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema'
*/


CREATE DATABASE test;

--use test;
--
--CREATE TABLE `student` (
--  `id` bigint(11) NOT NULL AUTO_INCREMENT,
--  `name` varchar(255) NOT NULL,
--  `age` smallint NOT NULL,
--  `desc` text COMMENT 'blah blah.....',
--  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
--select CURRENT_TIMESTAMP, CURRENT_TIMESTAMP(3),CURRENT_TIMESTAMP(1), CURRENT_TIMESTAMP(2), CURRENT_TIMESTAMP(4);
--
--CREATE TABLE `instructor` (
--  `id` bigint(11) NOT NULL AUTO_INCREMENT,
--  `name` varchar(255) NOT NULL,
--  `left` boolean DEFAULT FALSE,
--  `desc` text COMMENT 'blah blah.....',
--  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
--CREATE TABLE `lecture_course` (
--  `id` bigint(11) NOT NULL AUTO_INCREMENT,
--  `title` varchar(255) NOT NULL,
--  `instructor_id` bigint(11) NOT NULL,
--  `name` varchar(255) NOT NULL,
--  `from` datetime DEFAULT CURRENT_TIMESTAMP,
--  `to` datetime DEFAULT CURRENT_TIMESTAMP,
--  `desc` text COMMENT 'blah blah.....',
--  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
--  `updated_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
--CREATE TABLE `lecture_applicants` (
--  `id` bigint(11) NOT NULL AUTO_INCREMENT,
--  `title` varchar(255) NOT NULL,
--  `instructor_id` bigint(11) NOT NULL,
--  `name` varchar(255) NOT NULL,
--  `from` datetime DEFAULT CURRENT_TIMESTAMP,
--  `to` datetime DEFAULT CURRENT_TIMESTAMP,
--  `desc` text COMMENT 'blah blah.....',
--  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
--  `updated_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
--CREATE TABLE `attendance` (
--  `id` bigint(11) NOT NULL AUTO_INCREMENT,
--  `lecture_course_id` bigint(11) NOT NULL,
--  `student_id` bigint(11) NOT NULL,
--  `created_at` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
