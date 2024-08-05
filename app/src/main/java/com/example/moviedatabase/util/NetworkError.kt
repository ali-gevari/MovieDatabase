package com.example.moviedatabase.util

data class NetworkError(
    val networkCallError: NetworkCallError,
    val throwable: Throwable? = null
)

enum class NetworkCallError(val message: String) {
    NetworkError("NetworkError"),
    UnknownError("UnknownError"),
    UnknownResponse("UnknownResponse")
}