package com.example.moviedatabase.allShows.domain

import com.example.moviedatabase.search.domain.entity.Program
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AllShowsInteractor @Inject constructor(
    private val allShowsRepository: AllShowsRepository
) {
    operator fun invoke(): Flow<List<Program>> = allShowsRepository.getAllShows()
        .flowOn(Dispatchers.IO)
}