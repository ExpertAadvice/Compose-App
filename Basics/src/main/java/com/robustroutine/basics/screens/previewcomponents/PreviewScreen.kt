package com.robustroutine.basics.screens.previewcomponents

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robustroutine.common.components.AppBar
import com.robustroutine.common.components.AutoResizedText
import com.robustroutine.common.components.GradientButton

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PreviewScreen(
    onBackPress: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = { onBackPress() }
            )
        }) {
        Column(
            modifier = Modifier.fillMaxSize(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .width(100.dp)
                    .background(Color.LightGray)
            ) {
                AutoResizedText(
                    text = "Hello world",
                    style = MaterialTheme.typography.h2,
                )
            }

            GradientButton(
                modifier = Modifier.padding(8.dp),
                text = "Click Me",
                textColor = Color.White,
                gradient = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF642B73), Color(0xFFC6426E),
                    )
                ),
                onClick = { onBackPress() }
            )
        }
    }
}