package com.example.moviedatabase.search.data.network

import com.example.moviedatabase.allMovies.domain.entity.AllMovies
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchMoviesService {
    @GET("search/movie")
    suspend fun searchMovies(@Query("query") query: String): AllMovies
}