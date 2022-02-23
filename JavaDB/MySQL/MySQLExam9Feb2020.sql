CREATE SCHEMA fsd;
USE fsd;

#Ex.1
CREATE TABLE skills_data (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
dribbling INT DEFAULT 0,
pace INT DEFAULT 0,
passing INT DEFAULT 0,
shooting INT DEFAULT 0,
speed INT DEFAULT 0,
strength INT DEFAULT 0
);

CREATE TABLE countries (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45) NOT NULL
);

CREATE TABLE towns(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
country_id INT NOT NULL,
CONSTRAINT fk_towns_countries
FOREIGN KEY (country_id)
REFERENCES countries(id)
);

CREATE TABLE stadiums (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
capacity INT NOT NULL,
town_id INT NOT NULL,
CONSTRAINT fk_stadiums_towns
FOREIGN KEY (town_id)
REFERENCES towns(id)
);

CREATE TABLE teams (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
established DATE NOT NULL,
fan_base BIGINT NOT NULL DEFAULT 0,
stadium_id INT NOT NULL,
CONSTRAINT fk_teams_stadiums
FOREIGN KEY (stadium_id)
REFERENCES stadiums(id)
);

CREATE TABLE coaches (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(10) NOT NULL,
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(10, 2) NOT NULL DEFAULT 0,
coach_level INT NOT NULL
);

CREATE TABLE players (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(10) NOT NULL,
last_name VARCHAR(20) NOT NULL,
age INT NOT NULL,
position CHAR NOT NULL,
salary DECIMAL(10, 2) NOT NULL DEFAULT 0,
hire_date DATETIME,
skills_data_id INT NOT NULL,
team_id INT,
CONSTRAINT fk_players_skills_data
FOREIGN KEY (skills_data_id)
REFERENCES skills_data(id),
CONSTRAINT fk_players_teams
FOREIGN KEY (team_id)
REFERENCES teams(id)
);

CREATE TABLE players_coaches (
player_id INT,
coach_id INT,
CONSTRAINT pk_players_coaches
PRIMARY KEY (player_id, coach_id),
CONSTRAINT fk_players_coaches_players
FOREIGN KEY (player_id)
REFERENCES players(id),
CONSTRAINT fk_players_coaches_coaches
FOREIGN KEY (coach_id)
REFERENCES coaches(id)
);

#Ex.2
INSERT INTO coaches (first_name, last_name, salary, coach_level)
(SELECT first_name, last_name, salary * 2, char_length(first_name) AS coach_level FROM players
WHERE age > 44);

SET SQL_SAFE_UPDATES = 0;

#Ex.3
UPDATE coaches AS c JOIN players_coaches AS pc ON pc.coach_id = c.id
SET coach_level = coach_level + 1
WHERE first_name LIKE 'A%';

#Ex.4
DELETE FROM players WHERE age > 44;

#Ex.5
SELECT first_name, age, salary FROM players
ORDER BY salary DESC;

#Ex.6
SELECT p.id, CONCAT(first_name, ' ', last_name) AS full_name, age, position, hire_date FROM players AS p
JOIN skills_data AS sd ON p.skills_data_id = sd.id
WHERE age < 23 AND position = 'A' AND hire_date IS NULL AND sd.strength > 50
ORDER BY salary, age;

#Ex.7
SELECT name, established, fan_base, COUNT(*) AS count_of_players FROM teams AS t
JOIN players AS p ON t.id = p.team_id
GROUP BY p.team_id
ORDER BY count_of_players DESC, fan_base DESC;

#Ex.8
SELECT MAX(sd.speed) AS max_speed, t.name AS town_name FROM skills_data AS sd
JOIN players AS p ON sd.id = p.skills_data_id
RIGHT JOIN  teams AS te ON p.team_id = te.id
JOIN stadiums AS s ON te.stadium_id = s.id
RIGHT JOIN towns AS t ON s.town_id = t.id
WHERE te.name != 'Devify'
GROUP BY town_name
ORDER BY max_speed DESC, town_name ASC;

#Ex.9
SELECT c.name, COUNT(p.id) AS total_count_of_players, SUM(salary) AS total_sum_od_salaries FROM players AS p
LEFT JOIN  teams AS te ON p.team_id = te.id
LEFT JOIN stadiums AS s ON te.stadium_id = s.id
LEFT JOIN towns AS t ON s.town_id = t.id
RIGHT JOIN countries AS c ON t.country_id = c.id
GROUP BY c.name
ORDER BY total_count_of_players DESC, c.name ASC;

DELIMITER $$
#Ex.10
CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(p.id) FROM players AS p 
	JOIN teams AS t ON p.team_id = t.id
    JOIN stadiums AS s ON t.stadium_id = s.id
    GROUP BY s.name
    HAVING s.name = stadium_name);
END;
$$

DELIMITER ;

SELECT udf_stadium_players_count ('Jaxworks') AS `count`;
SELECT udf_stadium_players_count ('Linklinks') AS `count`;

#Ex.11
DELIMITER $$
CREATE PROCEDURE udp_find_playmaker (min_dribble_points INT, team_name VARCHAR(45))
BEGIN
	SELECT CONCAT(first_name, ' ', last_name) AS full_name, age, salary, dribbling, speed, team_name 
    FROM skills_data AS sd
    JOIN players as p ON p.skills_data_id = sd.id
    RIGHT JOIN teams AS t ON p.team_id = t.id
    WHERE dribbling > min_dribble_points AND t.name = team_name AND speed > (SELECT AVG(speed) FROM skills_data)
    ORDER BY speed DESC
    LIMIT 1;
END
$$

CALL udp_find_playmaker (20, 'Skyble')$$