package com.example.moviedatabase.util.extensions

import coil.network.HttpException
import com.example.moviedatabase.util.NetworkCallError
import com.example.moviedatabase.util.NetworkError
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