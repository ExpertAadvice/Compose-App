package com.robustroutine.authui.login

sealed class LoginEvent {
    data class EnteredUsername( val value: String): LoginEvent()
    data class EnteredPassword( val value: String): LoginEvent()
    object LoginButton: LoginEvent()
}