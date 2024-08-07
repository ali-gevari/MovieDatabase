package com.example.moviedatabase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviedatabase.compose.AppBottomBar
import com.example.moviedatabase.navigation.AppNavHost
import com.example.moviedatabase.globalEvents.Event
import com.example.moviedatabase.globalEvents.EventDispatcher
import com.example.moviedatabase.navigation.Overview
import com.example.moviedatabase.navigation.bottomBarScreens
import com.example.moviedatabase.ui.theme.MovieDatabaseTheme
import com.example.moviedatabase.util.extensions.navigateSingleTopTo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val lifecycle = LocalLifecycleOwner.current.lifecycle
            LaunchedEffect(key1 = lifecycle) {
                repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                    EventDispatcher.events.collect { event ->
                        if (event is Event.Toast) {
                            Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
            MovieDatabaseApp()
        }
    }
}

@Composable
fun MovieDatabaseApp() {
    MovieDatabaseTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            bottomBarScreens.find { it.route == currentDestination?.route }
                ?: Overview
        Scaffold(
            bottomBar = {
                AppBottomBar(
                    allScreens = bottomBarScreens,
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen,
                )
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = padding.calculateBottomPadding(),
                        top = padding.calculateTopPadding()
                    )
            ) {
                AppNavHost(navController = navController)
            }
        }
    }
}