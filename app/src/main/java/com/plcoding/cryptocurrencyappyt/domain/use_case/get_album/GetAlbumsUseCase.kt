package com.plcoding.cryptocurrencyappyt.domain.use_case.get_album;

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toAlbum
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Album
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject;

class GetAlbumsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Album>>> = flow {
        try {
            emit(Resource.Loading<List<Album>>())
            val album = repository.getAlbum().map { it.toAlbum() }
            emit(Resource.Success<List<Album>>(album))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Album>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Album>>("Couldn't reach server. Check your internet connection."))
        }
    }
}
