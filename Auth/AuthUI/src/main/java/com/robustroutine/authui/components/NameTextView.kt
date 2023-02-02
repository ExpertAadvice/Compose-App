package com.robustroutine.authui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun NameTextView(
    modifier: Modifier,
    text: String,
    label: String,
    onValueChange: (message: String)-> Unit,
    fontSize: TextUnit = 16.sp
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                color = Color.Black
            )
        },
        textStyle = TextStyle.Default.copy(fontSize = fontSize),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
    )
}