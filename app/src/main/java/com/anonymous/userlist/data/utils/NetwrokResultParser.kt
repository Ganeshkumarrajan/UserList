package com.anonymous.userlist.data.utils

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onSuccess

@kotlin.jvm.Throws(Exception::class)
fun <I> getResult(data: ApiResponse<I>?): I? {
    var result: I? = null
    data?.onSuccess {
        result = this.data
    }?.onError {
        throw Exception("")
    }

    return result
}