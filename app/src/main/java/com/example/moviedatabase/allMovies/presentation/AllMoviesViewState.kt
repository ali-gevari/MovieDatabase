package com.example.moviedatabase.allMovies.presentation

import com.example.moviedatabase.allMovies.domain.entity.Movie

data class AllMoviesViewState(
    val isLoading: Boolean = false,
    val allMovies: List<Movie> = emptyList(),
    val error: String? = null
)