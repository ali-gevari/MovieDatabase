package com.example.moviedatabase.details.domain

import com.example.moviedatabase.details.domain.entity.ProgramDetails
import com.example.moviedatabase.search.domain.entity.ProgramType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProgramDetailsInteractor @Inject constructor(
    private val programDetailsRepository: ProgramDetailsRepository
) {
    operator fun invoke(
        programId: String, programType: ProgramType
    ): Flow<ProgramDetails> =
        programDetailsRepository.getProgramDetails(programId, programType).flowOn(Dispatchers.IO)
}