-- ============================================
-- Database script for MariaDB/MySQL
-- ============================================
-- NOTE: Execute the INSERT commands one by one.
--       Running all INSERTs at once might cause foreign key errors
--       if dependent tables are not populated yet.
-- ============================================

CREATE TABLE department (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE seller (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL,
    email VARCHAR(100) NOT NULL,
    birth_date DATETIME NOT NULL,
    base_salary DOUBLE NOT NULL,
    department_id INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (department_id) REFERENCES department(id)
);

INSERT INTO department (name) VALUES
    ('Computers'),
    ('Electronics'),
    ('Fashion'),
    ('Books');

INSERT INTO seller (name, email, birth_date, base_salary, department_id) VALUES
    ('Alice Johnson', 'alicejohnson@example.com', '1990-05-14 00:00:00', 1500.0, 1),
    ('Brian Smith', 'briansmith@example.com', '1985-11-22 00:00:00', 2200.0, 2),
    ('Carla Adams', 'carlaadams@example.com', '1992-02-10 00:00:00', 1800.0, 1),
    ('Daniel White', 'danielwhite@example.com', '1988-08-05 00:00:00', 2500.0, 4),
    ('Emma Brown', 'emmabrown@example.com', '1995-12-18 00:00:00', 3000.0, 3),
    ('Frank Green', 'frankgreen@example.com', '1991-03-30 00:00:00', 2000.0, 2);