package com.example.moviedatabase.allMovies.data.repository

import com.example.moviedatabase.allMovies.data.network.AllMoviesApi
import com.example.moviedatabase.allMovies.domain.entity.Movie
import com.example.moviedatabase.allMovies.domain.repository.AllMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllMoviesRepositoryImpl @Inject constructor(
    private val allMoviesApi: AllMoviesApi
) : AllMoviesRepository {

    override fun getAllMovies(): Flow<List<Movie>> = flow {
        val data = allMoviesApi.getAllMovies().allMovies
        emit(data)
    }
}