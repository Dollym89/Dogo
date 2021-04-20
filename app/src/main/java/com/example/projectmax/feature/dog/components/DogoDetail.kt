package com.example.projectmax.feature.dog.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.projectmax.common.utils.DEFAULT_IMAGE
import com.example.projectmax.common.utils.loadPicture
import com.example.projectmax.feature.dog.common.domain.Dog

@Composable
fun DogoDetail(
    dog: Dog
) {
    Column() {
        val image = loadPicture(url = dog.photoUrl, defaultImage = DEFAULT_IMAGE).value
        image?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Some selected dogo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )
        }
        dog.name.let {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            ) {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h3,
                    maxLines = 1,
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            ) {
                Text(
                    text = "Some Long Description",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h5,
                    maxLines = 1,
                )
            }
        }
    }
}