package com.example.moviedatabase.allMovies.data.network

import com.example.moviedatabase.allMovies.domain.entity.AllMovies
import javax.inject.Inject
import retrofit2.Retrofit

open class AllMoviesApi @Inject constructor(
    retrofit: Retrofit
) {
    private var allMoviesService: AllMoviesService = retrofit.create(AllMoviesService::class.java)

    suspend fun getAllMovies(): AllMovies {
        return allMoviesService.getAllMovies()
    }
}