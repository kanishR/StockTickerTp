package com.kash.stockticker.data.remote.service

import com.kash.stockticker.data.remote.model.symbol.SymbolResponse
import com.kash.stockticker.utils.AppConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ICurrencyModelService {

    @GET(AppConstants.API_URL_MODEL)
    fun getCurrenciesWithDetail(): Deferred<Response<SymbolResponse>>
}