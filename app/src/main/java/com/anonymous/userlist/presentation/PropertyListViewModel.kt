package com.anonymous.userlist.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.userlist.domain.GetPropertyListUseCase
import com.anonymous.userlist.domain.NetworkResult
import com.anonymous.userlist.domain.PropertyListDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyListViewModel @Inject constructor(private val getPropertyListUseCase: GetPropertyListUseCase) :
    ViewModel() {
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
                Log.d("d",data.data.toString())
            }
            is NetworkResult.Error -> {

            }
        }
    }


}