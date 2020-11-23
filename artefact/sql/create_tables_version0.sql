DROP DATABASE IF EXISTS teste;
CREATE DATABASE IF NOT exists teste;
USE teste;
CREATE TABLE user(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    login VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(8) NOT NULL
);


CREATE TABLE action_remove(
	id INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE action_addiction(
	id INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE action(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    fk_action_addiction INTEGER NOT NULL,
    FOREIGN KEY(fk_action_addiction) REFERENCES action_addiction(id),
    fk_action_remove INTEGER NOT NULL,
    FOREIGN KEY(fk_action_remove) REFERENCES action_remove(id)
);



CREATE TABLE section(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL UNIQUE
    
);

CREATE TABLE drink_alcoholic(
	id INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE drink_non_alcoholic(
	id INTEGER PRIMARY KEY AUTO_INCREMENT
);


CREATE TABLE historic(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data DATE NOT NULL,
    fk_user INTEGER NOT NULL,
    FOREIGN KEY (fk_user) REFERENCES user(id),
    fk_action INTEGER NOT NULL,
    FOREIGN KEY (fk_action) REFERENCES action(id)
);

CREATE TABLE drink(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    capacity DOUBLE NOT NULL,
    price DOUBLE NOT NULL,
    fk_drink_alcoholic INTEGER NOT NULL,
    FOREIGN KEY (fk_drink_alcoholic) REFERENCES drink_alcoholic(id),
    fk_drink_non_alcoholic INTEGER NOT NULL,
    FOREIGN KEY (fk_drink_non_alcoholic) REFERENCES drink_non_alcoholic(id),
    fk_section INTEGER NOT NULL,
    FOREIGN KEY (fk_section) REFERENCES section(id),
    fk_action INTEGER NOT NULL,
    FOREIGN KEY (fk_action) REFERENCES action(id)
    
);


