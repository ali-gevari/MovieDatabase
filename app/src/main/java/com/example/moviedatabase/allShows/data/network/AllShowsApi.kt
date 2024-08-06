package com.example.moviedatabase.allShows.data.network

import com.example.moviedatabase.allShows.domain.entity.AllShows
import javax.inject.Inject
import retrofit2.Retrofit

open class AllShowsApi @Inject constructor(
    retrofit: Retrofit
) {
    private var allShowsService: AllShowsService = retrofit.create(AllShowsService::class.java)

    suspend fun getAllShows(): AllShows {
        return allShowsService.getAllShows()
    }
}