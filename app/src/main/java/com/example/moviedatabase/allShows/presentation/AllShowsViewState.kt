package com.example.moviedatabase.allShows.presentation

import com.example.moviedatabase.allShows.domain.entity.Show

data class AllShowsViewState(
    val isLoading: Boolean = false,
    val allShows: List<Show> = emptyList(),
    val error: String? = null
)