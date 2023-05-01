package com.anonymous.userlist.domain.utils

import com.anonymous.userlist.domain.property_list.model.PropertyListDomain

sealed class NetworkResult<T> {
    data class Success<T>(val data: List<PropertyListDomain>) : NetworkResult<T>()
    class Error<T>: NetworkResult<T>()
}
