package com.robustroutine.authui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonComponent(
    modifier: Modifier,
    text: String,
    fontSize: TextUnit = 16.sp,
    backgroundColor: Color,
    contentColor: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        onClick = onClick
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}