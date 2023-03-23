package com.plcoding.cryptocurrencyappyt.data.remote.dto.authVerification


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("code")
    val code: Int,
    @SerializedName("mobile")
    val mobile: String
)