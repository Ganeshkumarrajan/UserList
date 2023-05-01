package com.anonymous.userlist.domain.property_details.model

data class PropertyDetailsDomain(
    val cityName: String,
    val imageURL: String,
    val roomsCount: Int,
    val areaSize: Double,
    val professional: String
)