package com.example.cryptoapp.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class CoinNameDTO (
    @SerializedName("Name")
    @Expose
    val name: String? = null
)