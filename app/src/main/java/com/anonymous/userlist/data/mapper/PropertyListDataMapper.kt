package com.anonymous.userlist.data.mapper

import com.anonymous.userlist.data.model.PropertyListData
import com.anonymous.userlist.domain.property_list.model.PropertyListDomain

class PropertyListDataMapper : MapDataToDomain<PropertyListData, List<PropertyListDomain>> {
    override fun map(data: PropertyListData?): List<PropertyListDomain> =
        data?.items?.map {
            PropertyListDomain(
                it?.id ?: 0, it?.city ?: "", it?.area ?: 0.0, it?.url ?: ""
            )
        } ?: emptyList()

}