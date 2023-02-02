package com.robustroutine.authui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.robustroutine.authui.R

@Composable
fun PasswordTextField(
    modifier: Modifier,
    text: String,
    fontSize: TextUnit = 18.sp,
    hint: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean,
    imeAction: ImeAction,
    keyboardActions: KeyboardActions = KeyboardActions(onDone = {})
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(
                text = hint,
                color = Color.Black
            )
        },
        textStyle = TextStyle.Default.copy(fontSize = fontSize),
        leadingIcon = {
            IconButton(onClick = {
            }) {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password Icon"
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = {
                isPasswordVisible = !isPasswordVisible
            })
            {
                Icon(
                    painter = if (isPasswordVisible) {
                        painterResource(id = R.drawable.ic_visibility_off)
                    } else {
                        painterResource(id = R.drawable.ic_visibility)
                    },
                    contentDescription = "Password Icon"
                )
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction,
        ),
        keyboardActions = keyboardActions
    )
}