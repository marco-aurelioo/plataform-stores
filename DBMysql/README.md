# Mysql Configuration and scripts
documentation to include data related to the platform's mysql database

### run msql docker 
docker run --rm -dit -v /opt/data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pass MYSQL_ROOT_HOST=% --name plataform-mysql mysql:5.7

## Databases 
### Clients
auth-customer
#### script to auth-customer
create databases Customers;
use Customers;
CREATE TABLE `User` (
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `nickName` varchar(100) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  UNIQUE KEY `User_id_IDX` (`id`) USING BTREE,
  KEY `id` (`id`),
  FULLTEXT KEY `User_email_IDX` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1

CREATE TABLE `Session` (
  `ID` varchar(100) NOT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `userAgent` varchar(100) DEFAULT NULL,
  `create` datetime DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  UNIQUE KEY `Session_ID_IDX` (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1



### Compose docker mysql:

mysql:
  image: mysql/mysql-server:5.7
  ports:
   - "3306:3306"
  environment:
    MYSQL_ROOT_PASSWORD: pass
    MYSQL_USER: dbuser
    MYSQL_PASSWORD: userpass
    MYSQL_DATABASE: plataform
    MYSQL_ROOT_HOST: %
  volumes:
   - /opt/data:/var/lib/mysql

