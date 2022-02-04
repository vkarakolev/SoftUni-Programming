#Ex.1
CREATE TABLE `mountains` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(45)
);

CREATE TABLE `peaks` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(45),
`mountain_id` INT,
CONSTRAINT `fk_peaks_mountains`
FOREIGN KEY (`mountain_id`)
REFERENCES `mountains`(`id`)
);

#Ex.2
SELECT `driver_id`, `vehicle_type`, CONCAT(`first_name`, ' ', `last_name`) AS `driver_name` 
FROM `campers` AS `c`
JOIN `vehicles` AS `v` ON `c`.`id` = `v`.`driver_id`;

#Ex.3
SELECT `starting_point`, `end_point`, `leader_id`, CONCAT(`first_name`, ' ',  `last_name`) AS `leader_name`
FROM `routes` AS `r`
JOIN `campers` AS `c` ON `r`.`leader_id` = `c`.`id`;

DROP TABLE `peaks`;
DROP TABLE `mountains`;

#Ex.4
CREATE TABLE `mountains` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(45)
);

CREATE TABLE `peaks` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(45),
`mountain_id` INT,
CONSTRAINT `fk_peaks_mountains`
FOREIGN KEY (`mountain_id`)
REFERENCES `mountains`(`id`)
ON DELETE CASCADE
);
