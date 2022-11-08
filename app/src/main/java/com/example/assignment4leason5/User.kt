package com.example.assignment4leason5

import java.io.Serializable

class User: Serializable {
    var emailAddress: String
    var passWord: String
    var firstName: String
    var lastName: String

    constructor(emailAddress: String, passWord: String, firstName: String, lastName: String) {
        this.emailAddress = emailAddress
        this.passWord = passWord
        this.firstName = firstName
        this.lastName = lastName
    }
}