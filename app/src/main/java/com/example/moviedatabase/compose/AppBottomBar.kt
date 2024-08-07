package com.example.moviedatabase.compose

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviedatabase.navigation.Destination
import com.example.moviedatabase.navigation.Overview
import com.example.moviedatabase.navigation.bottomBarScreens
import com.example.moviedatabase.ui.theme.MovieDatabaseTheme

@Composable
fun AppBottomBar(
    allScreens: List<Destination>,
    onTabSelected: (Destination) -> Unit,
    currentScreen: Destination
) {
    Surface(
        Modifier.height(56.dp)
    ) {
        Row(
            Modifier.selectableGroup(),
            horizontalArrangement = Arrangement.Center
        ) {
            allScreens.forEach { screen ->
                Tab(
                    modifier = Modifier.weight(1f),
                    text = screen.route,
                    icon = screen.icon,
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        }
    }
}

@Composable
private fun Tab(
    modifier: Modifier,
    text: String,
    icon: ImageVector,
    onSelected: () -> Unit,
    selected: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(16.dp)
            .fillMaxHeight()
            .selectable(
                selected = selected,
                onClick = onSelected,
                role = Role.Tab,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .clearAndSetSemantics { contentDescription = text }) {
        Icon(imageVector = icon, contentDescription = text, tint = Color.Black)
        Spacer(Modifier.width(12.dp))
        Text(text, color = Color.Black)
    }
}

@Preview
@Composable
private fun AppBottomBarPreview() {
    MovieDatabaseTheme {
        AppBottomBar(
            allScreens = bottomBarScreens,
            onTabSelected = {},
            currentScreen = Overview
        )
    }
}

@Preview
@Composable
private fun TabPreview() {
    MovieDatabaseTheme {
        Tab(
            text = "Overview",
            icon = Icons.Filled.Favorite,
            onSelected = { },
            selected = true,
            modifier = Modifier
        )
    }
}