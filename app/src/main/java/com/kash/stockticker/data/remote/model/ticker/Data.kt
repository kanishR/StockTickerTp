package com.kash.stockticker.data.remote.model.ticker

data class Data(
    val change: Double,
    val close: Double,
    val date: String,
    val high: Double,
    val low: Double,
    val price: Double,
    val sid: String,
    val volume: Int
)