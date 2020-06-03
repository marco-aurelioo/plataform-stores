DROP TABLE IF EXISTS CUSTOMER;
 
CREATE TABLE CUSTOMER (
  id VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  gener VARCHAR(250) NOT NULL,
  nick_name VARCHAR(250) DEFAULT NULL,
  avatar VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO CUSTOMER (id,name, gener, nick_name, avatar) VALUES
  ('0635c81f-3e75-4e0f-a248-a919e9f0dde0','Frederico Amorim','M','Fred','https://img.favpng.com/12/2/6/computer-icons-user-profile-avatar-png-favpng-atLhPkZ1MULZUSeGvauk2WtMp_t.jpg'),
  ('b557c6c8-8556-4be1-a386-de64d313cf60','Jorge Amorim','M','Jorginho','https://img.favpng.com/17/22/20/computer-icons-avatar-child-user-profile-blog-png-favpng-mkwEYyWeERuihcWLNTu9erqqn_t.jpg'),
  ('5e9a2dd7-94b3-4565-9a56-b626415ad003','Pedro','M','Pedrinho','https://img.favpng.com/8/7/18/avatar-child-computer-icons-user-profile-png-favpng-MzLAeL5t4QkeLit56jc7DdPUC_t.jpg'),
  ('d1dc9997-1aec-4e7e-ad06-18d8d41d727a','Marcia','F','marcia','https://img.favpng.com/13/0/13/cat-computer-icons-user-profile-avatar-png-favpng-0aXfSAjB7FwDVpeuUDXvWRLzd_t.jpg');
