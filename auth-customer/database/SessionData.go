package database

import (
	"log"
	"time"
)

func CreateSession(id string, status string, userId int64, ip string, userAgent string) {
	db := dbConn()
	stantment := "INSERT INTO Session (ID,IP,userAgent ,`create`, status,updated,userId ) VALUES ( ? , ? , ? , ?,?,?,? )"
	_, err := db.Exec(stantment, id, ip, userAgent, time.Now(), status, time.Now(), userId)
	if err != nil {
		log.Print("erro ao inserir usuario " + err.Error())
	} else {
		log.Print("sessão registrada com sucesso")
	}
	defer db.Close()

}

func FindSession(sessionKey string) {

}

func IvalidateSession(sessionKey string) {

}
