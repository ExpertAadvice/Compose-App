package com.robustroutine.authui.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _username = mutableStateOf("")
    val username: State<String> = _username

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EnteredUsername -> {
                _username.value = event.value
            }
            is LoginEvent.EnteredPassword -> {
                _password.value = event.value
            }
            is LoginEvent.LoginButton -> {

               viewModelScope.launch {
                   _eventFlow.emit(UiEvent.LoginButtonEvent)
               }

              /*  viewModelScope.launch {
                    try {

                        val loginServiceParam = LoginServiceParam(
                            emailAddress = "jignesh.der@alliancetek.com",
                            password = "Test@123" + password.value.trim(),
                            deviceToken = "ABC",
                            registerType = 1,
                            deviceType = 1
                        )
                        authUseCases.loginUseCase.invoke(loginServiceParam).collect {
                            when (it) {
                                is Resource.Success -> {
                                    if (!it.value.status) {
                                        _eventFlow.emit(UiEvent.ShowSnackBar(it.value.message))
                                    } else {
                                        _eventFlow.emit(UiEvent.LoginButtonEvent)
                                    }
                                }
                                is Resource.Failure -> _eventFlow.emit(UiEvent.ShowSnackBar(it.errorBody.toString()))
                                else -> {
                                   // ProgressBar
                                }
                            }
                        }
                    } catch (e: HttpException) {
                        _eventFlow.emit(UiEvent.ShowSnackBar(e.toString()))
                    }
                }*/
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
        object LoginButtonEvent : UiEvent()
    }
}