package com.example.moviedatabase.util.extensions

import com.example.moviedatabase.allMovies.domain.entity.Movie
import com.example.moviedatabase.allShows.domain.entity.Show
import com.example.moviedatabase.search.domain.entity.Program
import com.example.moviedatabase.search.domain.entity.ProgramType
import com.example.moviedatabase.util.Constant.IMAGE_BASE_URL

fun List<Movie>.updateMovieImage(): List<Movie> = this.map { movies ->
    movies.copy(posterPath = IMAGE_BASE_URL + movies.posterPath)
}

fun List<Show>.updateShowImage(): List<Show> = this.map { shows ->
    shows.copy(posterPath = IMAGE_BASE_URL + shows.posterPath)
}

fun List<Movie>.movieToProgram(): List<Program> {
    val programs = mutableListOf<Program>()
    this.forEach { movie ->
        programs.add(
            Program(
                id = movie.id,
                title = movie.title,
                image = movie.posterPath,
                programType = ProgramType.Movie
            )
        )
    }
    return programs
}

fun List<Show>.showToProgram(): List<Program> {
    val programs = mutableListOf<Program>()
    this.forEach { show ->
        programs.add(
            Program(
                id = show.id,
                title = show.title,
                image = show.posterPath,
                programType = ProgramType.Show
            )
        )
    }
    return programs
}