package com.kash.stockticker.data.remote

import com.kash.stockticker.data.remote.model.rate.RatesResponse
import com.kash.stockticker.data.remote.model.rate_time_period.TwoDaysWithBase
import com.kash.stockticker.data.remote.model.symbol.SymbolResponse
import com.kash.stockticker.data.remote.model.ticker.StockFeed
import com.kash.stockticker.data.remote.network.ResultWrapper

interface IRemoteDataManager {
    suspend fun getCurrenciesWithDetail() : ResultWrapper<SymbolResponse>
    suspend fun getStockFeed() : ResultWrapper<StockFeed>
    suspend fun getLatestRatesAsync(): ResultWrapper<RatesResponse>
    suspend fun getRatesOfDateAsync(date:String): ResultWrapper<RatesResponse>
    suspend fun getLatestWithBaseAsync(baseCode:String): ResultWrapper<RatesResponse>
    suspend fun getRatesOfDateWithBaseAsync(date: String,baseCode: String): ResultWrapper<RatesResponse>
    suspend fun getRatesBetweenTwoTimeAsync(endAt:String,startAt:String,symbol:String,base:String): ResultWrapper<TwoDaysWithBase>
}