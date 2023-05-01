package com.anonymous.userlist.data.service

import com.anonymous.userlist.data.model.PropertyDetailsData
import com.anonymous.userlist.data.model.PropertyListData
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PropertyService {
    @GET("listings.json")
    suspend fun propertyList(): ApiResponse<PropertyListData>

    @GET("listings/{id}.json")
    suspend fun propertyDetails(@Path("id")id:String): ApiResponse<PropertyDetailsData>
}