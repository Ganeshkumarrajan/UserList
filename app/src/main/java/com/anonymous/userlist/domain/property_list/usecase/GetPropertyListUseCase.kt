package com.anonymous.userlist.domain.property_list.usecase

import com.anonymous.userlist.domain.PropertyRepository
import com.anonymous.userlist.domain.property_list.model.PropertyListDomain
import com.anonymous.userlist.domain.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

interface GetPropertyListUseCase {
    fun invoke(): Flow<NetworkResult<List<PropertyListDomain>>>
}

class GetPropertyListUseCaseImpl(
    private val propertyRepository: PropertyRepository,
    private val coroutineContext: CoroutineContext
) :
    GetPropertyListUseCase {
    override fun invoke(): Flow<NetworkResult<List<PropertyListDomain>>> =
        flow<NetworkResult<List<PropertyListDomain>>> {
            emit(NetworkResult.Success(propertyRepository.getProperties()))
        }.catch {
            print(it.localizedMessage)
            emit(NetworkResult.Error())
        }.flowOn(coroutineContext)

}
