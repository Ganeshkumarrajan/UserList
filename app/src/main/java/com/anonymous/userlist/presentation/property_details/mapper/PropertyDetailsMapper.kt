package com.anonymous.userlist.presentation.property_details.mapper

import android.content.Context
import com.anonymous.userlist.R
import com.anonymous.userlist.domain.property_details.model.PropertyDetailsDomain
import com.anonymous.userlist.presentation.property_list.mapper.MapperDomainToUI
import com.anonymous.userlist.ui.theme.component.properties.PropertyDetailsProperties

class PropertyDetailsMapper(private val resourceManger: ResourceManger) :
    MapperDomainToUI<PropertyDetailsDomain, PropertyDetailsProperties> {
    override fun map(data: PropertyDetailsDomain): PropertyDetailsProperties =
        PropertyDetailsProperties(
            "${resourceManger.getString(R.string.city_name)} ${data.cityName}",
            data.imageURL,
            "${resourceManger.getString(R.string.area_size)} ${data.areaSize}",
            "${resourceManger.getString(R.string.rooms)} ${data.roomsCount}",
            "${resourceManger.getString(R.string.professional)} ${data.professional}",
        )

}


interface ResourceManger {
    fun getString(id: Int): String
}

class ResourceMangerImpl(val context: Context) : ResourceManger {
    override fun getString(id: Int): String =
        context.getString(id)
}
