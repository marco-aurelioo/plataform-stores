#Projeto auth-customer

This project is responsible for authenticating, unifying sessions and access rules for all customers
 
##Available Services

*Registry user 
Add rule access
Remove rule access
*Create session
*Validate session
Remove session

depends 
Mysql localhost:3306 (docker configurate on ../DBMysql database: Customers, tables: users, session) 
messages-b2c localhost:8002 (docker confirate on ../messages-b2c)

"github.com/go-sql-driver/mysql"
"github.com/google/uuid"
"github.com/gorilla/mux"

#Docker build and run
go build
docker build -t auth-customer .
docker run -it --rm -p 8001:8001 --name auth-customer auth-customer