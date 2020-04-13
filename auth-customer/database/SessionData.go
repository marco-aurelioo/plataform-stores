package database

import (
	"errors"
	"log"
	"plataform-stores/auth-customer/models"
	"time"
)

func CreateSession(id string, status string, userId int64, ip string, userAgent string) {
	db := dbConn()
	stantment := "INSERT INTO Session (ID,IP,userAgent ,`create`, status,updated,userId ) VALUES ( ? , ? , ? , ?, ?, ?, ? )"
	_, err := db.Exec(stantment, id, ip, userAgent, time.Now(), status, time.Now(), userId)
	if err != nil {
		log.Print("erro ao inserir usuario " + err.Error())
	} else {
		log.Print("sessão registrada com sucesso")
	}
	defer db.Close()

}

func FindSession(sessionKey string) (models.Session, error) {
	var (
		session models.Session
	)
	db := dbConn()
	stantment := "select  s.ID, s.status, u.name, u.nickName, u.email from Session s inner join User u on u.id = s.userId where ID = ? and s.status = 'ACTIVE'"
	rows, err := db.Query(stantment, sessionKey)
	if err != nil {
		err = errors.New("Session invalida")
	} else {
		rows.Next()
		rows.Scan(&session.ID, &session.State, &session.Name, &session.NickName, &session.NickName)
	}
	defer db.Close()
	return session, err
}

func IvalidateSession(sessionKey string) {

}
