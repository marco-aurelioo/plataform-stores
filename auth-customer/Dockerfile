FROM golang:1.13

WORKDIR /go/src/plataform-stores
COPY ./auth-customer /go/src/plataform-stores/auth-customer

RUN go get -d -v "github.com/google/uuid"
RUN go get -d -v "github.com/gorilla/mux"
RUN go get -d -v "github.com/go-sql-driver/mysql"

RUN go install -v "github.com/google/uuid"
RUN go install -v "github.com/gorilla/mux"
RUN go install -v "github.com/go-sql-driver/mysql"

RUN go get ./...

CMD ["./auth-customer"]