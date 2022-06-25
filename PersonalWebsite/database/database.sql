

-- create databse
create database resumemanager;

-- use database to create table
use resumemanager;

-- create table


CREATE TABLE `resumemanager`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `personal_id` LONGBLOB NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  `age` VARCHAR(45) NULL,
  `phone_number` INT NULL,
  `email` VARCHAR(45) NULL,
  `img_src` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `resumemanager`.`userobjective` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `objective_desc` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `resumemanager`.`usereducation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `year_start` DATE NULL,
  `year_end` DATE NULL,
  `education_title` VARCHAR(45) NULL,
  `education_desc` VARCHAR(255) NULL,
  `grade` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `resumemanager`.`userexperience` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `company_name` VARCHAR(45) NULL,
  `year_start` DATE NULL,
  `year_end` DATE NULL,
  `experience_title` VARCHAR(45) NULL,
  `experience_desc` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `resumemanager`.`userawards` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `year_start` DATE NULL,
  `year_end` DATE NULL,
  `awards_desc` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `resumemanager`.`useracknowledgments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `acknowledgments_desc` VARCHAR(255) NULL,
  `year` DATE NULL,
  PRIMARY KEY (`id`));





