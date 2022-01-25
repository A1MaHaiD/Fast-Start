package com.example.cryptoapp.data.network.dto

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class CoinJsonContainerDTO @Inject constructor (
    @SerializedName("RAW")
    @Expose
    var json: JsonObject? = null
)