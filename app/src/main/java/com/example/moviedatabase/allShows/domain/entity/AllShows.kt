package com.example.moviedatabase.allShows.domain.entity

import com.google.gson.annotations.SerializedName

data class AllShows(
    @field:SerializedName("results") val allShows: List<Show>
)

data class Show(
    @field:SerializedName("original_name") val title: String,
    @field:SerializedName("poster_path") val posterPath: String
)