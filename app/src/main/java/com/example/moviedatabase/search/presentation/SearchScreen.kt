package com.example.moviedatabase.search.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviedatabase.compose.ProgramCard

@Composable
internal fun SearchScreen(
    viewModel: SearchProgramsViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val query by viewModel.query.collectAsStateWithLifecycle()
    SearchContent(searchProgramsViewState = state, viewModel, query, onItemClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchContent(
    searchProgramsViewState: SearchProgramsViewState,
    viewModel: SearchProgramsViewModel,
    query: String,
    onItemClick: (String) -> Unit
) {

    var active by rememberSaveable { mutableStateOf(false) }
    val keyboard = LocalSoftwareKeyboardController.current

    Column(
        Modifier.fillMaxWidth()
    ) {
        DockedSearchBar(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally),
            query = query,
            onQueryChange = { viewModel.updateQuery(it) },
            onSearch = {
                keyboard?.hide()
                viewModel.searchMovies(it)
                active = false
            },
            active = false,
            onActiveChange = { active = it },
            placeholder = { Text("Search...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) }
        ) { }
    }
    AnimatedVisibility(
        visible = searchProgramsViewState.allPrograms.isNotEmpty(),
        enter = scaleIn(
            initialScale = 0.5f,
            animationSpec = tween(durationMillis = 500)
        ) + fadeIn(animationSpec = tween(durationMillis = 500)),
        exit = scaleOut(
            targetScale = 0.5f,
            animationSpec = tween(durationMillis = 500)
        ) + fadeOut(animationSpec = tween(durationMillis = 500))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(minSize = 170.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(searchProgramsViewState.allPrograms) { program ->
                    ProgramCard(program = program, onClick = onItemClick)
                }
            }
        }
    }
}