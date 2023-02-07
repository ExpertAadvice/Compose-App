package com.robustroutine.composeapp.home_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.robustroutine.common.components.AppBar
import com.robustroutine.composeapp.ui.theme.LightBlue
import com.robustroutine.composeapp.utils.TopicList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onClick: (String) -> Unit,
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = { },
                navigationIcon = Icons.Default.Menu
            )
        }) {
        RecyclerView(onClick)
    }
}


@Composable
fun RecyclerView(visitClick: (String) -> Unit) {

    val names: List<String> = TopicList.getList()

    LazyColumn(modifier = Modifier.padding(4.dp)) {

        items(items = names) { name ->
            ItemCard(name = name, visitClick)
        }
    }
}

@Composable
fun ItemCard(name: String, visitClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable { visitClick(name) },
        shape = RoundedCornerShape(10.dp),
        backgroundColor = LightBlue,
        elevation = 5.dp,
        contentColor = Color.Black
    ) {
        Text(
            modifier = Modifier.padding(15.dp),
            text = name,
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center,
        )
    }

}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//
//}