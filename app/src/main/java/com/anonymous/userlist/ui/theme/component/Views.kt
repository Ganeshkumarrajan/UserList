package com.anonymous.userlist.ui.theme.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CityName(name: String) {
    Text(text = name, style = MaterialTheme.typography.h6)
}

@Composable
fun SubTitle(text: String) {
    Text(text = text, style = MaterialTheme.typography.body2)
}

@Composable
fun PropertyImage(url: String, modifier: Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .build(),
        modifier = modifier,
        contentScale = ContentScale.Crop,
        contentDescription = "ImageRequest example",
    )
}