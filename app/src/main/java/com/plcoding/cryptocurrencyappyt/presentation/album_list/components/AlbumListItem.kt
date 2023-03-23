package com.plcoding.cryptocurrencyappyt.presentation.album_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.domain.model.Album


@Composable
fun AlbumListItem(
    album: Album
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        coilImage(album.url)
        Text(
            text = "${album.title}",
            color = Color.Green,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}