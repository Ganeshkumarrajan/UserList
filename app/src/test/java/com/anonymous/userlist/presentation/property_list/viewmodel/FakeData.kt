package com.anonymous.userlist.presentation.property_list.viewmodel

import com.anonymous.userlist.domain.property_list.model.PropertyListDomain
import com.anonymous.userlist.domain.utils.NetworkResult
import com.anonymous.userlist.ui.theme.component.properties.PropertyCardProperties
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun getPropertyFakeFlowList(): Flow<NetworkResult<List<PropertyListDomain>>> = flow {
    emit(NetworkResult.Success(getFakeDomainData()))
}

fun getFakeDomainData(): List<PropertyListDomain> =
    listOf(
        PropertyListDomain(1, "city name", 132.3, "url"),
        PropertyListDomain(2, "city name 2", 132.3, "url")
    )

fun getFakeUIData(): List<PropertyCardProperties> =
    listOf(
        PropertyCardProperties(1, "city name", "132.3", "url"),
        PropertyCardProperties(2, "city name 2", "132.3", "url")
    )
