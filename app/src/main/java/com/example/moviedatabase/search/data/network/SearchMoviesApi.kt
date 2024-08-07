package com.example.moviedatabase.search.data.network

import com.example.moviedatabase.allMovies.domain.entity.AllMovies
import javax.inject.Inject
import retrofit2.Retrofit

open class SearchMoviesApi @Inject constructor(
    retrofit: Retrofit
) {
    private var searchMoviesService: SearchMoviesService =
        retrofit.create(SearchMoviesService::class.java)

    suspend fun searchMovies(query: String): AllMovies {
        return searchMoviesService.searchMovies(query)
    }
}