package com.example.moviedatabase.util.extensions

import coil.network.HttpException
import com.example.moviedatabase.allMovies.domain.entity.NetworkCallError
import com.example.moviedatabase.allMovies.domain.entity.NetworkError
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when(this) {
        is IOException -> NetworkCallError.NetworkError
        is HttpException -> NetworkCallError.UnknownResponse
        else -> NetworkCallError.UnknownError
    }
    return NetworkError(
        networkCallError = error,
        this
    )
}