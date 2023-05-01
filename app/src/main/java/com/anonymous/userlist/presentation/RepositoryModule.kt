package com.anonymous.userlist.presentation

import com.anonymous.userlist.data.*
import com.anonymous.userlist.domain.PropertyListDomain
import com.anonymous.userlist.domain.PropertyRepository
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
    fun providePropertyRepository(
        mapper: MapDataToDomain<PropertyListData, List<PropertyListDomain>>,
        service: PropertyService,

        ): PropertyRepository =
        PropertyRepositoryImply(service, mapper)
}
