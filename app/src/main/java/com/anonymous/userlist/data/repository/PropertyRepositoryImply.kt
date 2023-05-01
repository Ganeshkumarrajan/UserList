package com.anonymous.userlist.data.repository

import com.anonymous.userlist.data.model.PropertyListData
import com.anonymous.userlist.data.service.PropertyService
import com.anonymous.userlist.data.utils.getResult
import com.anonymous.userlist.data.mapper.MapDataToDomain
import com.anonymous.userlist.domain.property_list.model.PropertyListDomain
import com.anonymous.userlist.domain.PropertyRepository

class PropertyRepositoryImply(
    private val propertyService: PropertyService,
    private val propertyListDataMapper: MapDataToDomain<PropertyListData, List<PropertyListDomain>>
) : PropertyRepository {
    @kotlin.jvm.Throws(Exception::class)
    override suspend fun getProperties(): List<PropertyListDomain> =
        propertyListDataMapper.map(getResult(propertyService.propertyList()))

}
