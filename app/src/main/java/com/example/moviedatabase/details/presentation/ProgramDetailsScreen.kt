package com.example.moviedatabase.details.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviedatabase.compose.Banner
import com.example.moviedatabase.search.domain.entity.ProgramType
import com.example.moviedatabase.util.extensions.stringToEnum

@Composable
internal fun ProgramDetailsScreen(
    programId: String? = "",
    programType: String? = "",
    viewModel: ProgramDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val id = remember(programId) { programId ?: "Unknown ID" }
    val type = remember(programType) { programType ?: "Unknown Type" }.stringToEnum()
    LaunchedEffect(Unit) {
        viewModel.getProgramDetails(id, type ?: ProgramType.Show)
    }
    ProgramDetailsContent(state = state)
}

@Composable
fun ProgramDetailsContent(
    state: ProgramDetailsViewState
) {
    Banner(url = state.programDetails.posterPath)
}