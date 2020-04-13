FROM golang:1.13

WORKDIR /go/src/plataform-stores
COPY ./messages-b2c /go/src/plataform-stores/messages-b2c

RUN go get -d -v "github.com/google/uuid"
RUN go get -d -v "github.com/gorilla/mux"
RUN go get -d -v "github.com/sendgrid/sendgrid-go"
RUN go get -d -v "github.com/sendgrid/sendgrid-go/helpers/mail"

RUN go install -v "github.com/google/uuid"
RUN go install -v "github.com/gorilla/mux"
RUN go install -v "github.com/sendgrid/sendgrid-go"
RUN go install -v "github.com/sendgrid/sendgrid-go/helpers/mail"

RUN go get ./...

CMD ["./messages-b2c"]