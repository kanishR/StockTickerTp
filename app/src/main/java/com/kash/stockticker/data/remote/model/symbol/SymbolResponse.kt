package com.kash.stockticker.data.remote.model.symbol

import com.google.gson.annotations.SerializedName

class SymbolResponse(
    @SerializedName("response")
    var response:Symbol
)