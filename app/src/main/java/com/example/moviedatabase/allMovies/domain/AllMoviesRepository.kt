package com.example.moviedatabase.allMovies.domain

import com.example.moviedatabase.search.domain.entity.Program
import kotlinx.coroutines.flow.Flow

interface AllMoviesRepository {
    fun getAllMovies(): Flow<List<Program>>
}