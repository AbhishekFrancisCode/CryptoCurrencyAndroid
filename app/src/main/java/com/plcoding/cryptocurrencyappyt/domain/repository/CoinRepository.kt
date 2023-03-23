package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.AlbumDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.domain.model.Auth
import com.plcoding.cryptocurrencyappyt.domain.model.requestModel.MobileVerify
import retrofit2.Call

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

    suspend fun getAlbum(): List<AlbumDto>

    suspend fun getAuth(mobile: MobileVerify): Call<Auth>
}