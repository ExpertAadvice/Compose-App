package com.robustroutine.composeapp.home_screen

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robustroutine.composeapp.ui.theme.Blue
import com.robustroutine.composeapp.ui.theme.LightBlue

@Composable
fun HomeScreen(
    onClick: (String) -> Unit,
) {
    RecyclerView(onClick)

}

@Composable
fun ListItem(name: String, visitClick: (String) -> Unit ) {

    val expanded = remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded.value) 5.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    
    Surface(
        color = LightBlue,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {

            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Course")
                    Text(
                        text = name,
                        style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                }

                OutlinedButton(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Blue,
                        contentColor = LightBlue,
                        disabledBackgroundColor = Blue,
                        disabledContentColor = Color.White
                    ),
                    onClick = {
                    expanded.value = !expanded.value
                }) {
                    Text(
//                        modifier = Modifier.clickable { },
                        text = if (expanded.value) "Show Less" else "Show More"
                    )
                }
            }

            if (expanded.value) {
                Column(modifier = Modifier.padding(
                    bottom = extraPadding.coerceAtLeast(0.dp)
                )) {

                    Text(text = "This is additional info. This is reserved block for some content!!!!1")

                    OutlinedButton(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Blue,
                            contentColor = LightBlue,
                            disabledBackgroundColor = Blue,
                            disabledContentColor = Color.White
                        ),
                        onClick = { visitClick(name) },
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(top = 4.dp, bottom = 5.dp)
                    ) {
                        Text(text = "Visit $name")
                    }
                }
            }
        }
    }
}

@Composable
fun RecyclerView(visitClick: (String) -> Unit) {

    val names: List<String> = List(100){"$it"}
    
    LazyColumn(modifier = Modifier.padding(4.dp)) {

        items(items= names) { name->
            ListItem(name = name, visitClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){

}