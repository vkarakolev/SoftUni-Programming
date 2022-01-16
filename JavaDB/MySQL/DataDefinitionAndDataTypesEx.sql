#Ex.1
CREATE SCHEMA `minions`;
USE `minions`;

#Ex.2
CREATE TABLE `minions`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`age` INT
);

CREATE TABLE `towns`(
`town_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

#Ex.3
ALTER TABLE `towns`
DROP PRIMARY KEY,
CHANGE COLUMN `town_id` `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY `minions`(`town_id`)
REFERENCES `towns`(`id`);

#Ex.4
INSERT INTO `towns`(`name`) VALUES 
('Sofia'),
('Plovdiv'),
('Varna');

INSERT INTO `minions`(`name`, `age`, `town_id`) VALUES 
('Kevin', '22', 1),
('Bob', '15', 3),
('Steward', NULL, 2);

#Ex. 5
TRUNCATE TABLE `minions`;

#Ex.6
DROP TABLE `minions`;
DROP TABLE `towns`;

#Ex.7
CREATE TABLE `people`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB DEFAULT NULL,
`height` DOUBLE(3, 2),
`weigth` DOUBLE(5, 2),
`gender` CHAR,
`birthdate` DATE NOT NULL,
`biography` TEXT DEFAULT NULL
);

INSERT INTO `people` (`name`, `picture`, `height`, `weigth`, `gender`, `birthdate`, `biography`) VALUES
('Pesho', null, 1.60, 70, 'm', '1995-05-05', null),
('Maria', null, 1.80, 45, 'f', '1989-07-07', 'asdasdasd'),
('Ziko', null, 1.60, 70, 'm', '1994-03-14', null),
('Petq', null, 1.90, 50, 'f', '1995-10-05', 'qweqwrqw'),
('Gosho', null, 1.50, 80, 'm', '1997-12-18', null);

