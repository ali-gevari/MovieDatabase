package com.example.moviedatabase.details.data.network

import com.example.moviedatabase.details.domain.entity.ProgramDetails
import javax.inject.Inject
import retrofit2.Retrofit

open class ShowDetailsApi @Inject constructor(
    retrofit: Retrofit
) {
    private var showDetailsService = retrofit.create(ShowDetailsService::class.java)

    suspend fun getShowDetails(programId: String): ProgramDetails {
        return showDetailsService.getShowDetails(programId)
    }
}