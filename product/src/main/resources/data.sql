DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT (
  id LONG NOT NULL,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  max_price DECIMAL(8,2) DEFAULT NULL,
  min_price DECIMAL(8,2) DEFAULT NULL
);

INSERT INTO CUSTOMER (id,name, gener, nick_name, avatar) VALUES
(1,'produto 1','descrição produto1',10.2,7.99),
(2,'produto 2','descrição produto2',11.2,7.49),
(3,'produto 3','descrição produto3',13.2,7.69),
(4,'produto 4','descrição produto4',1.2,0.99),
(5,'produto 5','descrição produto5',17.2,11.28);