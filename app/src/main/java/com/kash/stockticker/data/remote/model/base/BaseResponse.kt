package com.kash.stockticker.data.remote.model.base

import com.google.gson.annotations.SerializedName

open class BaseResponse<out T>(
    @SerializedName("rates")
    val data: T? = null,
    @SerializedName("base")
    var base:String = "",
    @SerializedName("date")
    var date:String = ""
)