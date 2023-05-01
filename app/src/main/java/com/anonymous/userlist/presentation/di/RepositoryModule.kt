package com.anonymous.userlist.presentation.di

import com.anonymous.userlist.data.mapper.MapDataToDomain
import com.anonymous.userlist.data.mapper.PropertyDetailsDataMapper
import com.anonymous.userlist.data.mapper.PropertyListDataMapper
import com.anonymous.userlist.data.model.PropertyDetailsData
import com.anonymous.userlist.data.model.PropertyListData
import com.anonymous.userlist.data.repository.PropertyRepositoryImply
import com.anonymous.userlist.data.service.PropertyService
import com.anonymous.userlist.domain.property_list.model.PropertyListDomain
import com.anonymous.userlist.domain.PropertyRepository
import com.anonymous.userlist.domain.property_details.model.PropertyDetailsDomain
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun providePropertyListDataToDomainMapper():
            MapDataToDomain<PropertyListData, List<PropertyListDomain>> =
        PropertyListDataMapper()

    @Provides
    fun providePropertyDetailsDataToDomainMapper():
            MapDataToDomain<PropertyDetailsData, PropertyDetailsDomain> =
        PropertyDetailsDataMapper()


    @Provides
    fun providePropertyRepository(
        mapper: MapDataToDomain<PropertyListData, List<PropertyListDomain>>,
        service: PropertyService,
        detailsMapper: MapDataToDomain<PropertyDetailsData, PropertyDetailsDomain>
        ): PropertyRepository =
        PropertyRepositoryImply(service, mapper,detailsMapper)
}
