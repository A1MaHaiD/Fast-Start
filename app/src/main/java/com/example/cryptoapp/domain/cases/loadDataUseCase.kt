package com.example.cryptoapp.domain.cases

import com.example.cryptoapp.domain.CoinRepository

class loadDataUseCase(private val coinRepository: CoinRepository) {

    suspend operator fun invoke() = coinRepository.loadData()


}