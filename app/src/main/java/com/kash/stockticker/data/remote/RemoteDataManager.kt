package com.kash.stockticker.data.remote

import com.kash.stockticker.data.remote.model.rate.RatesResponse
import com.kash.stockticker.data.remote.model.rate_time_period.TwoDaysWithBase
import com.kash.stockticker.data.remote.model.symbol.SymbolResponse
import com.kash.stockticker.data.remote.model.ticker.StockFeed
import com.kash.stockticker.data.remote.network.RemoteDataException
import com.kash.stockticker.data.remote.network.ResultWrapper
import com.kash.stockticker.data.remote.service.ICurrencyModelService
import com.kash.stockticker.data.remote.service.ICurrencyTimePeriodService
import com.kash.stockticker.data.remote.service.IRatesService
import com.kash.stockticker.data.remote.service.IStockFeedModelService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RemoteDataManager(
    private val modelService:ICurrencyModelService,
    private val stockService:IStockFeedModelService,
    private val ratesService:IRatesService,
    private val timePeriodSerive:ICurrencyTimePeriodService
    ): IRemoteDataManager {

    override suspend fun getCurrenciesWithDetail(): ResultWrapper<SymbolResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(modelService.getCurrenciesWithDetail())
        }
    override suspend fun getStockFeed(): ResultWrapper<StockFeed> =
        withContext(Dispatchers.IO) {
            resultWrapper(stockService.getStockFeed())
        }

    override suspend fun getLatestRatesAsync(): ResultWrapper<RatesResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(ratesService.getLatestRatesAsync())
        }

    override suspend fun getRatesOfDateAsync(date:String): ResultWrapper<RatesResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(ratesService.getRatesOfDateAsync(date))
        }

    override suspend fun getLatestWithBaseAsync(baseCode: String): ResultWrapper<RatesResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(ratesService.getLatestWithBaseAsync(baseCode))
        }

    override suspend fun getRatesOfDateWithBaseAsync(date: String, baseCode: String): ResultWrapper<RatesResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(ratesService.getRatesOfDateWithBaseAsync(date,baseCode))
        }

    override suspend fun getRatesBetweenTwoTimeAsync(
        endAt: String,
        startAt: String,
        symbol: String,
        base: String
    ): ResultWrapper<TwoDaysWithBase> =
        withContext(Dispatchers.IO) {
            resultWrapper(timePeriodSerive.getRatesBetweenTwoTimeAsync(endAt,startAt,symbol,base))
        }

    private suspend inline fun <reified T : Any> resultWrapper(request: Deferred<Response<T>>): ResultWrapper<T> {
        return try {
            val response = request.await()
            if (response.isSuccessful) {
                ResultWrapper.Success(response.body()!!)
            } else {
                ResultWrapper.Error(RemoteDataException(response.errorBody()))
            }
        } catch (ex: Throwable) {
            ResultWrapper.Error(RemoteDataException(ex))
        }
    }

}