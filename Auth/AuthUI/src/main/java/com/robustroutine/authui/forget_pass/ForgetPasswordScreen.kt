package com.robustroutine.authui.forget_pass

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.robustroutine.authui.components.ButtonComponent
import com.robustroutine.authui.components.EmailTextField
import com.robustroutine.authui.components.LogoCard
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForgetPasswordScreen(
    onButtonClicked: () -> Unit,
    viewModel: ForgetPassViewModel = hiltViewModel()
) {
    //    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val username = remember {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = true) {
//        viewModel.eventFlow.collectLatest { event ->
//            when (event) {
//                is ForgetPassViewModel.UiEvent.ShowSnackBar -> {
//                    scaffoldState.snackbarHostState.showSnackbar(
//                        message = event.message
//                    )
//                }
//                is ForgetPassViewModel.UiEvent.ResetButton -> {
//                    onButtonClicked()
//                }
//            }
//        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {

        val constraints = ConstraintSet {
            val logo = createRefFor("logo")
            val emailEt = createRefFor("emailEt")
            val resetButton = createRefFor("resetButton")

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
            constrain(resetButton) {
                top.linkTo(emailEt.bottom)
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
                text = username.value,
                hint = "Enter email",
                onValueChange = {
                    username.value = it
                },
                singleLine =true,
                imeAction = ImeAction.Done,
                keyboardActions = KeyboardActions( onDone = {
                    keyboardController?.hide()
                })
            )

            ButtonComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .layoutId("resetButton"),
                text = "Reset Password",
                backgroundColor =  Color.Blue,
                contentColor = Color.White,
                onClick = {
                    onButtonClicked()
                }
            )
        }
    }
}