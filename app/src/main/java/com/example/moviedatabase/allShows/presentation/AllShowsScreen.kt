package com.example.moviedatabase.allShows.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviedatabase.compose.ShowCard
import com.example.moviedatabase.globalStates.ProgramsViewState
import com.example.moviedatabase.search.domain.entity.Program

@Composable
internal fun AllShowsScreen(
    viewModel: AllShowsViewModel = hiltViewModel(),
    onItemClick: (Program) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    AllShowsContent(state = state, onItemClick)
}

@Composable
fun AllShowsContent(
    state: ProgramsViewState,
    onItemClick: (Program) -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "TV Shows",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier
                .padding(top = 8.dp)
                .height(220.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.allPrograms) { program ->
                ShowCard(program = program, onClick = onItemClick)
            }
        }
    }
}