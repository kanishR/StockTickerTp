package com.kash.stockticker.data.remote.model.base

import com.google.gson.annotations.SerializedName

class BaseErrorMessage(
    @SerializedName("error")
    var errorMessage:String
)