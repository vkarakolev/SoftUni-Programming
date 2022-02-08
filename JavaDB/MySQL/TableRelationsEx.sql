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

#Ex.2
CREATE TABLE manufacturers(
manufacturer_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(35),
established_on DATE
);

CREATE TABLE models(
model_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(35),
manufacturer_id INT,
CONSTRAINT fk_models_manufacturers
FOREIGN KEY models(manufacturer_id)
REFERENCES manufacturers(manufacturer_id)
)AUTO_INCREMENT = 101;

INSERT INTO manufacturers(name, established_on)
VALUES ('BMW', '1916/03/01'),
('Tesla', '2003/01/01'),
('Lada', '1966/05/01');

INSERT INTO models(name, manufacturer_id)
VALUES ('X1', '1'),
('i6', '1'),
('Model S', '2'),
('Model X', '2'),
('Model 3', '2'),
('Nova', '3');

#Ex.3
CREATE TABLE students(
student_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50)
);

CREATE TABLE exams(
exam_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50)
)AUTO_INCREMENT = 101;

CREATE TABLE students_exams(
student_id INT,
exam_id INT,
CONSTRAINT pk_students_exams
PRIMARY KEY (student_id, exam_id)
);

ALTER TABLE students_exams
ADD CONSTRAINT fk_students_students_exams
FOREIGN KEY students_exams(student_id)
REFERENCES students(student_id);

ALTER TABLE students_exams
ADD CONSTRAINT fk_exams_students_exams
FOREIGN KEY students_exams(exam_id)
REFERENCES exams(exam_id);

INSERT INTO students(name)
VALUES('Mila'),
('Toni'),
('Ron');

INSERT INTO exams (name)
VALUES('Spring MVC'),
('Neo4j'),
('Oracle 11g');

INSERT INTO students_exams(student_id, exam_id)
VALUES(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

#Ex.4
CREATE TABLE teachers(
teacher_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
manager_id INT
)AUTO_INCREMENT = 101;

INSERT INTO teachers(name, manager_id)
VALUES('John', null),
('Maya', 106),
('Silvia', 106),
('Ted', 105),
('Mark', 101),
('Greta', 101);

ALTER TABLE teachers
ADD CONSTRAINT fk_teachers_teacher_id_manager_id
FOREIGN KEY teachers(manager_id)
REFERENCES teachers(teacher_id);

#Ex.5
CREATE TABLE item_types(
item_type_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50)
);

CREATE TABLE items(
item_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
item_type_id INT(11),
CONSTRAINT fk_items_item_types
FOREIGN KEY (item_type_id)
REFERENCES item_types(item_type_id)
);

CREATE TABLE cities(
city_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50)
);

CREATE TABLE customers(
customer_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
birthday DATE,
city_id INT(11),
CONSTRAINT fk_customers_cities
FOREIGN KEY (city_id)
REFERENCES cities(city_id)
);

CREATE TABLE orders(
order_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
customer_id INT(11),
CONSTRAINT fk_orders_customers
FOREIGN KEY (customer_id)
REFERENCES customers(customer_id)
);

CREATE TABLE order_items(
order_id INT(11) NOT NULL UNIQUE,
item_id INT(11) NOT NULL UNIQUE,
CONSTRAINT pk_order_items
PRIMARY KEY (order_id, item_id)
);