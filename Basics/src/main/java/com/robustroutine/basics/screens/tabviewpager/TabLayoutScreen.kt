package com.robustroutine.basics.screens.tabviewpager

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.*
import com.robustroutine.basics.R
import com.robustroutine.common.components.AppBar
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TableLayoutScreen(
    onClickEvent: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = { onClickEvent() }
            )
        }) {
        MainContent()
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainContent() {

    val list = listOf(TabItem.Home,TabItem.Cart,TabItem.Profile)
    val pagerState = rememberPagerState(initialPage = 0)

    Column(modifier = Modifier.fillMaxSize()) {
        Tabs(tabs = list, pagerState = pagerState)
        TabContent(tabs = list, pagerState = pagerState)
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.primary,
        indicator = { tabPositions ->
            Modifier.pagerTabIndicatorOffset(pagerState = pagerState, tabPositions = tabPositions)
        }) {
        tabs.forEachIndexed { index, tabItem ->

            LeadingIconTab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {Text(tabItem.title) },
                icon = {Icon(imageVector = tabItem.icons,contentDescription = null)},
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.White,
                enabled = true
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(tabs:List<TabItem>,pagerState: PagerState) {
    HorizontalPager(count = tabs.size,state=pagerState) { page ->
        tabs[page].screens()
    }
}


@Composable
fun ScreenA() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFBEBAEE)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen A")
    }
}


@Composable
fun ScreenB() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF0B0AC)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen B")
    }
}


@Composable
fun ScreenC() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFD0ECB0)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text( text = "Screen C" )
    }
}