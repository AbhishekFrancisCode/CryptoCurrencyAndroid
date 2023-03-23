package com.plcoding.cryptocurrencyappyt.presentation.album_list

import com.plcoding.cryptocurrencyappyt.domain.model.Album

data class AlbumListState (
    val isLoading: Boolean = false,
    val album : List<Album> = emptyList(),
    val error: String = ""
)