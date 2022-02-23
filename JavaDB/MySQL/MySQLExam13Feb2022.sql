CREATE SCHEMA online_stores;
USE online_stores;

#Ex.1
CREATE TABLE brands (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE categories (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE reviews (
id INT AUTO_INCREMENT PRIMARY KEY,
content TEXT,
rating DECIMAL(10, 2) NOT NULL,
picture_url VARCHAR(80) NOT NULL,
published_at DATETIME NOT NULL
);

CREATE TABLE products (
id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(40) NOT NULL,
price DECIMAL (19, 2) NOT NULL,
quantity_in_stock INT,
`description` TEXT,
brand_id INT NOT NULL,
category_id INT NOT NULL,
review_id INT,
CONSTRAINT fk_products_brands
FOREIGN KEY (brand_id)
REFERENCES brands(id),
CONSTRAINT fk_products_categories
FOREIGN KEY (category_id)
REFERENCES categories(id),
CONSTRAINT fk_products_reviews
FOREIGN KEY (review_id)
REFERENCES reviews(id)
);

CREATE TABLE customers (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
phone VARCHAR(30) UNIQUE NOT NULL,
address VARCHAR(60) NOT NULL,
discount_card BIT(1) NOT NULL DEFAULT FALSE
);

CREATE TABLE orders (
id INT AUTO_INCREMENT PRIMARY KEY,
order_datetime DATETIME NOT NULL,
customer_id INT NOT NULL,
CONSTRAINT fk_orders_customers
FOREIGN KEY (customer_id)
REFERENCES customers(id)
);

CREATE TABLE orders_products (
order_id INT,
product_id INT,
CONSTRAINT fk_orders_products_orders
FOREIGN KEY (order_id)
REFERENCES orders(id),
CONSTRAINT fk_orders_products_products
FOREIGN KEY (product_id)
REFERENCES products(id)
);

#Ex.2
INSERT INTO reviews (content, picture_url, published_at, rating)
(
SELECT SUBSTRING(description, 1, 15) AS content, REVERSE(name) AS picture_url,
 '2010-10-10' AS published_at, (price / 8) AS rating FROM products
WHERE id > 4
); 

SET SQL_SAFE_UPDATES = 0;

#Ex.3
UPDATE products
SET quantity_in_stock = quantity_in_stock - 5
WHERE quantity_in_stock BETWEEN 60 AND 70;

#Ex.4
DELETE c, o FROM customers AS c 
LEFT JOIN orders AS o ON  o.customer_id = c.id
WHERE (o.customer_id IS NULL);

#Ex.5
SELECT id, name FROM categories
ORDER BY name DESC;

#Ex.6
SELECT id, brand_id, name, quantity_in_stock FROM products
WHERE price > 1000 AND quantity_in_stock < 30
ORDER BY quantity_in_stock, id;

#Ex.7
SELECT id, content, rating, picture_url, published_at FROM reviews
WHERE content LIKE 'My%' AND char_length(content) > 61
ORDER BY rating DESC; 

#Ex.8
SELECT CONCAT(first_name, ' ', last_name) AS full_name, address, order_datetime FROM customers AS c
RIGHT JOIN orders AS o ON c.id = o.customer_id
WHERE YEAR(order_datetime) < 2019
ORDER BY full_name DESC;

#Ex.9
SELECT COUNT(*) AS items_count, c.name, SUM(quantity_in_stock) AS total_quantity FROM products AS p
JOIN categories AS c ON p.category_id = c.id
GROUP BY c.name
ORDER BY items_count DESC, total_quantity ASC
LIMIT 5;

#Ex.10
DELIMITER $$
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(product_id) FROM customers AS c
    JOIN orders AS o ON c.id = o.customer_id
    JOIN orders_products AS op ON o.id = op.order_id
    GROUP BY c.first_name
    HAVING c.first_name = name);
END
$$

SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as total_products FROM customers c
WHERE c.first_name = 'Shirley';
$$

#Ex.11
CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
	UPDATE products AS p , (SELECT p.id FROM reviews AS r
        JOIN products AS p ON r.id = p.review_id
        JOIN categories AS c ON p.category_id = c.id
        WHERE c.name = category_name AND r.rating < 4) ids
    SET price = price * 0.7
    WHERE p.id IN (ids.id);
END
$$

CALL udp_reduce_price ('Phones and tablets');
DELIMITER ;