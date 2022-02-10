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