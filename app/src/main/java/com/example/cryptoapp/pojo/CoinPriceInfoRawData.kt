package com.example.cryptoapp.pojo

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CoinPriceInfoRawData(
    @SerializedName("RAW")
    @Expose
    var coinPriceInfoJsonObject: JsonObject? = null,

/*    @SerializedName("DISPLAY")
    @Expose
    var display: Display? = null*/
)


/*fun getRaw(): Raw? {
    return raw
}

fun setRaw(raw: Raw?) {
    this.raw = raw
}

fun getDisplay(): Display? {
    return display
}

fun setDisplay(display: Display?) {
    this.display = display
}*/
