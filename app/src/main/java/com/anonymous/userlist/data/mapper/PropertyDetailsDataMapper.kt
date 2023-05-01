package com.anonymous.userlist.data.mapper

import com.anonymous.userlist.data.model.PropertyDetailsData
import com.anonymous.userlist.domain.property_details.model.PropertyDetailsDomain

class PropertyDetailsDataMapper : MapDataToDomain<PropertyDetailsData, PropertyDetailsDomain> {
    override fun map(data: PropertyDetailsData?): PropertyDetailsDomain =
        PropertyDetailsDomain(
            data?.city ?: "",
            data?.url ?: "", data?.rooms ?: 0, data?.area ?: 0.0,
            data?.professional ?: ""
        )
}
