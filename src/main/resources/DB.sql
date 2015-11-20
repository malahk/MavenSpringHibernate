CREATE DATABASE IF NOT EXISTS zoo_db
CHARACTER SET utf8;

GRANT ALL PRIVILEGES ON zoo_db.* TO 'root@localhost'
IDENTIFIED BY 'root'
WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON zoo_db.* TO 'root@%'
IDENTIFIED BY 'root'
WITH GRANT OPTION;

FLUSH PRIVILEGES;
USE zoo_db;

CREATE TABLE IF NOT EXISTS accessories (
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR (45) NOT NULL,
  price INT(11) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE=InnoDB
  AUTO_INCREMENT=3
  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS address (
  id INT(11) NOT NULL AUTO_INCREMENT,
  country VARCHAR(45) NOT NULL,
  street VARCHAR(45) NOT NULL,
  zipcode INT(11) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE=InnoDB
  AUTO_INCREMENT=12
  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS animals (
  id INT(11) NOT NULL AUTO_INCREMENT,
  type VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  price INT(11) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE=InnoDB
  DEFAULT
  CHARSET=utf8;

CREATE TABLE IF NOT EXISTS food (
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  weight INT(11) NOT NULL,
  price INT(11) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE=InnoDB
  DEFAULT
  CHARSET=utf8;

CREATE TABLE IF NOT EXISTS roles (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE=InnoDB
  AUTO_INCREMENT=13
  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS users (
  id INT(11) NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(45) NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  login VARCHAR(45) NOT NULL,
  password  VARCHAR(45) NOT NULL,
  role_id INT(11) NOT NULL DEFAULT '1',
  address_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY login_UNIQUE (login),
  KEY address_id (address_id),
  KEY role_id (role_id),
  CONSTRAINT address_id FOREIGN KEY (address_id) REFERENCES address (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT role_id FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE NO ACTION ON UPDATE NO ACTION
)
  ENGINE=InnoDB
  AUTO_INCREMENT=11
  DEFAULT CHARSET=utf8;


INSERT INTO animals (type, name, price) VALUES ('cat','barsik', 100);
INSERT INTO animals (type, name, price) VALUES ('dog','druzok', 200);
INSERT INTO animals (type, name, price) VALUES ('fish','guppie', 50);
INSERT INTO accessories (title, price) VALUES ('collar', 50);
INSERT INTO accessories (title, price) VALUES ('ball', 30);
INSERT INTO accessories (title, price) VALUES ('bag', 70);
INSERT INTO food (title, weight, price) VALUES ('meat','400', 50);
INSERT INTO food (title, weight, price) VALUES ('fish','1000', 30);
INSERT INTO food (title, weight, price) VALUES ('worms','50', 20);
INSERT INTO users (firstname, lastname, login, password, role_id, address_id) VALUES ('I AM GROOT','I AM GROOT', 'groot', 'groot', 1, 1);
INSERT INTO users (firstname, lastname, login, password, role_id, address_id) VALUES ('Arnold','Schwarzenegger', 'iron', 'iron', 1, 2);
INSERT INTO users (firstname, lastname, login, password, role_id, address_id) VALUES ('Emperor','Emperor', 'emperor', 'emperor', 2, 3);
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO address (country, street, zipcode) VALUES ('I AM GROOT','I AM GROOT', 100500);
INSERT INTO address (country, street, zipcode) VALUES ('USA','MULHOLLAND DRIVE 10/32', 60745);
INSERT INTO address (country, street, zipcode) VALUES ('Imperium of Man','Holy Terra, Segmentum Solar, Emperors Castle 1', 999999);





