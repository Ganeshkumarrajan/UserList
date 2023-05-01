package com.anonymous.userlist.data.model

data class PropertyListData(
    val items: List<Item?>?,
    val totalCount: Int?
)

data class Item(
    val area: Double?,
    val bedrooms: Int?,
    val city: String?,
    val id: Int?,
    val offerType: Int?,
    val price: Double?,
    val professional: String?,
    val propertyType: String?,
    val rooms: Int?,
    val url: String?
)