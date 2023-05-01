package com.anonymous.userlist.data

interface MapDataToDomain<I,O> {
    fun map(data:I?):O
}