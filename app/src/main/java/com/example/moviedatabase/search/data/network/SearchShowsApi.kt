package com.example.moviedatabase.search.data.network

import com.example.moviedatabase.allShows.domain.entity.AllShows
import javax.inject.Inject
import retrofit2.Retrofit

open class SearchShowsApi @Inject constructor(
    retrofit: Retrofit
) {
    private var searchShowsService: SearchShowsService =
        retrofit.create(SearchShowsService::class.java)

    suspend fun searchShows(query: String): AllShows {
        return searchShowsService.searchShows(query)
    }
}