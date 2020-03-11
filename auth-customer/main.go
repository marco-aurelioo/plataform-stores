package main

import (
	"encoding/json"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

// "Person type" (tipo um objeto)
type UserRegister struct {
	ID       string "json:id"
	Email    string "json:email"
	Password string "json:password"
}

type Session struct {
	ID    string "json:id"
	State string "json:state"
	Rules string "json:rules"
}

var sessions []Session

// GetPerson mostra apenas um contato
func GetSession(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	for _, item := range sessions {
		if item.ID == params["id"] {
			json.NewEncoder(w).Encode(item)
			return
		}
	}
	json.NewEncoder(w).Encode(&Session{})
}

// CreateSession
func CreateSession(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	var session Session
	_ = json.NewDecoder(r.Body).Decode(&session)
	session.ID = params["id"]
	sessions = append(sessions, session)
	json.NewEncoder(w).Encode(session)
}

// DeleteSession
func DeleteSession(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	for index, item := range sessions {
		if item.ID == params["id"] {
			sessions = append(sessions[:index], sessions[index+1:]...)
			break
		}
		json.NewEncoder(w).Encode(sessions)
	}
}

// função principal para executar a api
func main() {
	router := mux.NewRouter()
	//	sessions = append(Session, Session{})
	//	sessions = append(Session, Session{})
	router.HandleFunc("/session/{sessionid}", GetSession).Methods("GET")
	router.HandleFunc("/session/{sessionid}", DeleteSession).Methods("DELETE")
	router.HandleFunc("/auth", CreateSession).Methods("POST")

	log.Fatal(http.ListenAndServe(":8001", router))
}
