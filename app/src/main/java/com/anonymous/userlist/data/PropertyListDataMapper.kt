package com.anonymous.userlist.data

import com.anonymous.userlist.domain.PropertyListDomain

class PropertyListDataMapper : MapDataToDomain<PropertyListData, List<PropertyListDomain>> {
    override fun map(data: PropertyListData?): List<PropertyListDomain> =
        data?.items?.map {
            PropertyListDomain(
                it?.id ?: 0, it?.city ?: "", it?.area ?: 0.0, it?.url ?: ""
            )
        } ?: emptyList()

}