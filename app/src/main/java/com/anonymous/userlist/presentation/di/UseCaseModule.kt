package com.anonymous.userlist.presentation

import com.anonymous.userlist.domain.GetPropertyListUseCase
import com.anonymous.userlist.domain.GetPropertyListUseCaseImpl
import com.anonymous.userlist.domain.PropertyRepository
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
}
