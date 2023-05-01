package com.anonymous.userlist.presentation.di

import android.content.Context
import com.anonymous.userlist.domain.property_details.model.PropertyDetailsDomain
import com.anonymous.userlist.domain.property_list.model.PropertyListDomain
import com.anonymous.userlist.presentation.property_details.mapper.PropertyDetailsMapper
import com.anonymous.userlist.presentation.property_details.mapper.ResourceManger
import com.anonymous.userlist.presentation.property_details.mapper.ResourceMangerImpl
import com.anonymous.userlist.presentation.property_list.mapper.MapperDomainToUI
import com.anonymous.userlist.presentation.property_list.mapper.PropertyListUIMapper
import com.anonymous.userlist.ui.theme.component.properties.PropertyCardProperties
import com.anonymous.userlist.ui.theme.component.properties.PropertyDetailsProperties
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class ViewModuleModule {
    @Provides
    fun providePropertyListUIMapper(): MapperDomainToUI<List<PropertyListDomain>, List<PropertyCardProperties>> =
        PropertyListUIMapper()

    @Provides
    fun provideResourceManger(@ApplicationContext appContext: Context):
            ResourceManger =
        ResourceMangerImpl(appContext)

    @Provides
    fun providePropertyDetailsUIMapper(resourceManger: ResourceManger): MapperDomainToUI<PropertyDetailsDomain, PropertyDetailsProperties> =
        PropertyDetailsMapper(resourceManger)

}