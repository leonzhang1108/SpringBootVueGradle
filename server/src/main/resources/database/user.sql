DROP TABLE IF EXISTS Person;
CREATE TABLE Person (
  P_ID INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  age  INT,
  PRIMARY KEY (P_ID)
);


DELETE FROM Person;

INSERT INTO Person (name, age) VALUES ('Freud1', 29);
INSERT INTO Person (name, age) VALUES ('Freud2', 29);
INSERT INTO Person (name, age) VALUES ('Freud3', 29);
INSERT INTO Person (name, age) VALUES ('Freud4', 29);
INSERT INTO Person (name, age) VALUES ('Freud5', 29);
UPDATE Person SET age = 666;