#Ex.1
SELECT title FROM books
WHERE title LIKE 'The%';

#Ex.2
SELECT replace(title, 'The', '***') FROM books
WHERE title LIKE 'The%';

#Ex.3
SELECT ROUND(SUM(cost), 2) FROM books;

#Ex.4
SELECT CONCAT(first_name, ' ', last_name) AS 'Full Name', 
TIMESTAMPDIFF(day, born, died) AS 'Days Lived' FROM authors;

#Ex.5
SELECT title FROM books
WHERE title LIKE 'Harry Potter%';