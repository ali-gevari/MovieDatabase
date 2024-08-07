package com.example.moviedatabase.search.data.network

import com.example.moviedatabase.allShows.domain.entity.AllShows
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchShowsService {
    @GET("search/tv")
    suspend fun searchShows(@Query("query") query: String): AllShows
}