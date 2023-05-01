package com.anonymous.userlist.ui.theme.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anonymous.userlist.ui.theme.component.properties.PropertyCardProperties

@Composable
fun PropertyCard(properties: PropertyCardProperties, onItemClick: (String) -> (Unit)) {
    Card(
        Modifier
            .padding(5.dp)
            .clickable {
                onItemClick.invoke(properties.id.toString())
            }) {

        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PropertyImage(properties.imageURL, Modifier.size(100.dp))

            Column(Modifier.padding(5.dp)) {
                CityName(properties.cityName)
                SubTitle(properties.areaSize)
            }

        }
    }
}




@Preview
@Composable
fun PreViewPropertyCard() {
    MaterialTheme {
        PropertyCard(PropertyCardProperties(1, "cityName", "", "245 M")) {

        }
    }

}

