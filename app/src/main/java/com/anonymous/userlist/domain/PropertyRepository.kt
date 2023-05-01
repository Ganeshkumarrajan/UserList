package com.anonymous.userlist.domain

import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    @Throws(Exception::class)
    suspend fun getProperties(): List<PropertyListDomain>
}
