package com.example.moviedatabase.allMovies.data.network

import com.example.moviedatabase.allMovies.domain.entity.AllMovies
import retrofit2.http.GET

interface AllMoviesApi {
    @GET("movie")
    suspend fun getAllMovies(): AllMovies
}