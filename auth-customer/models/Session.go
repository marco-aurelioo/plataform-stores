package models

import (
	"github.com/google/uuid"
)

//Session structure on services
type Session struct {
	ID       uuid.UUID
	State    string
	Rules    string
	Name     string
	NickName string
	Email    string
}
