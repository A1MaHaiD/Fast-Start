package com.example.cryptoapp.domain.cases

import com.example.cryptoapp.domain.CoinRepository

class getCoinInfoListUseCase(private val repository: CoinRepository) {

    operator fun invoke() = repository.getCoinInfoList()
}