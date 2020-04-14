#run msql docker 
docker run --rm -dit -v /opt/data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pass MYSQL_ROOT_HOST=% --name plataform-mysql mysql:5.7

Compose docker mysql:

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

