
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS class_in_school;

-- 班级表
CREATE TABLE class_in_school (
  id INT NOT NULL AUTO_INCREMENT,
  teacher VARCHAR(255),
  class_no VARCHAR(255),
  floor INT,
  PRIMARY KEY (id)
);
DELETE FROM class_in_school;

-- 学生表
CREATE TABLE Student (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  age  INT,
  sex INT,
  class_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (class_id) REFERENCES class_in_school(id)
);
DELETE FROM Student;


-- 班级数据
INSERT INTO class_in_school (teacher, class_no, floor) VALUES ('leon1', "one", 1);
INSERT INTO class_in_school (teacher, class_no, floor) VALUES ('leon2', "two", 2);
INSERT INTO class_in_school (teacher, class_no, floor) VALUES ('leon3', "three", 3);
INSERT INTO class_in_school (teacher, class_no, floor) VALUES ('leon4', "four", 4);
INSERT INTO class_in_school (teacher, class_no, floor) VALUES ('leon5', "five", 5);

-- 学生数据
INSERT INTO Student (name, age, sex, class_id) VALUES ('Freud1', 29, 1, 1);
INSERT INTO Student (name, age, sex, class_id) VALUES ('Freud2', 29, 1, 2);
INSERT INTO Student (name, age, sex, class_id) VALUES ('Freud3', 29, 1, 2);
INSERT INTO Student (name, age, sex, class_id) VALUES ('Freud4', 29, 1, 2);
INSERT INTO Student (name, age, sex, class_id) VALUES ('Freud5', 29, 1, 3);
-- UPDATE Student SET age = 666;