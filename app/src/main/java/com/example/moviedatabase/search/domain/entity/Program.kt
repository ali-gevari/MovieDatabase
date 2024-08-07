package com.example.moviedatabase.search.domain.entity

data class Program(
    val title: String,
    val image: String,
    val programType: ProgramType
)

enum class ProgramType {
    Movie, Show
}