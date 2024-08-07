package com.example.moviedatabase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviedatabase.allShows.presentation.AllShowsScreen
import com.example.moviedatabase.compose.DetailsScreen
import com.example.moviedatabase.compose.OverviewScreen
import com.example.moviedatabase.util.extensions.navigateToDetails

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Overview.route
    ) {
        composable(route = Overview.route) {
            OverviewScreen(
                onItemClick = { details ->
                    navController.navigateToDetails(details)
                }
            )
        }

        composable(route = Favourites.route) {
            AllShowsScreen()
        }

        composable(
            route = Details.routeWithArgs,
            arguments = Details.arguments
        ) { navBackStackEntry ->
            val details =
                navBackStackEntry.arguments?.getString(Details.DETAILS_ARG)
            DetailsScreen(details)
        }
    }
}