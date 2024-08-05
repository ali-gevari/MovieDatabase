package com.example.moviedatabase.allMovies.domain

import com.example.moviedatabase.allMovies.domain.entity.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AllMoviesInteractor @Inject constructor(
    private val allMoviesRepository: AllMoviesRepository
) {
    operator fun invoke(): Flow<List<Movie>> = allMoviesRepository.getAllMovies()
        .flowOn(Dispatchers.IO)
}