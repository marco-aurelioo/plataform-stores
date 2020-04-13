package sendgrid

import (
	"log"
	"plataform-stores/messages-b2c/models"

	"github.com/google/uuid"

	"github.com/sendgrid/sendgrid-go"
	"github.com/sendgrid/sendgrid-go/helpers/mail"
)

//SendMessage send message to sendgrid provider
func SendMessage(message models.Message) models.Message {

	from := mail.NewEmail(message.NameFrom, message.From)
	subject := message.Subject
	to := mail.NewEmail(message.NameTo, message.To)
	plainTextContent := message.PlainTextContent
	htmlContent := message.HtmlContent
	msg := mail.NewSingleEmail(from, subject, to, plainTextContent, htmlContent)
	client := sendgrid.NewSendClient("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 ")
	response, err := client.Send(msg)
	if err != nil {
		log.Println(err)
		message.Error = err.Error()
	} else {
		message.ID, err = uuid.NewRandom()
		log.Print(message.ID.String())
		log.Println(response.StatusCode)
		log.Println(response.Body)
		log.Println(response.Headers)
	}
	return message
}
