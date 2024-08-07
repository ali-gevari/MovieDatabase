package com.example.moviedatabase.globalStates

import com.example.moviedatabase.search.domain.entity.Program

data class ProgramsViewState(
    val isLoading: Boolean = false,
    val allPrograms: List<Program> = emptyList(),
    val error: String? = null
)