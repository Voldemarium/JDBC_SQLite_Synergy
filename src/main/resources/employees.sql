CREATE TABLE IF NOT EXISTS employees 
(
employee_id integer PRIMARY KEY AUTOINCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL
);

INSERT INTO employees (first_name, last_name) VALUES
('Steven', 'King'),
('Neena', 'Kochhar'),
('Lex', 'De Haan'),
('Aleksander', 'Hunold'),
('Bruce', 'Ernst'),
('David', 'Austin'),
('Valli', 'Pataballa'),
('Diana', 'Lorentz');

SELECT first_name, last_name FROM employees;
SELECT first_name FROM employees;
SELECT employee_id FROM employees;
SELECT * FROM employees LIMIT 5;

