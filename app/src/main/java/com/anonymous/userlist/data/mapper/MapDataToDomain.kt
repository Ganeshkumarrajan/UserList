package com.anonymous.userlist.data.mapper

interface MapDataToDomain<I,O> {
    fun map(data:I?):O
}