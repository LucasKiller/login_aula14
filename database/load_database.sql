CREATE DATABASE IF NOT EXISTS aula14;

USE aula14;

CREATE TABLE IF NOT EXISTS users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    password VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS uni_subject (
    id INT PRIMARY KEY,
    n1 DECIMAL(10, 2) NOT NULL,
    f1 INT NOT NULL,
    n2 DECIMAL(10, 2) NOT NULL,
    f2 INT NOT NULL,
    n3 DECIMAL(10, 2) NOT NULL,
    f3 INT NOT NULL,
    n4 DECIMAL(10, 2) NOT NULL,
    f4 INT NOT NULL
);

INSERT INTO uni_subject(id, n1, f1, n2, f2, n3, f3, n4, f4) VALUES (1, 0.00, 0, 0.00, 0, 0.00, 0, 0.00, 0);
INSERT INTO uni_subject(id, n1, f1, n2, f2, n3, f3, n4, f4) VALUES (2, 0.00, 0, 0.00, 0, 0.00, 0, 0.00, 0);


