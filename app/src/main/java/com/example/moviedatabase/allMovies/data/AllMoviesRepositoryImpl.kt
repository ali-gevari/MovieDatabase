package com.example.moviedatabase.allMovies.data

import com.example.moviedatabase.allMovies.data.network.AllMoviesApi
import com.example.moviedatabase.allMovies.domain.entity.Movie
import com.example.moviedatabase.allMovies.domain.AllMoviesRepository
import com.example.moviedatabase.util.extensions.updateMovieImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllMoviesRepositoryImpl @Inject constructor(
    private val allMoviesApi: AllMoviesApi
) : AllMoviesRepository {

    override fun getAllMovies(): Flow<List<Movie>> = flow {
        val data = allMoviesApi.getAllMovies()
            .allMovies
            .updateMovieImage()
        emit(data)
    }
}