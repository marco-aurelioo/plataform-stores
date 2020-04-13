package services

import (
	"crypto/aes"
	"crypto/cipher"
	"encoding/base64"
	"errors"
	"log"
	"plataform-stores/auth-customer/database"
	"plataform-stores/auth-customer/models"
	"regexp"
)

const chave = "ChaveDeSeguranca"

var iv = []byte{34, 35, 35, 57, 68, 4, 35, 36, 7, 8, 35, 23, 35, 86, 35, 23}

//CreateUser rule to create new user
func CreateUser(newUser models.UserRegister) (models.UserRegister, error) {
	log.Print("criando usuario")
	//validando unicidade para o email
	var (
		user models.UserRegister
	)
	if !validateEmail(newUser.Email) {
		err := errors.New("Email invalido.")
		return user, err
	}
	userExiste, err := database.FindUserByEmail(newUser.Email)
	if err != nil {
		//encriptando senha
		log.Print("não encontrou")
		encriptPass := encrypt(chave, newUser.Password)
		newUser.Password = string(encriptPass)

		//incluindo novo usuario
		user, err = database.CreateNewUser(newUser)
		if err == nil {
			SendWellCome(user)
		}
		user.Password = ""
	} else {
		log.Print("encontrou")
		err = errors.New("Usuario ja cadastrado")
		userExiste.Password = ""
		user = userExiste
	}
	return user, err
}

//FindUserByEmailAndPassword get user with email and correct password
func FindUserByEmailAndPassWord(email string, password string) (models.UserRegister, error) {
	encriptPass := encrypt(chave, password)
	user, err := database.FindUserByEmailAndPassWord(email, encriptPass)
	if err != nil {
		err = errors.New("Falha buscando usuario")
	}
	return user, err
}

var re = regexp.MustCompile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")

func validateEmail(email string) bool {
	return re.MatchString(email)
}

func encodeBase64(b []byte) string {
	return base64.StdEncoding.EncodeToString(b)
}

func decodeBase64(s string) []byte {
	data, err := base64.StdEncoding.DecodeString(s)
	if err != nil {
		panic(err)
	}
	return data
}

func encrypt(key, text string) string {
	block, err := aes.NewCipher([]byte(key))
	if err != nil {
		panic(err)
	}
	plaintext := []byte(text)
	cfb := cipher.NewCFBEncrypter(block, iv)
	ciphertext := make([]byte, len(plaintext))
	cfb.XORKeyStream(ciphertext, plaintext)
	return encodeBase64(ciphertext)
}

func decrypt(key, text string) string {
	block, err := aes.NewCipher([]byte(key))
	if err != nil {
		panic(err)
	}
	ciphertext := decodeBase64(text)
	cfb := cipher.NewCFBEncrypter(block, iv)
	plaintext := make([]byte, len(ciphertext))
	cfb.XORKeyStream(plaintext, ciphertext)
	return string(plaintext)
}
