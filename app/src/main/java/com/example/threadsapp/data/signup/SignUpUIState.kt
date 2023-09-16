package com.example.threadsapp.data.signup

data class SignUpUIState(
    var firstName :String = "",
    var lastName  :String = "",
    var userName  :String = "",
    var email  :String = "",
    var password  :String = "",

    var firstNameError :Boolean = true,
    var userNameError :Boolean = true,
    var lastNameError : Boolean = true,
    var emailError :Boolean = true,
    var passwordError : Boolean = true,

)