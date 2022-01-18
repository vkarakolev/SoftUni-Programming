#Ex.1
SELECT * FROM departments;

#Ex.2
SELECT name FROM departments;

#Ex.3
SELECT first_name, last_name, salary FROM employees;

#Ex.4
SELECT first_name, middle_name, last_name FROM employees;

#Ex.5
SELECT CONCAT(first_name, '.', last_name, '@softuni.bg') AS `full_email_address` FROM employees;

#Ex.6
SELECT DISTINCT salary FROM employees;

#Ex.7
SELECT * FROM employees
WHERE job_title = 'Sales Representative';

#Ex.8
SELECT first_name, last_name, job_title FROM employees
WHERE salary BETWEEN 20000 AND 30000;

#Ex.9
SELECT CONCAT_WS(' ', first_name, middle_name, last_name) AS 'Full Name' FROM employees
WHERE salary = 25000 OR salary = 14000 OR salary = 12500 OR salary = 23600;

#Ex.10
SELECT first_name, last_name FROM employees
WHERE manager_id IS NULL;

#Ex.11
SELECT first_name, last_name, salary FROM employees
WHERE salary > 50000
ORDER BY salary DESC;

#Ex.12
SELECT first_name, last_name FROM employees
ORDER BY salary DESC
LIMIT 5;

#Ex.13
SELECT first_name, last_name FROM employees
WHERE department_id != 4;

#Ex.14
SELECT * FROM employees
ORDER BY salary DESC, first_name ASC, last_name DESC, middle_name ASC, employee_id ASC;

#Ex.15
CREATE VIEW `v_employees_salaries` AS
SELECT first_name, last_name, salary FROM employees;

#Ex.16
CREATE VIEW `v_employees_job_titles` AS
SELECT CONCAT_WS(' ', first_name, middle_name, last_name) AS `full_name`, job_title FROM employees;

#Ex.17
SELECT DISTINCT job_title FROM employees
ORDER BY job_title;

#Ex.18
SELECT * FROM projects
ORDER BY start_date ASC, name ASC
LIMIT 10;

#Ex.19
SELECT first_name, last_name, hire_date FROM employees
ORDER BY hire_date DESC
LIMIT 7;

#Ex.20
UPDATE employees
SET salary = salary * 1.12
WHERE department_id IN (1, 2, 4, 11);

SELECT salary FROM employees;

#Ex.21
SELECT peak_name FROM peaks
ORDER BY peak_name;

#EX.22
SELECT country_name, population FROM countries
WHERE continent_code = 'EU'
ORDER BY population DESC, country_name ASC
LIMIT 30;

#Ex.23
SELECT country_name, country_code, IF(currency_code = 'EUR', 'Euro', 'Not Euro') AS currency FROM countries
ORDER BY country_name;