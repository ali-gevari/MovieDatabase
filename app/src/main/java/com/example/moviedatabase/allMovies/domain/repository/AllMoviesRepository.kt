package com.example.moviedatabase.allMovies.domain.repository

import com.example.moviedatabase.allMovies.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface AllMoviesRepository {
    fun getAllMovies(): Flow<List<Movie>>
}