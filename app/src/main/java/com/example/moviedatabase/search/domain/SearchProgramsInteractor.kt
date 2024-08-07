package com.example.moviedatabase.search.domain

import com.example.moviedatabase.search.domain.entity.Program
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SearchProgramsInteractor @Inject constructor(
    private val searchProgramsRepository: SearchProgramsRepository
) {
    operator fun invoke(query: String): Flow<List<Program>> =
        searchProgramsRepository.searchPrograms(query)
            .flowOn(Dispatchers.IO)
}