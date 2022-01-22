package com.example.cryptoapp.domain.cases

import com.example.cryptoapp.domain.CoinRepository

class getCoinInfoUseCase(private val repository: CoinRepository) {

    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}