package com.example.moviedatabase.search.domain.entity

data class Program(
    val id: String,
    val title: String,
    val image: String,
    val programType: ProgramType
)

enum class ProgramType(val type: String) {
    Movie("Movie"),
    Show("Show")
}