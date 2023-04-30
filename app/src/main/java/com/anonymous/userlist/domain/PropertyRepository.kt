package com.anonymous.userlist.domain

interface PropertyRepository {
    @Throws(Exception::class)
    fun getProperties(): List<PropertyListDomain>
}
