DROP TABLE IF EXISTS CUSTOMER;
 
CREATE TABLE CUSTOMER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  gener VARCHAR(250) NOT NULL,
  nickName VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO CUSTOMER (name, gener, nickName) VALUES
  ('Frederico Amorim','M','Fred'),
  ('Jorge Amorim','M','Jorginho'),
  ('Pedro','M','Pedrinho');