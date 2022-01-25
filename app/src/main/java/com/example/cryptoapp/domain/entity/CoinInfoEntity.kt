package com.example.cryptoapp.domain.entity

import javax.inject.Inject

data class CoinInfoEntity @Inject constructor(
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: String,
    val highDay: String?,
    val lowDay: String?,
    val lastMarket: String?,
    val imageUrl: String
)
