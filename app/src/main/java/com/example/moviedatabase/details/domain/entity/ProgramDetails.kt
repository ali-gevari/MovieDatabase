package com.example.moviedatabase.details.domain.entity

import com.google.gson.annotations.SerializedName

data class ProgramDetails(
    @field:SerializedName("id") val id: String = "",
    @field:SerializedName("name") val name: String? = null,
    @field:SerializedName("title") val title: String? = null,
    @field:SerializedName("overview") val overview: String = "",
    @field:SerializedName("poster_path") val posterPath: String = "",
)