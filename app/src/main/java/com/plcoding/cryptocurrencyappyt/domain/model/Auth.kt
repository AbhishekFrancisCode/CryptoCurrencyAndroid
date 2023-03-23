package com.plcoding.cryptocurrencyappyt.domain.model

import com.plcoding.cryptocurrencyappyt.data.remote.dto.authVerification.Data

data class Auth(
    val `data`: Data,
    val statusCode: Int,
    val success: String
)
