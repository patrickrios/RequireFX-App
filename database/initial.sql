DROP DATABASE `requirefx`;

CREATE DATABASE `requirefx`
CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `requirefx`;

CREATE TABLE `rfx_project`(
	project_id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(100),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY(project_id)
);

CREATE TABLE  `rfx_require`(
	require_id INT AUTO_INCREMENT NOT NULL,
    project_id INT NOT NULL,
    name VARCHAR(200) NOT NULL,
    done TINYINT NOT NULL DEFAULT 1,
    type_id TINYINT NOT NULL DEFAULT 1,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY(require_id),
    FOREIGN KEY (project_id) 
    REFERENCES `rfx_project`(project_id)
    ON DELETE CASCADE
);

DROP TABLE `rfx_require`;

-- CREATE
INSERT INTO `rfx_project` (`project_id`, `name`) VALUES (DEFAULT, 'First project 2');

-- DELETING
DELETE FROM `rfx_project` WHERE `project_id` = '1';

-- READING
SELECT * FROM `rfx_project`;