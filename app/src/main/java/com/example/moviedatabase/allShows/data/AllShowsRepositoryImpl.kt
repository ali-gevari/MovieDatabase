package com.example.moviedatabase.allShows.data

import com.example.moviedatabase.allShows.data.network.AllShowsApi
import com.example.moviedatabase.allShows.domain.AllShowsRepository
import com.example.moviedatabase.allShows.domain.entity.Show
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllShowsRepositoryImpl @Inject constructor(
    private val allShowsApi: AllShowsApi
) : AllShowsRepository {

    override fun getAllShows(): Flow<List<Show>> = flow {
        val data = allShowsApi.getAllShows().allShows
        emit(data)
    }
}