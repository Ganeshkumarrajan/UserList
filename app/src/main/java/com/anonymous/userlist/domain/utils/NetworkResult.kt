package com.anonymous.userlist.domain

import kotlinx.coroutines.flow.Flow

sealed class NetworkResult<T> {
    data class Success<T>(val data: List<PropertyListDomain>) : NetworkResult<T>()
    class Error<T>() : NetworkResult<T>()
}
