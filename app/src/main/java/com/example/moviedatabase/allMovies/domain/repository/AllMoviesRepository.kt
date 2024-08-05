package com.example.moviedatabase.allMovies.domain.repository

import arrow.core.Either
import com.example.moviedatabase.allMovies.domain.entity.Movie
import com.example.moviedatabase.allMovies.domain.entity.NetworkError

interface AllMoviesRepository {
    suspend fun getAllMovies(): Either<NetworkError, List<Movie>>
}