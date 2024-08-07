package com.example.moviedatabase.search.domain

import com.example.moviedatabase.search.domain.entity.Program
import kotlinx.coroutines.flow.Flow

interface SearchProgramsRepository {
    fun searchPrograms(query: String): Flow<List<Program>>
}