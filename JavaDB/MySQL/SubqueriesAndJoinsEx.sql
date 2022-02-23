#Ex.1
SELECT e.employee_id, e.job_title, a.address_id, a.address_text 
FROM employees AS e
JOIN addresses AS a 
USING (address_id)
ORDER BY address_id
LIMIT 5;

#Ex.2
SELECT e.first_name, e.last_name, t.name AS town, a.address_text 
FROM employees AS e
JOIN addresses AS a USING (address_id)
JOIN towns AS t USING (town_id)
ORDER BY first_name, last_name
LIMIT 5;

#Ex.3
SELECT e.employee_id, e.first_name, e.last_name, d.name 
FROM employees AS e
JOIN departments AS d
USING (department_id)
WHERE d.name = 'Sales'
ORDER BY employee_id DESC;

#Ex.4
SELECT e.employee_id, e.first_name, e.salary, d.name 
FROM employees AS e
JOIN departments AS d
USING (department_id)
WHERE e.salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;

#Ex.5
SELECT employee_id, first_name FROM employees AS e
LEFT JOIN employees_projects AS ep
USING (employee_id)
WHERE project_id IS NULL
ORDER BY employee_id DESC
LIMIT 3;

#Ex.6
SELECT e.first_name, e.last_name, e.hire_date, d.name 
FROM employees AS e
JOIN departments AS d
USING (department_id)
WHERE d.name IN ('Sales', 'Finance') AND e.hire_date > 1999/01/01
ORDER BY e.hire_date;

#Ex.7
SELECT e.employee_id, e.first_name, p.name FROM employees AS e
JOIN employees_projects AS ep USING (employee_id)
RIGHT JOIN projects AS p USING (project_id)
WHERE p.start_date > 2002/08/13 AND p.end_date IS NULL
ORDER BY e.first_name, p.name
LIMIT 5;

#Ex.8
SELECT e.employee_id, e.first_name, IF(YEAR(p.start_date) > 2004, NULL, p.name) FROM employees AS e
JOIN employees_projects AS ep USING (employee_id)
JOIN projects AS p USING (project_id)
WHERE e.employee_id = 24
ORDER BY p.name;

#Ex.9
SELECT employee_id, first_name, manager_id, 
(SELECT first_name FROM employees AS e2 WHERE e1.manager_id = e2.employee_id) AS manager_name
FROM employees AS e1
WHERE manager_id IN (3, 7)
ORDER BY e1.first_name;

#Ex.10
SELECT e.employee_id, 
CONCAT(e.first_name, ' ', e.last_name) AS employee_name,
CONCAT(m.first_name, ' ', m.last_name) AS manager_name, 
d.name AS department_name
FROM employees AS e
JOIN employees AS m ON e.manager_id = m.employee_id
JOIN departments AS d ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;

#Ex.11
SELECT (SELECT AVG(salary) AS avg_salary FROM employees 
		GROUP BY department_id
        ORDER BY avg_salary
        LIMIT 1) AS min_average_salary
FROM employees
LIMIT 1; 

#Ex.12
SELECT country_code, mountain_range, peak_name, elevation FROM mountains_countries AS mc
JOIN mountains AS m ON mc.mountain_id = m.id
JOIN peaks AS p ON m.id = p.mountain_id
WHERE country_code = 'BG' AND elevation > 2835
ORDER BY elevation DESC;

#Ex.13
SELECT country_code, COUNT(mountain_range) AS mountain_range
FROM mountains_countries AS mc
RIGHT JOIN mountains AS m  ON mc.mountain_id = m.id
WHERE country_code IN ('BG', 'RU', 'US')
GROUP BY country_code
ORDER BY mountain_range DESC;

#Ex.14
SELECT country_name, river_name FROM continents AS con
LEFT JOIN countries AS c USING (continent_code)
LEFT JOIN countries_rivers AS cr USING (country_code)
LEFT JOIN rivers AS r ON cr.river_id = r.id
WHERE continent_name = 'Africa' 
ORDER BY country_name
LIMIT 5;

#Ex.15
SELECT c.continent_code, c.currency_code, COUNT(*) AS 'currency_usage' FROM countries AS c
GROUP BY c.continent_code, c.currency_code
HAVING currency_usage > 1 AND 
	currency_usage = (SELECT COUNT(*) AS 'most_used_curr' FROM countries AS c2
    WHERE c2.continent_code = c.continent_code
    ORDER BY most_used_curr DESC
    LIMIT 1)
ORDER BY c.continent_code, c.currency_code;

#Ex.16
SELECT COUNT(country_code) FROM countries AS c
LEFT JOIN mountains_countries AS mc USING (country_code)
WHERE mountain_id IS NULL;