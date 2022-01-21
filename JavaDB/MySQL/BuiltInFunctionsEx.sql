#Ex.1
SELECT first_name, last_name from employees
WHERE first_name LIKE 'Sa%';

#Ex.2
SELECT first_name, last_name from employees
WHERE last_name LIKE '%ei%';

#Ex.3
SELECT first_name FROM employees
WHERE department_id IN (3, 10) AND YEAR(hire_date) BETWEEN 1995 AND 2005;

#Ex.4
SELECT first_name, last_name FROM employees
WHERE job_title NOT LIKE '%engineer%';

#Ex.5
SELECT name FROM towns
WHERE LENGTH(name) IN (5, 6)
ORDER BY name;

#Ex.6
SELECT * FROM towns
WHERE name LIKE 'M%' OR name LIKE 'K%' OR name LIKE 'B%' OR name LIKE 'E%'
ORDER BY name;

#Ex.7
SELECT * FROM towns
WHERE name NOT LIKE 'R%' AND name NOT LIKE 'B%' AND name NOT LIKE 'D%'
ORDER BY name;

#Ex.8
CREATE VIEW v_employees_hired_after_2000 AS
SELECT first_name, last_name FROM employees
WHERE YEAR(hire_date) > 2000;

#Ex.9
SELECT first_name, last_name FROM employees
WHERE LENGTH(last_name) = 5;

USE geography;

#Ex.10
SELECT country_name, iso_code FROM countries
WHERE country_name LIKE '%a%a%a%'
ORDER BY iso_code;

#Ex.11
SELECT peak_name, river_name, LOWER(CONCAT(peak_name, SUBSTRING(river_name, 2))) AS 'mix' FROM peaks JOIN rivers
WHERE SUBSTRING(REVERSE(peak_name), 1, 1) = SUBSTRING(river_name, 1, 1)
ORDER BY mix;

#Ex.12
SELECT name, DATE_FORMAT(start, '%Y-%m-%d') AS start FROM games
WHERE YEAR(start) IN (2011, 2012)
ORDER BY start, name
LIMIT 50;

#Ex.13
SELECT user_name, replace(email, '%@', '') AS 'email provider' FROM users
ORDER BY 'email provider' ASC, user_name;