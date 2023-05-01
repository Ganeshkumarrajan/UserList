package com.anonymous.userlist.data.service

import com.anonymous.userlist.data.model.PropertyListData
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface PropertyService {
    @GET("listings.json")
    suspend fun propertyList(): ApiResponse<PropertyListData>
}