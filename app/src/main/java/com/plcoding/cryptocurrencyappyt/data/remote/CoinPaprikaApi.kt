package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.AlbumDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.domain.model.Auth
import com.plcoding.cryptocurrencyappyt.domain.model.requestModel.MobileVerify
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CoinPaprikaApi {

    //GET

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    @GET("photos")
    suspend fun getAlbumList() : List<AlbumDto>

    //POST

    @POST("/v1/auth/send-otp")
    suspend fun sendMobileNo(@Body mobileNo: MobileVerify) : Call<Auth>

}