package com.anonymous.userlist.presentation.utils

sealed class UIState<T> {
    data class Success<T>(val data:T): UIState<T>()
    class Error<T>:  UIState<T>()
    class Loading<T>:  UIState<T>()
}