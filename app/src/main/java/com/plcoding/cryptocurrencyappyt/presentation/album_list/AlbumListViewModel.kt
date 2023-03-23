package com.plcoding.cryptocurrencyappyt.presentation.album_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_album.GetAlbumsUseCase
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(AlbumListState())
    val state: State<AlbumListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getAlbumsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AlbumListState(album = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = AlbumListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = AlbumListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}