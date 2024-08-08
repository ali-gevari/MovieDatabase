package com.example.moviedatabase.details.data.network

import com.example.moviedatabase.details.domain.entity.ProgramDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsService {
    @GET("movie/{programId}")
    suspend fun getMovieDetails(@Path("programId") programId: String): ProgramDetails
}