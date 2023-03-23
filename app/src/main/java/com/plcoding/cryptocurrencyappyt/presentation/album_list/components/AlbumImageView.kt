package com.plcoding.cryptocurrencyappyt.presentation.album_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun coilImage(imageUrl: String){
    Box(modifier = Modifier
        .width(100.dp)
        .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(100.dp,100.dp)
        )
    }
}