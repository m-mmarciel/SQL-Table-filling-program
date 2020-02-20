DROP TABLE IF EXISTS employee;

CREATE TABLE employee(
	employee_id INT UNSIGNED NOT NULL,
    salary INT UNSIGNED NOT NULL,
    title VARCHAR(30) NOT NULL,
    PRIMARY KEY (employee_id)
);