package com.example.moviedatabase.details.domain

import com.example.moviedatabase.details.domain.entity.ProgramDetails
import com.example.moviedatabase.search.domain.entity.ProgramType
import kotlinx.coroutines.flow.Flow

interface ProgramDetailsRepository {
    fun getProgramDetails(
        programId: String,
        programType: ProgramType
    ): Flow<ProgramDetails>
}