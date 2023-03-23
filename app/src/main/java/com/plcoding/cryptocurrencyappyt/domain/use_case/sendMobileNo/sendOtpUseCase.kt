package com.plcoding.cryptocurrencyappyt.domain.use_case.sendMobileNo

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Auth
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.requestModel.MobileVerify
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class sendOtpUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<Auth>> = flow {
        try {
            emit(Resource.Loading<Auth>())
           // val coins = repository.getAuth(MobileVerify("9845449281", 91))
           // emit(Resource.Success<Auth>(coins.))
        } catch(e: HttpException) {
            emit(Resource.Error<Auth>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<Auth>("Couldn't reach server. Check your internet connection."))
        }
    }
}