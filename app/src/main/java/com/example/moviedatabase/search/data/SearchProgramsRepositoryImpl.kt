package com.example.moviedatabase.search.data

import com.example.moviedatabase.search.data.network.SearchMoviesApi
import com.example.moviedatabase.search.data.network.SearchShowsApi
import com.example.moviedatabase.search.domain.SearchProgramsRepository
import com.example.moviedatabase.search.domain.entity.Program
import com.example.moviedatabase.util.extensions.movieToProgram
import com.example.moviedatabase.util.extensions.showToProgram
import com.example.moviedatabase.util.extensions.updateMovieImage
import com.example.moviedatabase.util.extensions.updateShowImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchProgramsRepositoryImpl @Inject constructor(
    private val searchMoviesApi: SearchMoviesApi,
    private val searchShowsApi: SearchShowsApi
) : SearchProgramsRepository {

    override fun searchPrograms(query: String): Flow<List<Program>> = flow {
        val moviesAsProgram = searchMoviesApi.searchMovies(query)
            .allMovies
            .updateMovieImage()
            .movieToProgram()
        val showsAsProgram = searchShowsApi.searchShows(query)
            .allShows
            .updateShowImage()
            .showToProgram()

        val allPrograms = mutableListOf<Program>().apply {
            addAll(moviesAsProgram)
            addAll(showsAsProgram)
        }
        emit(allPrograms)
    }
}