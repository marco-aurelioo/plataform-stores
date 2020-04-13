package models

import (
	"github.com/google/uuid"
)

type Message struct {
	ID               uuid.UUID
	NameFrom         string
	From             string
	Subject          string
	NameTo           string
	To               string
	PlainTextContent string
	HtmlContent      string
	Error            string
}
