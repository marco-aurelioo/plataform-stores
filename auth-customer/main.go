package main

import (
	"encoding/json"
	"log"
	"net/http"
	"plataform-stores/auth-customer/models"
	"plataform-stores/auth-customer/services"

	"github.com/gorilla/mux"
)

var sessions []models.Session

// GetPerson mostra apenas um contato
func GetSession(w http.ResponseWriter, r *http.Request) {

	for _, item := range sessions {
		json.NewEncoder(w).Encode(item)
		return

	}
	json.NewEncoder(w).Encode(&models.Session{})
}

// CreateSession
func CreateSession(w http.ResponseWriter, r *http.Request) {
	log.Print("criando sessao")

	ip := getParamsFromKey("ip", r)
	userAgent := getParamsFromKey("userAgent", r)
	log.Print(ip)
	log.Print(userAgent)

	var u models.UserRegister
	err1 := json.NewDecoder(r.Body).Decode(&u)
	if err1 != nil {
		http.Error(w, err1.Error(), http.StatusBadRequest)
		return
	}
	session, err := services.CreateNewSession(u.Email, u.Password, userAgent, ip)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}
	json.NewEncoder(w).Encode(session)
}

func getParamsFromKey(key string, r *http.Request) string {
	keys, ok := r.URL.Query()[key]
	if !ok || len(keys[0]) < 1 {
		log.Println("Url Param 'key' is missing")
		return ""
	}
	return keys[0]
}

// DeleteSession
//func DeleteSession(w http.ResponseWriter, r *http.Request) {
//	params := mux.Vars(r)
//	for index, item := range sessions {
//
//		sessions = append(sessions[:index], sessions[index+1:]...)
//		break
//
//		json.NewEncoder(w).Encode(sessions)
//	}
//}

//CreateUser create new user validating unic email
func CreateUser(w http.ResponseWriter, r *http.Request) {
	var u models.UserRegister
	err1 := json.NewDecoder(r.Body).Decode(&u)
	if err1 != nil {
		http.Error(w, err1.Error(), http.StatusBadRequest)
		return
	}
	ret, err := services.CreateUser(u)

	if err != nil {
		log.Print("Erro " + err.Error())
		http.Error(w, err.Error(), http.StatusBadRequest)
	} else {
		log.Print("sucesso")
		json.NewEncoder(w).Encode(ret)
	}
}

func AddRules(w http.ResponseWriter, r *http.Request) {

}

func RemoveRules(w http.ResponseWriter, r *http.Request) {

}

// função principal para executar a api
func main() {
	router := mux.NewRouter()
	//	sessions = append(Session, Session{})
	//	sessions = append(Session, Session{})
	router.HandleFunc("/session/{sessionid}", GetSession).Methods("GET")
	//router.HandleFunc("/session/{sessionid}", DeleteSession).Methods("DELETE")
	router.HandleFunc("/auth", CreateSession).Methods("POST")
	router.HandleFunc("/user", CreateUser).Methods("POST")
	router.HandleFunc("/user/{id}/rule", AddRules).Methods("POST")
	router.HandleFunc("/user/{id}/rule/{rule}", RemoveRules).Methods("DELETE")
	log.Fatal(http.ListenAndServe(":8001", router))
}
