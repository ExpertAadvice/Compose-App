package com.robustroutine.basics.screens.home

import android.annotation.SuppressLint
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.robustroutine.basics.theme.Blue
import com.robustroutine.basics.theme.LightBlue
import com.robustroutine.basics.utils.CourseList
import com.robustroutine.common.components.AppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BasicScreen(
    onClickEvent: (String) -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = { onClickEvent("exit") }
            )
        }) {
        RecyclerView(onClickEvent)
    }
}


@Composable
fun RecyclerView(visitClick: (String) -> Unit) {

    val names: List<String> = CourseList.getList()

    LazyColumn(modifier = Modifier.padding(4.dp)) {

        items(items= names) { name->
            ListItem(name = name, visitClick)
        }
    }
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
                        style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.SemiBold
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
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 4.dp, bottom = 5.dp)
                    ) {
                        Text(text = "Visit $name")
                    }
                }
            }
        }
    }
}