package com.plcoding.cryptocurrencyappyt.data.remote.dto.authVerification


import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domain.model.Auth

data class AuthVerify(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("success")
    val success: String
)

fun AuthVerify.toAuth() : Auth {
    return Auth(
        data = data,
        statusCode = statusCode,
        success  = success
    )
}