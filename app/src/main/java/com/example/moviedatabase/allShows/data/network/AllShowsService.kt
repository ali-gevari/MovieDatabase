package com.example.moviedatabase.allShows.data.network

import com.example.moviedatabase.allShows.domain.entity.AllShows
import retrofit2.http.GET

interface AllShowsService {
    @GET("tv")
    suspend fun getAllShows(): AllShows
}