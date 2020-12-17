package com.kash.stockticker.data.remote.service

import com.kash.stockticker.data.remote.model.symbol.SymbolResponse
import com.kash.stockticker.data.remote.model.ticker.StockFeed
import com.kash.stockticker.utils.AppConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Kanish Roshan on 07/12/20.
 */
interface IStockFeedModelService {
    @GET(AppConstants.API_URL_FEED)
    fun getStockFeed(): Deferred<Response<StockFeed>>
}