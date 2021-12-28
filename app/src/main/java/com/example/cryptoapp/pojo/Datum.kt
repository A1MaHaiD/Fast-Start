package com.example.cryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Datum (
    @SerializedName("CoinInfo")
    @Expose
    var coinInfo: CoinInfo? = null,

/*    @SerializedName("RAW")
    @Expose
    private var raw: Raw? = null,

    @SerializedName("DISPLAY")
    @Expose
    private var display: Display? = null*/

)
/*fun getCoinInfo(): CoinInfo? {
    return coinInfo
}

fun setCoinInfo(coinInfo: CoinInfo?) {
    this.coinInfo = coinInfo
}

fun getRaw(): Raw? {
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

