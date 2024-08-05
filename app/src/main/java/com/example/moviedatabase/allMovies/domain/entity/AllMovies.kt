package com.example.moviedatabase.allMovies.domain.entity

import com.google.gson.annotations.SerializedName

data class AllMovies(
    @field:SerializedName("results") val allMovies: List<Movie>
)

data class Movie(
    @field:SerializedName("title") val title: String,
    @field:SerializedName("poster_path") val posterPath: String
)
