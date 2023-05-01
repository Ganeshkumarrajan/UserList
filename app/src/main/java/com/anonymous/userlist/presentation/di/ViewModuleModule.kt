package com.anonymous.userlist.presentation.di

import com.anonymous.userlist.domain.property_list.model.PropertyListDomain
import com.anonymous.userlist.presentation.property_list.mapper.MapperDomainToUI
import com.anonymous.userlist.presentation.property_list.mapper.PropertyListUIMapper
import com.anonymous.userlist.ui.theme.component.properties.PropertyCardProperties
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class ViewModuleModule {
    @Provides
    fun providePropertyListUIMapper(): MapperDomainToUI<List<PropertyListDomain>, List<PropertyCardProperties>> =
        PropertyListUIMapper()

}