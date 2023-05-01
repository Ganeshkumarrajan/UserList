package com.anonymous.userlist.presentation.di

import com.anonymous.userlist.domain.property_list.usecase.GetPropertyListUseCase
import com.anonymous.userlist.domain.property_list.usecase.GetPropertyListUseCaseImpl
import com.anonymous.userlist.domain.PropertyRepository
import com.anonymous.userlist.domain.property_details.GetPropertyDetailsUseCase
import com.anonymous.userlist.domain.property_details.GetPropertyDetailsUseCaseImply
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Provides
    fun provideGetPropertyListUseCase(propertyRepository: PropertyRepository): GetPropertyListUseCase =
        GetPropertyListUseCaseImpl(propertyRepository, Dispatchers.IO)

    @Provides
    fun provideGetPropertyDetailsUseCase(propertyRepository: PropertyRepository): GetPropertyDetailsUseCase =
        GetPropertyDetailsUseCaseImply(propertyRepository, Dispatchers.IO)
}
