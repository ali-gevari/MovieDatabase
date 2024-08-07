package com.example.moviedatabase.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed interface Destination {
    val icon: ImageVector
    val route: String
}

data object Overview : Destination {
    override val icon = Icons.Filled.Home
    override val route = "overview"
}

data object Favourites : Destination {
    override val icon = Icons.Filled.Favorite
    override val route = "favourites"
}

data object Details : Destination {
    override val icon = Icons.Filled.Home
    override val route = "details"
    const val DETAILS_ARG = "details"
    val routeWithArgs = "$route/{$DETAILS_ARG}"
    val arguments = listOf(
        navArgument(DETAILS_ARG) { type = NavType.StringType }
    )
}

val bottomBarScreens = listOf(Overview, Favourites)