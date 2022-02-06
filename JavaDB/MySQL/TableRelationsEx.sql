#Ex.1
CREATE TABLE passports(
id INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
passport_number VARCHAR(8)		
)AUTO_INCREMENT = 101;

CREATE TABLE people(
person_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
first_name VARCHAR(35),
salary DECIMAL(10,2),
passport_id INT UNIQUE,
CONSTRAINT fk_people_passports
FOREIGN KEY people(passport_id)
REFERENCES passports(id)
);

INSERT INTO passports(passport_number)
VALUES ('N34FG21B'), 
('K65LO4R7'), 
('ZE657QP2');

INSERT INTO people(first_name, salary, passport_id)
VALUES ('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);