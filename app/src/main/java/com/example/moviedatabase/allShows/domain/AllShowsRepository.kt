package com.example.moviedatabase.allShows.domain

import com.example.moviedatabase.search.domain.entity.Program
import kotlinx.coroutines.flow.Flow

interface AllShowsRepository {
    fun getAllShows(): Flow<List<Program>>
}