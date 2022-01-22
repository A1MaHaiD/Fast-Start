package com.example.cryptoapp.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNameContainerDTO(
    @SerializedName("CoinInfo")
    @Expose
    var coinName: CoinNameDTO? = null
)
