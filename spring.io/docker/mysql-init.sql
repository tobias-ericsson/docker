CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE TABLE IF NOT EXISTS messages (
    id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    date VARCHAR(255),
    body TEXT,
    PRIMARY KEY (id)
);

INSERT INTO messages (title, body) VALUES ("First Message", "First Body");