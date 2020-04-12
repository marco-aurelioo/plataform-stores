package models

//UserRegister using to create and autheticate on plataform
type UserRegister struct {
	ID       int64
	Email    string
	Password string
	Name     string
	NickName string
}
