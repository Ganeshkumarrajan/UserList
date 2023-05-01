package com.anonymous.userlist.presentation.property_list.mapper

import com.anonymous.userlist.domain.property_list.model.PropertyListDomain
import com.anonymous.userlist.ui.theme.component.properties.PropertyCardProperties

class PropertyListUIMapper :
    MapperDomainToUI<List<PropertyListDomain>, List<PropertyCardProperties>> {
    override fun map(data: List<PropertyListDomain>): List<PropertyCardProperties> =
        data.map {
            PropertyCardProperties(
                it.id,
                it.cityName, it.propertyImage, "${it.area.toInt()} M"
            )
        }


}

interface MapperDomainToUI<I, O> {
    fun map(data: I): O
}