package com.example.moviedatabase.search.presentation

import com.example.moviedatabase.search.domain.entity.Program

data class SearchProgramsViewState(
    val isLoading: Boolean = false,
    val allPrograms: List<Program> = emptyList(),
    val error: String? = null
)