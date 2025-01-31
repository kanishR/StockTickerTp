package com.kash.stockticker.data.remote.model.symbol

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Currency(
    @SerializedName("code")
    var code:String,
    @SerializedName("symbol")
    var symbol:String,
    @SerializedName("name")
    var currencyName:String,
    @SerializedName("description")
    var description:String?=null,
    @SerializedName("position")
    var position:String,
    @SerializedName("last_modified")
    var lastModified:String,
    var rateValue:String?=null, // Will be set from the actual api after filtering the rate symbols
    var previousDayValue:String?=null,
    var percentDifferenceValue:String?=null,
    var currencyDraweble:String
): Serializable