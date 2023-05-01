package com.anonymous.userlist.data

import com.anonymous.userlist.domain.PropertyListDomain
import com.anonymous.userlist.domain.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PropertyRepositoryImply(
    private val propertyService: PropertyService,
    private val propertyListDataMapper: MapDataToDomain<PropertyListData, List<PropertyListDomain>>
) : PropertyRepository {
    @kotlin.jvm.Throws(Exception::class)
    override suspend fun getProperties(): List<PropertyListDomain> =
        propertyListDataMapper.map(getResult(propertyService.propertyList()))

}
