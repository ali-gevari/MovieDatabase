package com.example.moviedatabase.details.presentation

import com.example.moviedatabase.details.domain.entity.ProgramDetails

data class ProgramDetailsViewState(
    val isLoading: Boolean = false,
    val programDetails: ProgramDetails = ProgramDetails(),
    val error: String? = null
)