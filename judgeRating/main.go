package main

import (
    
    "log"
    "net/http"
    "github.com/gorilla/mux"
)

// função principal
func main() {
    router := mux.NewRouter()
    router.HandleFunc("/contato", GetPeople).Methods("GET")
    router.HandleFunc("/contato/{id}", GetPerson).Methods("GET")
    router.HandleFunc("/contato/{id}", CreatePerson).Methods("POST")
	router.HandleFunc("/contato/{id}", DeletePerson).Methods("DELETE")    
	log.Fatal(http.ListenAndServe(":8000", router))
}

func GetPeople(w http.ResponseWriter, r *http.Request) {}
func GetPerson(w http.ResponseWriter, r *http.Request) {}
func CreatePerson(w http.ResponseWriter, r *http.Request) {}
func DeletePerson(w http.ResponseWriter, r *http.Request) {}