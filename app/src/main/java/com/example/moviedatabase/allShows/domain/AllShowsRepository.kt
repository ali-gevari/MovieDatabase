package com.example.moviedatabase.allShows.domain

import com.example.moviedatabase.allShows.domain.entity.Show
import kotlinx.coroutines.flow.Flow

interface AllShowsRepository {
    fun getAllShows(): Flow<List<Show>>
}