package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.entity.CoinInfoEntity

interface CoinRepository {

    fun getCoinInfoList():LiveData<List<CoinInfoEntity>>

    fun getCoinInfo(fromSymbol:String):LiveData<CoinInfoEntity>

    suspend fun loadData()
}