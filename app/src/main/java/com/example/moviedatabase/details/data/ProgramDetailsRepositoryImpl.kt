package com.example.moviedatabase.details.data

import com.example.moviedatabase.details.data.network.MovieDetailsApi
import com.example.moviedatabase.details.data.network.ShowDetailsApi
import com.example.moviedatabase.details.domain.ProgramDetailsRepository
import com.example.moviedatabase.details.domain.entity.ProgramDetails
import com.example.moviedatabase.search.domain.entity.ProgramType
import com.example.moviedatabase.util.extensions.updateProgramImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProgramDetailsRepositoryImpl @Inject constructor(
    private val movieDetailsApi: MovieDetailsApi,
    private val showDetailsApi: ShowDetailsApi
) : ProgramDetailsRepository {

    override fun getProgramDetails(
        programId: String,
        programType: ProgramType
    ): Flow<ProgramDetails> = flow {
        when (programType) {
            ProgramType.Show -> {
                val data = showDetailsApi.getShowDetails(programId)
                    .updateProgramImage()
                emit(data)
            }

            ProgramType.Movie -> {
                val data = movieDetailsApi.getMovieDetails(programId)
                    .updateProgramImage()
                emit(data)
            }
        }

    }
}