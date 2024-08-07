package com.example.moviedatabase.allMovies.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviedatabase.compose.MovieCard
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.moviedatabase.globalStates.ProgramsViewState

@Composable
internal fun AllMoviesScreen(
    viewModel: AllMoviesViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    AllMoviesContent(state = state, onItemClick)
}

@Composable
fun AllMoviesContent(
    state: ProgramsViewState,
    onItemClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "Movies",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyRow(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .height(360.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(state.allPrograms) { program ->
                MovieCard(program = program, onClick = onItemClick)
            }
        }
    }
}