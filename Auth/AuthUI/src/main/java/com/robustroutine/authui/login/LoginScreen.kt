package com.robustroutine.authui.login

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.hilt.navigation.compose.hiltViewModel
import com.robustroutine.authui.components.ButtonComponent
import com.robustroutine.authui.components.EmailTextField
import com.robustroutine.authui.components.LogoCard
import com.robustroutine.authui.components.PasswordTextField
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onForgetPassClick:() -> Unit,
    onRegisterClick:() -> Unit,
  //  viewModel: LoginViewModel = hiltViewModel()
) {

//    val usernameState = viewModel.username.value
//    val passwordState = viewModel.password.value

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = true) {
//        viewModel.eventFlow.collectLatest { event ->
//            when (event) {
//                is LoginViewModel.UiEvent.ShowSnackBar -> {
//                    scaffoldState.snackbarHostState.showSnackbar(
//                        message = event.message
//                    )
//                }
//                is LoginViewModel.UiEvent.LoginButtonEvent -> {
//                    onLoginClick()
//                }
//            }
//        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Text(
            modifier = Modifier.clickable { onLoginClick() },
            text = "Login",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }

/*{

        val constraints = ConstraintSet {
            val logo = createRefFor("logo")
            val emailEt = createRefFor("emailEt")
            val passwordEt = createRefFor("passwordEt")
            val forgetPass = createRefFor("forgetPass")
            val loginButton = createRefFor("loginButton")

            constrain(logo) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
            constrain(emailEt) {
                top.linkTo(logo.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
            constrain(passwordEt) {
                top.linkTo(emailEt.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
            constrain(forgetPass) {
                top.linkTo(passwordEt.bottom)
                end.linkTo(passwordEt.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
            constrain(loginButton) {
                top.linkTo(forgetPass.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }

        }
        ConstraintLayout(constraintSet = constraints, modifier = Modifier.fillMaxSize()) {

            LogoCard(
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .padding(top = 120.dp)
                    .layoutId("logo")
            )

            EmailTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp, start = 16.dp, end = 16.dp)
                    .layoutId("emailEt"),
                text = usernameState,
                hint = "Enter email",
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredUsername(it))
                },
                singleLine = true,
                imeAction = ImeAction.Next
            )

            PasswordTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 5.dp)
                    .layoutId("passwordEt"),
                text = passwordState,
                hint = "Enter password",
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredPassword(it))
                },
                singleLine = true,
                imeAction = ImeAction.Done,
                keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
            )

            Text(
                text = "Forget Password? Click Here",
                color = Color.Blue,
                modifier = Modifier
                    .layoutId("forgetPass")
                    .clickable {
                       onForgetPassClick()
                    }
                    .padding(top = 5.dp, end = 16.dp),
                textDecoration = TextDecoration.Underline,
                fontSize = 16.sp
            )

            ButtonComponent(
                text = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .layoutId("loginButton"),
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                onClick = {
                    viewModel.onEvent(LoginEvent.LoginButton)
                }
            )
        }
    }*/
}