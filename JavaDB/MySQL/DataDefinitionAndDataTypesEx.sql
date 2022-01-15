CREATE SCHEMA `minions`;
USE `minions`;

CREATE TABLE `minions`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`age` INT
);

CREATE TABLE `towns`(
`town_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

ALTER TABLE `towns`
DROP PRIMARY KEY,
CHANGE COLUMN `town_id` `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY `minions`(`town_id`)
REFERENCES `towns`(`id`);

INSERT INTO `towns`(`name`) VALUES 
('Sofia'),
('Plovdiv'),
('Varna');

INSERT INTO `minions`(`name`, `age`, `town_id`) VALUES 
('Kevin', '22', 1),
('Bob', '15', 3),
('Steward', NULL, 2);

TRUNCATE TABLE `minions`;

DROP TABLE `minions`;
DROP TABLE `towns`;

