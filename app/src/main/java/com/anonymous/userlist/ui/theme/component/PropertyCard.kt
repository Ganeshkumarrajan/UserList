package com.anonymous.userlist.ui.theme.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
                AreaName(properties.areaSize)
            }

        }
    }
}

@Composable
private fun CityName(name: String) {
    Text(text = name)
}

@Composable
private fun AreaName(size: String) {
    Text(text = size)
}

@Composable
private fun PropertyImage(url: String, modifier: Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .build(),
        modifier = modifier,
        contentScale = ContentScale.Crop,
        contentDescription = "ImageRequest example",
    )
}


@Preview
@Composable
fun PreViewPropertyCard() {
    MaterialTheme() {
        PropertyCard(PropertyCardProperties(1, "cityName", "", "245 M")) {

        }
    }

}

