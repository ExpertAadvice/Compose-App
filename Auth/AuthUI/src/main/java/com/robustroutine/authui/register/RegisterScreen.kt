package com.robustroutine.authui.register

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreen(
    onRegisterButtonClicked: () -> Unit,
  //  viewModel: RegisterViewModel = hiltViewModel()
) {
    //    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val firstName = remember {
        mutableStateOf("")
    }
    val lastName = remember {
        mutableStateOf("")
    }
    val username = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val confirmPassword = remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        scaffoldState = scaffoldState
    ) {

        val constraints = ConstraintSet {
            val logo = createRefFor("logo")
            val firstNameEt = createRefFor("firstNameEt")
            val lastNameEt = createRefFor("lastNameEt")
            val emailEt = createRefFor("emailEt")
            val passwordEt = createRefFor("passwordEt")
            val confirmPasswordEt = createRefFor("confirmPasswordEt")
            val registerButton = createRefFor("registerButton")

            constrain(logo) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
            constrain(firstNameEt) {
                top.linkTo(logo.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
            constrain(lastNameEt) {
                top.linkTo(firstNameEt.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
            constrain(emailEt) {
                top.linkTo(lastNameEt.bottom)
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
            constrain(confirmPasswordEt) {
                top.linkTo(passwordEt.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
            constrain(registerButton) {
                top.linkTo(confirmPasswordEt.bottom)
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
                    .layoutId("logo")
                    .padding(top = 50.dp)
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 16.dp, end = 16.dp)
                    .layoutId("firstNameEt"),
                value = firstName.value,
                onValueChange = { firstName.value = it },
                label = {
                    Text(
                        text = "Enter first name",
                        color = Color.Black
                    )
                },
                textStyle = TextStyle.Default.copy(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, start = 16.dp, end = 16.dp)
                    .layoutId("lastNameEt"),
                value = lastName.value,
                onValueChange = { lastName.value = it },
                label = {
                    Text(
                        text = "Enter last name",
                        color = Color.Black
                    )
                },
                textStyle = TextStyle.Default.copy(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            EmailTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, start = 16.dp, end = 16.dp)
                    .layoutId("emailEt"),
                text = username.value,
                hint = "Enter email",
                onValueChange = {

                },
                singleLine = true,
                imeAction = ImeAction.Next
            )

            PasswordTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 5.dp)
                    .layoutId("passwordEt"),
                text = password.value,
                hint = "Enter your password",
                onValueChange = {

                },
                singleLine = true,
                imeAction = ImeAction.Next,
            )

            PasswordTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, start = 16.dp, end = 16.dp)
                    .layoutId("confirmPasswordEt"),
                text = confirmPassword.value,
                hint = "Confirm your password",
                onValueChange = {

                },
                singleLine = true,
                imeAction = ImeAction.Done,
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                })
            )

            ButtonComponent(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .layoutId("registerButton"),
                text = "Register",
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                onClick = {
                    onRegisterButtonClicked()
                }
            )
        }
    }
}
