package main

import (
	"encoding/json"
	"log"
	"net/http"

	"plataform-stores/messages-b2c/models"
	"plataform-stores/messages-b2c/sendgrid"

	"github.com/gorilla/mux"
)

func CreateMessage(w http.ResponseWriter, r *http.Request) {
	var msg models.Message
	err1 := json.NewDecoder(r.Body).Decode(&msg)
	if err1 != nil {
		http.Error(w, err1.Error(), http.StatusBadRequest)
		return
	}
	ret := sendgrid.SendMessage(msg)
	log.Print("sucesso")
	json.NewEncoder(w).Encode(ret)
}

func GetMessage(w http.ResponseWriter, r *http.Request) {

}

// função principal para executar a api
func main() {
	router := mux.NewRouter()
	router.HandleFunc("/msg/{msgid}", GetMessage).Methods("GET")
	router.HandleFunc("/msg", CreateMessage).Methods("POST")
	log.Fatal(http.ListenAndServe(":8002", router))

}

func getParamsFromKey(key string, r *http.Request) string {
	keys, ok := r.URL.Query()[key]
	if !ok || len(keys[0]) < 1 {
		log.Println("Url Param 'key' is missing")
		return ""
	}
	return keys[0]
}
