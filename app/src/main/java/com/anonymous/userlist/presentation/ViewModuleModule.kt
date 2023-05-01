package com.anonymous.userlist.presentation

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class ViewModuleModule {
//    @Provides
//    fun provideDeviceHolderUIMapper(): DomainToUIMapper<List<DeviceHolderDomain>, List<DeviceHolderItemProperties>> =
//        DeviceHolderMapperDomainToUi()
//
//    @Provides
//    fun provideUserDetailsMapper(): UserDetailsMapperDomainToUI = UserDetailsMapperDomainToUI()
}