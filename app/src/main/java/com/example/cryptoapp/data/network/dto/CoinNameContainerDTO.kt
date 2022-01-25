package com.example.cryptoapp.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class CoinNameContainerDTO @Inject constructor(
    @SerializedName("CoinInfo")
    @Expose
    var coinName: CoinNameDTO? = null
)
