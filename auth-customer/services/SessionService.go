package services

import (
	"errors"
	"fmt"
	"log"
	"plataform-stores/auth-customer/models"
	"time"

	"github.com/google/uuid"
)

var ipsAccess = make(map[string]int)
var ipOldError = make(map[string]time.Time)

//CreateNewSession create new session from a correct email and password
func CreateNewSession(email string, password string, userAgentName string, ip string) (models.Session, error) {

	var (
		session models.Session
		err     error
	)
	if okAccessToIP(ip) {
		user, err := FindUserByEmailAndPassWord(email, password)
		if err != nil {
			log.Print("falha criando sessao service")
			err = errors.New("Falha ao criar a sessao")
			failToAccessIP(ip)
		} else {
			log.Print("criando sessao service")
			session = createSessionFromUser(user)
			registrerSession(session, userAgentName, ip)
			err = nil
		}
	} else {
		err = errors.New("Ip bloqueado temporariamente")
	}
	return session, err

}

func registrerSession(session models.Session, userAgentName string, ip string) {

}

//okAccessToIp validate number of failed access
func okAccessToIP(ip string) bool {
	qtd := ipsAccess[ip]
	log.Print("ip " + ip)
	log.Print("qrd " + string(qtd))
	access := true
	if qtd > 3 {
		fmt.Printf(" tempo %v\n", time.Since(ipOldError[ip]).Minutes())
		if time.Since(ipOldError[ip]).Minutes() < 3 {
			log.Print("erro no numero de tentativas")
			access = false
		} else {
			delete(ipsAccess, ip)
			delete(ipOldError, ip)
			access = true
		}
	}
	return access
}

//failToAccessIp registry fail to access from a one ip
func failToAccessIP(ip string) {
	qtd := ipsAccess[ip]

	log.Print("ip " + ip)
	fmt.Printf("%v\n", qtd)

	if qtd == 0 {
		ipOldError[ip] = time.Now()
	}
	ipsAccess[ip] = qtd + 1
	log.Print(ipsAccess)
}

func createSessionFromUser(user models.UserRegister) models.Session {
	var (
		session models.Session
	)

	session.ID = uuid.New()
	session.State = "ACTIVE"
	session.Email = user.Email
	session.Name = user.Name
	session.NickName = user.NickName

	return session
}
