package com.anonymous.userlist.domain.property_details

import com.anonymous.userlist.domain.PropertyRepository
import com.anonymous.userlist.domain.property_details.model.PropertyDetailsDomain
import com.anonymous.userlist.domain.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

interface GetPropertyDetailsUseCase {
    suspend fun invoke(id: String): Flow<NetworkResult<PropertyDetailsDomain>>
}

class GetPropertyDetailsUseCaseImply(
    private val propertyRepository: PropertyRepository,
    private val coroutineContext: CoroutineContext
) : GetPropertyDetailsUseCase {
    override suspend fun invoke(id: String): Flow<NetworkResult<PropertyDetailsDomain>> =
        flow<NetworkResult<PropertyDetailsDomain>> {
            emit(NetworkResult.Success(propertyRepository.getPropertyDetails(id)))
        }.catch {
            emit(NetworkResult.Error())
        }.flowOn(coroutineContext)

}