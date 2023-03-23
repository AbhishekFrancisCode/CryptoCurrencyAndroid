package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.remote.dto.AlbumDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.domain.model.Auth
import com.plcoding.cryptocurrencyappyt.domain.model.requestModel.MobileVerify
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import retrofit2.Call
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

    override suspend fun getAlbum(): List<AlbumDto> {
        return api.getAlbumList()
    }

    override suspend fun getAuth(mobile:MobileVerify): Call<Auth> {
        return api.sendMobileNo(mobile)
    }
}