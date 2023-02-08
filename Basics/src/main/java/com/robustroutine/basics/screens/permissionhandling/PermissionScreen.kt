package com.robustroutine.basics.screens.permissionhandling

import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.robustroutine.basics.screens.tabviewpager.MainContent
import com.robustroutine.basics.utils.isPermanentlyDenied
import com.robustroutine.common.components.AppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PermissionScreen(
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
        PermissionHandler()
    }
}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionHandler() {

    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )
    )

    val lifeCycleOwner = LocalLifecycleOwner.current
    DisposableEffect(
        key1 = lifeCycleOwner,
        effect = {
            val observer = LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_START) {
                    permissionState.launchMultiplePermissionRequest()
                }
            }
            lifeCycleOwner.lifecycle.addObserver(observer)

            onDispose {
                lifeCycleOwner.lifecycle.removeObserver(observer)
            }
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        permissionState.permissions.forEach { perm ->
            when (perm.permission) {
                Manifest.permission.CAMERA -> {
                    when {
                        perm.hasPermission -> {
                            ShowMessage(text = "Camera Permission Accepted")
                        }
                        perm.shouldShowRationale -> {
                            ShowMessage(text = "Camera Permission is needed to access the camera")
                        }
                        perm.isPermanentlyDenied() -> {
                            ShowMessage(text = "Camera Permission was permanently denied you can enable it in app setting")
                        }
                    }
                }
                Manifest.permission.RECORD_AUDIO -> {
                    when {
                        perm.hasPermission -> {
                            ShowMessage(text = "Audio Permission Accepted")
                        }
                        perm.shouldShowRationale -> {
                            ShowMessage(text = "Audio Permission is needed to access the camera")
                        }
                        perm.isPermanentlyDenied() -> {
                            ShowMessage(text = "Audio Permission was permanently denied you can enable it in app setting")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShowMessage(
    text: String
) {
    Text(
        text =  text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 10.dp),
        textAlign = TextAlign.Center
    )
}