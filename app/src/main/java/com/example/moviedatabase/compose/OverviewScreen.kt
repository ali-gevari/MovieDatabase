package com.example.moviedatabase.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviedatabase.allMovies.presentation.AllMoviesScreen
import com.example.moviedatabase.allShows.presentation.AllShowsScreen
import com.example.moviedatabase.search.domain.entity.Program
import com.example.moviedatabase.search.presentation.SearchScreen

@Composable
fun OverviewScreen(
    onItemClick: (Program) -> Unit
) {
    Column {
        Spacer(Modifier.height(16.dp))
        SearchScreen(onItemClick = onItemClick)
        AllMoviesScreen(onItemClick = onItemClick)
        AllShowsScreen(onItemClick = onItemClick)
    }
}