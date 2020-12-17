package com.kash.stockticker.data.remote.model.ticker

data class StockFeed(
    val `data`: List<Data>,
    val success: Boolean
)