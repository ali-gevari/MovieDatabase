package com.example.moviedatabase.details.data.network

import com.example.moviedatabase.details.domain.entity.ProgramDetails
import javax.inject.Inject
import retrofit2.Retrofit

open class MovieDetailsApi @Inject constructor(
    retrofit: Retrofit
) {
    private var movieDetailsService = retrofit.create(MovieDetailsService::class.java)

    suspend fun getMovieDetails(programId: String): ProgramDetails {
        return movieDetailsService.getMovieDetails(programId)
    }
}