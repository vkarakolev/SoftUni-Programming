#Ex.1
SELECT id, first_name, last_name, job_title FROM `employees` ORDER BY id ASC;

#Ex.2
SELECT id, CONCAT(first_name, ' ', last_name) AS 'full_name', job_title, salary FROM employees
WHERE salary > 1000
ORDER BY id ASC;

#Ex.3
UPDATE employees
SET salary = salary + 100
WHERE job_title = 'manager';

SELECT salary FROM employees;

#Ex.4
CREATE VIEW `v_top_paid_employee` AS
SELECT * FROM employees
ORDER BY salary DESC
LIMIT 1;

SELECT * FROM v_top_paid_employee;

#Ex.5
SELECT * FROM employees
WHERE department_id = 4 AND salary >= 1000
ORDER BY id ASC;

#Ex.6
DELETE FROM employees
WHERE department_id IN (1, 2);

SELECT * FROM employees
ORDER BY id ASC;