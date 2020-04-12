package database

import (
	"database/sql"
	"log"
	"plataform-stores/auth-customer/models"
)

//CreateNewUser save on database
func CreateNewUser(user models.UserRegister) (models.UserRegister, error) {
	db := dbConn()
	stantment := "INSERT INTO User (email, password, name, nickName) VALUES ( ? , ? , ? , ? )"
	selDB, err := db.Exec(stantment, user.Email, user.Password, user.Name, user.NickName)
	if err != nil {
		log.Print("erro ao inserir usuario " + err.Error())
	} else {
		user.ID, err = selDB.LastInsertId()
	}
	defer db.Close()
	return user, err
}

func FindUserByIds(ids []int) {

}

//FindUserByEmail returns userRegister by email
func FindUserByEmail(email string) (models.UserRegister, error) {
	db := dbConn()
	stantment := "SELECT email,password,ID,name,nickName FROM User where email = ?"
	selDB := db.QueryRow(stantment, email)
	var (
		user models.UserRegister
	)
	err := selDB.Scan(&user.Email, &user.Password, &user.ID, &user.Name, &user.NickName)
	defer db.Close()
	if err != nil && err != sql.ErrNoRows {
		log.Print("Usuario não encontrado com o email " + email)
	}
	return user, err
}

// FindUserByEmailAndPassWord find user with email and password.
func FindUserByEmailAndPassWord(email string, password string) (models.UserRegister, error) {
	db := dbConn()
	stantment := "SELECT email,password,ID,name,nickName FROM User where email = ? and password = ?"
	selDB := db.QueryRow(stantment, email, password)
	var (
		user models.UserRegister
	)
	err := selDB.Scan(&user.Email, &user.Password, &user.ID, &user.Name, &user.NickName)
	defer db.Close()
	if err != nil && err != sql.ErrNoRows {
		log.Print("Usuario não encontrado ")
	}
	return user, err
}
