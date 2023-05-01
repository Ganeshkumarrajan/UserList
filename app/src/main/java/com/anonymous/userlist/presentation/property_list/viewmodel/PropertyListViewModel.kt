package com.anonymous.userlist.presentation.property_list

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.userlist.domain.GetPropertyListUseCase
import com.anonymous.userlist.domain.NetworkResult
import com.anonymous.userlist.domain.PropertyListDomain
import com.anonymous.userlist.presentation.UIState
import com.anonymous.userlist.ui.theme.component.PropertyCardProperties
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyListViewModel @Inject constructor(
    private val getPropertyListUseCase:
    GetPropertyListUseCase,
    private val mapperDomainToUI: MapperDomainToUI<List<PropertyListDomain>, List<PropertyCardProperties>>
) :
    ViewModel() {
    private val _properties =
        mutableStateOf<UIState<List<PropertyCardProperties>>>(UIState.Loading())
    val properties = _properties

    init {
        getProperties()
    }

    private fun getProperties() {
        viewModelScope.launch {
            getPropertyListUseCase.invoke().collectLatest {
                parsePropertyListResult(it)
            }
        }

    }

    private fun parsePropertyListResult(data: NetworkResult<List<PropertyListDomain>>) {
        when (data) {
            is NetworkResult.Success -> {
                properties.value = UIState.Success(mapperDomainToUI.map(data = data.data))
            }
            is NetworkResult.Error -> {
                properties.value = UIState.Error()
            }
        }
    }


}