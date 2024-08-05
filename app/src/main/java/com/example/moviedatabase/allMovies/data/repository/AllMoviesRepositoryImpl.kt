package com.example.moviedatabase.allMovies.data.repository

import arrow.core.Either
import com.example.moviedatabase.allMovies.data.mapper.toNetworkError
import com.example.moviedatabase.allMovies.data.network.AllMoviesApi
import com.example.moviedatabase.allMovies.domain.entity.Movie
import com.example.moviedatabase.allMovies.domain.entity.NetworkError
import com.example.moviedatabase.allMovies.domain.repository.AllMoviesRepository
import javax.inject.Inject

class AllMoviesRepositoryImpl @Inject constructor(
    private val allMoviesApi: AllMoviesApi
) : AllMoviesRepository {

    override suspend fun getAllMovies(): Either<NetworkError, List<Movie>> {
        return Either.catch {
            allMoviesApi.getAllMovies().allMovies
        }.mapLeft { it.toNetworkError() }
    }
}