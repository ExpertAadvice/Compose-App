package com.robustroutine.common.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.robustroutine.common.R

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit,
    navigationIcon: ImageVector = Icons.Default.ArrowBack,
    contentDescription: String? = null
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick ) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = "Toggle drawer"
                )
            }
        }
    )
}