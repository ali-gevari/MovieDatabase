package com.example.moviedatabase.allMovies.domain.entity

data class NetworkError(
    val networkCallError: NetworkCallError,
    val throwable: Throwable? = null
)

enum class NetworkCallError(val message: String) {
    NetworkError("NetworkError"),
    UnknownError("UnknownError"),
    UnknownResponse("UnknownResponse")
}