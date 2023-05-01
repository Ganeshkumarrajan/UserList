package com.anonymous.userlist.presentation.property_list.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.anonymous.userlist.presentation.utils.UIState
import com.anonymous.userlist.presentation.property_list.viewmodel.PropertyListViewModel
import com.anonymous.userlist.ui.theme.ScreenNames
import com.anonymous.userlist.ui.theme.component.PropertyCard
import com.anonymous.userlist.ui.theme.component.properties.PropertyCardProperties

@Composable
fun PropertyListScreen(
    navController: NavController,
    viewModel: PropertyListViewModel = hiltViewModel()
) {
    Column {
        when (val result = viewModel.properties.value) {
            is UIState.Success -> {
                ShowItems(result.data, navController)
            }
            else ->{

            }
        }

    }
}

@Composable
fun ShowItems(data: List<PropertyCardProperties>, navController: NavController) {
    LazyColumn {
        items(data) { item ->
            PropertyCard(properties = item) {
                navController.navigate("${ScreenNames.PropertyDetails.route}/$it")
            }
        }
    }
}
