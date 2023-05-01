package com.anonymous.userlist.domain

import com.anonymous.userlist.domain.property_details.model.PropertyDetailsDomain
import com.anonymous.userlist.domain.property_list.model.PropertyListDomain

interface PropertyRepository {
    @Throws(Exception::class)
    suspend fun getProperties(): List<PropertyListDomain>

    @Throws(Exception::class)
    suspend fun getPropertyDetails(id:String): PropertyDetailsDomain
}
