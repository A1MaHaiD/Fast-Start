package com.example.cryptoapp.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class CoinNamesListDTO @Inject constructor (
    @SerializedName("Data")
    @Expose
    val names: List<CoinNameContainerDTO>? = null
)