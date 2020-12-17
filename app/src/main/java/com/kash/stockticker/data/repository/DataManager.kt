package com.kash.stockticker.data.repository

import com.kash.stockticker.data.remote.RemoteDataManager
import com.kash.stockticker.data.remote.model.rate.RatesResponse
import com.kash.stockticker.data.remote.model.rate_time_period.TwoDaysWithBase
import com.kash.stockticker.data.remote.model.symbol.Symbol
import com.kash.stockticker.data.remote.model.symbol.SymbolResponse
import com.kash.stockticker.data.remote.model.ticker.StockFeed
import com.kash.stockticker.data.remote.network.ResultWrapper

class DataManager(
    private val remoteDataManager: RemoteDataManager):IDataManager {

    override suspend fun getCurrenciesWithDetail(): ResultWrapper<SymbolResponse>  =
        remoteDataManager.getCurrenciesWithDetail()

    override suspend fun getStockFeed(): ResultWrapper<StockFeed>  =
        remoteDataManager.getStockFeed()
    override suspend fun getLatestRatesAsync(): ResultWrapper<RatesResponse> =
        remoteDataManager.getLatestRatesAsync()


    override suspend fun getRatesOfDateAsync(date: String): ResultWrapper<RatesResponse> =
        remoteDataManager.getRatesOfDateAsync(date)

    override suspend fun getLatestWithBaseAsync(baseCode: String): ResultWrapper<RatesResponse> =
        remoteDataManager.getLatestWithBaseAsync(baseCode)

    override suspend fun getRatesOfDateWithBaseAsync(date: String, baseCode: String): ResultWrapper<RatesResponse>  =
        remoteDataManager.getRatesOfDateWithBaseAsync(date,baseCode)

    override suspend fun getRatesBetweenTwoTimeAsync(
        endAt: String,
        startAt: String,
        symbol: String,
        base: String
    ): ResultWrapper<TwoDaysWithBase>  =
        remoteDataManager.getRatesBetweenTwoTimeAsync(endAt,startAt,symbol,base)
}

