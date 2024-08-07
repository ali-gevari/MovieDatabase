package com.example.moviedatabase.allShows.data

import com.example.moviedatabase.allShows.data.network.AllShowsApi
import com.example.moviedatabase.allShows.domain.AllShowsRepository
import com.example.moviedatabase.search.domain.entity.Program
import com.example.moviedatabase.util.extensions.showToProgram
import com.example.moviedatabase.util.extensions.updateShowImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllShowsRepositoryImpl @Inject constructor(
    private val allShowsApi: AllShowsApi
) : AllShowsRepository {

    override fun getAllShows(): Flow<List<Program>> = flow {
        val data = allShowsApi.getAllShows()
            .allShows
            .updateShowImage()
            .showToProgram()
        emit(data)
    }
}