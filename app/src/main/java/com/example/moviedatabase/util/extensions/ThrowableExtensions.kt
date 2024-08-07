package com.example.moviedatabase.util.extensions

import coil.network.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): String = when (this) {
    is IOException -> NetworkCallError.NetworkError.message
    is HttpException -> NetworkCallError.UnknownResponse.message
    else -> NetworkCallError.UnknownError.message
}

enum class NetworkCallError(val message: String) {
    NetworkError("NetworkError"),
    UnknownError("UnknownError"),
    UnknownResponse("UnknownResponse")
}