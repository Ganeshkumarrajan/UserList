package com.anonymous.userlist.domain

sealed class NetworkResult<T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    class Error<T>() : NetworkResult<T>()
}
