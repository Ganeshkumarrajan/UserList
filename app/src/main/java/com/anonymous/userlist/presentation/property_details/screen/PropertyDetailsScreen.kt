package com.anonymous.userlist.presentation.property_details.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anonymous.userlist.presentation.property_details.viewmodel.PropertyDetailsViewModel
import com.anonymous.userlist.presentation.utils.UIState
import com.anonymous.userlist.ui.theme.component.SubTitle
import com.anonymous.userlist.ui.theme.component.CityName
import com.anonymous.userlist.ui.theme.component.PropertyImage
import com.anonymous.userlist.ui.theme.component.properties.PropertyDetailsProperties

@Composable
fun PropertyDetailsScreen(
    propertyID: String,
    propertyDetailsViewModel: PropertyDetailsViewModel = hiltViewModel()
) {
    LazyColumn {
        item {
            when (val item = propertyDetailsViewModel.properties.value) {
                is UIState.Success -> {
                    ShowPropertyDetails(item.data)
                }
                else -> {}
            }
            propertyDetailsViewModel.getPropertyDetails(propertyID)
        }
    }
}


@Composable
fun ShowPropertyDetails(data: PropertyDetailsProperties) {
    if (data.imageURL.isNotEmpty()) {
        PropertyImage(
            data.imageURL,
            Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }

    Column(Modifier.padding(15.dp)) {
        CityName(name = data.cityName)
        SubTitle(text = data.areaSize)
        SubTitle(text = data.roomCount)
        SubTitle(text = data.professional)
    }

}
