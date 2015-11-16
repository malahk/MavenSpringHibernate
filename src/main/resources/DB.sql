CREATE DATABASE IF NOT EXISTS zoo_db
  CHARACTER SET utf8;

GRANT ALL PRIVILEGES ON zoo_db.* TO 'root@localhost'
IDENTIFIED BY 'toor'
WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON zoo_db.* TO 'root@%'
IDENTIFIED BY 'toor'
WITH GRANT OPTION;

FLUSH PRIVILEGES;
USE zoo_db;

CREATE TABLE IF NOT EXISTS animals (
  id    INT(11)     NOT NULL AUTO_INCREMENT,
  type  VARCHAR(45) NOT NULL,
  name  VARCHAR(45) NOT NULL,
  price INT(11)     NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO animals (type, name, price) VALUES ('cat','barsik', 100);
INSERT INTO animals (type, name, price) VALUES ('dog','druzok', 200);
INSERT INTO animals (type, name, price) VALUES ('fish','guppie', 50);

