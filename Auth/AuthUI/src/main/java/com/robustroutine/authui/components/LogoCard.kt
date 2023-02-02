package com.robustroutine.authui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.robustroutine.authui.R

@Composable
fun LogoCard(
    modifier: Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}