#Ex.8
CREATE TABLE `users`(
`id` BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`username` CHAR(30) UNIQUE, 
`password` 	CHAR(26),
`profile_picture` MEDIUMBLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users`(`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`) VALUES
('petur123', 'pesho', null, '16:30:00', false),
('petur12', 'pesho', null, '16:30:00', false),
('petur1', 'pesho', null, '16:30:00', false),
('petur1234', 'pesho', null, '16:30:00', false),
('petur12345', 'pesho', null, '16:30:00', false);

#Ex.9
ALTER TABLE `users` 
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY (`id`, `username`);

#Ex.10
ALTER TABLE `users`
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME DEFAULT NOW();

#Ex.11
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY (`id`),
CHANGE COLUMN `username` `username` CHAR(30) UNIQUE;

#Ex.12
CREATE SCHEMA `movies`;
USE `movies`;

CREATE TABLE `directors` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`director_name` VARCHAR(50) NOT NULL, 
`notes` VARCHAR(200)
);

CREATE TABLE `genres` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`genre_name` VARCHAR(50) NOT NULL, 
`notes` VARCHAR(200)
);

CREATE TABLE `categories` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`category_name` VARCHAR(50) NOT NULL, 
`notes` VARCHAR(200)
);

CREATE TABLE `movies` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`title` VARCHAR(50) NOT NULL, 
`director_id` INT NOT NULL ,
`copyright_year` DATE,
`length` TIME,
`genre_id` INT NOT NULL,
`category_id` INT NOT NULL,
`rating` DOUBLE(2, 1),
`notes` VARCHAR(200)
);

ALTER TABLE `movies`
ADD CONSTRAINT `fk_movies_directors`
FOREIGN KEY `movies`(`director_id`)
REFERENCES `directors`(`id`),
ADD CONSTRAINT `fk_movies_genres`
FOREIGN KEY `movies`(`genre_id`)
REFERENCES `genres`(`id`),
ADD CONSTRAINT `fk_movies_categories`
FOREIGN KEY `movies` (`category_id`)
REFERENCES `categories`(`id`);

INSERT INTO `directors`(`director_name`, `notes`) VALUES
('Director 1', null),
('Director 2', null),
('Director 3', null),
('Director 4', null),
('Director 5', null);

INSERT INTO `genres`(`genre_name`, `notes`) VALUES
('Action', null),
('Fantasy', null),
('Thriller', null),
('Drama', null),
('Psycho', null);

INSERT INTO `categories`(`category_name`, `notes`) VALUES
('Category 1', null),
('Category 2', null),
('Category 3', null),
('Category 4', null),
('Category 5', null);

INSERT INTO `movies`(`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`) 
VALUES
('Title 1', 1, null, null, 1, 1, 8.9, null),
('Title 2', 3, null, null, 2, 3, 6.9, null),
('Title 3', 4, null, null, 3, 5, 8.3, null),
('Title 4', 3, null, null, 5, 2, 7.9, null),
('Title 5', 5, null, null, 4, 4, 9.9, null);

#Ex.13
CREATE SCHEMA `car_rental`;
USE `car_rental`;	

CREATE TABLE `categories`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`category` VARCHAR(50) NOT NULL, 
`daily_rate` DOUBLE, 
`weekly_rate` DOUBLE, 
`monthly_rate` DOUBLE, 
`weekend_rate` DOUBLE
);

INSERT INTO `categories`
(`category`) VALUES
('van'),
('car'),
('bus');


CREATE TABLE `cars`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`plate_number` VARCHAR(10) NOT NULL UNIQUE, 
`make` VARCHAR(30), 
`model`VARCHAR(30), 
`car_year` YEAR, 
`category_id` INT NOT NULL, 
`doors` INT, 
`picture` BLOB DEFAULT NULL, 
`car_condition` TEXT,
`available` BOOLEAN,
CONSTRAINT `fk_cars_categories`
FOREIGN KEY `cars`(`category_id`) REFERENCES `categories`(`id`)
);

INSERT INTO `cars`(`plate_number`, `category_id`) VALUES
('666666', '2'),
('111111', '3'),
('222222', '1');

CREATE TABLE `employees`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`first_name` VARCHAR(30), 
`last_name` VARCHAR(30), 
`title` VARCHAR(30), 
`notes` TEXT
);

INSERT INTO `employees`(`title`) VALUES
('driver'),
('cashier'),
('guard');

CREATE TABLE `customers`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`driver_licence_number` INT, 
`full_name` VARCHAR(50), 
`address` VARCHAR(100), 
`city` VARCHAR(50), 
`zip_code` INT, 
`notes` TEXT
);

INSERT INTO `customers`(`driver_licence_number`) VALUES
('123123'),
('123321'),
('123154');

CREATE TABLE `rental_orders`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`employee_id` INT NOT NULL, 
`customer_id` INT NOT NULL, 
`car_id` INT NOT NULL, 
`car_condition` TEXT, 
`tank_level` DOUBLE,
`kilometrage_start` INT, 
`kilometrage_end` INT, 
`total_kilometrage` INT, 
`start_date` DATETIME, 
`end_date` DATETIME,
`total_days` INT, 
`rate_applied` DOUBLE, 
`tax_rate` DOUBLE, 
`order_status` BOOLEAN, 
`notes` TEXT,
CONSTRAINT `fk_rental_orders_employees`
FOREIGN KEY `rental_oreders`(`employee_id`) REFERENCES `employees`(`id`),
CONSTRAINT `fk_rental_orders_customers`
FOREIGN KEY `rental_oreders`(`customer_id`) REFERENCES `customers`(`id`),
CONSTRAINT `fk_rental_orders_cars`
FOREIGN KEY `rental_oreders`(`car_id`) REFERENCES `cars`(`id`)
);

INSERT INTO `rental_orders`(`employee_id`, `customer_id`, `car_id`) VALUES
(1, 2, 3),
(2, 3, 1),
(3, 2, 1);

