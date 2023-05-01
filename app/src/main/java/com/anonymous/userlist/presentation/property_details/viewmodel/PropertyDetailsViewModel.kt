package com.anonymous.userlist.presentation.property_details.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.userlist.domain.property_details.GetPropertyDetailsUseCase
import com.anonymous.userlist.domain.property_details.model.PropertyDetailsDomain
import com.anonymous.userlist.domain.utils.NetworkResult
import com.anonymous.userlist.presentation.property_list.mapper.MapperDomainToUI
import com.anonymous.userlist.presentation.utils.UIState
import com.anonymous.userlist.ui.theme.component.properties.PropertyDetailsProperties
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyDetailsViewModel @Inject constructor(
    private val getPropertyDetailsUseCase: GetPropertyDetailsUseCase,
    private val mapper: MapperDomainToUI<PropertyDetailsDomain, PropertyDetailsProperties>
) :
    ViewModel() {
    private val _properties =
        mutableStateOf<UIState<PropertyDetailsProperties>>(UIState.Loading())
    val properties = _properties

    fun getPropertyDetails(id: String) {
        viewModelScope.launch {
            getPropertyDetailsUseCase.invoke(id).collectLatest {
                parsePropertyDetailsResult(it)
            }
        }
    }

    private fun parsePropertyDetailsResult(data: NetworkResult<PropertyDetailsDomain>) {
        when (data) {
            is NetworkResult.Success -> {
                _properties.value = UIState.Success(mapper.map(data.data))
            }
            is NetworkResult.Error -> {
                _properties.value = UIState.Error()
            }
        }
    }
}