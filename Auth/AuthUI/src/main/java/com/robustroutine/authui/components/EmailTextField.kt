package com.robustroutine.authui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun EmailTextField(
    modifier: Modifier,
    text: String,
    fontSize: TextUnit = 18.sp,
    hint: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean,
    imeAction: ImeAction,
    keyboardActions: KeyboardActions = KeyboardActions( onDone = {})
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        singleLine = singleLine,
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
                    imageVector = Icons.Filled.Email,
                    contentDescription = "E-Mail Icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions
    )
}