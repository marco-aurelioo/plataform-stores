package services

import (
	"bytes"
	"errors"
	"fmt"
	"log"
	"net/http"
	"plataform-stores/auth-customer/models"
)

func SendWellCome(user models.UserRegister) error {
	var err error
	url := "http://localhost:8002/msg"
	log.Println("URL:>", url)

	var jsonStr = []byte(fmt.Sprintf("{	\"NameFrom\" :\"tiozao\",\"From\":\"marcoaureliooms@gmail.com\",\"Subject\":\"Bem vindo\",\"NameTo\":\"%s\",\"To\":\"%s\",\"PlainTextContent\":\"Bem vindo %s , seu cadastro foi realziado com sucesso\",\"HtmlContent\":\"<h1>Bem vindo %s , seu cadastro foi realziado com sucesso</h1>\"}", user.Name, user.Email, user.Name, user.Name))
	req, err := http.NewRequest("POST", url, bytes.NewBuffer(jsonStr))
	//req.Header.Set("X-Custom-Header", "myvalue")
	req.Header.Set("Content-Type", "application/json")
	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		log.Print("Erro ao enviar email de boas vindas.")
		err = errors.New("Erro ao enviar email de boas vindas.")
	} else {
		defer resp.Body.Close()
	}
	return err
	//fmt.Println("response Status:", resp.Status)
	//fmt.Println("response Headers:", resp.Header)
	//body, _ := ioutil.ReadAll(resp.Body)
	//fmt.Println("response Body:", string(body))
}
