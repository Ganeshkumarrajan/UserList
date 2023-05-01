package com.anonymous.userlist.presentation.property_list.viewmodel

import com.anonymous.userlist.domain.property_list.model.PropertyListDomain
import com.anonymous.userlist.domain.property_list.usecase.GetPropertyListUseCase
import com.anonymous.userlist.presentation.property_list.mapper.MapperDomainToUI
import com.anonymous.userlist.ui.theme.component.properties.PropertyCardProperties
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anonymous.userlist.presentation.utils.UIState
import io.mockk.coEvery
import kotlinx.coroutines.test.runTest
import org.junit.Test

class PropertyListViewModelTest {
    private val userListUseCase: GetPropertyListUseCase = mockk()
    private lateinit var viewModel: PropertyListViewModel
    private val mapper: MapperDomainToUI<List<PropertyListDomain>, List<PropertyCardProperties>> =
        mockk()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getPropertySuccessCase() {
        runTest {

            coEvery {
                userListUseCase.invoke()
            } returns getPropertyFakeFlowList()

            coEvery {
                mapper.map(getFakeDomainData())
            } returns getFakeUIData()

            viewModel = PropertyListViewModel(userListUseCase, mapper)

            assert(viewModel.properties.value is UIState.Success)
        }
    }

}
