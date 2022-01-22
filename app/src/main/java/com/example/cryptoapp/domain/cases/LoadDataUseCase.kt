package com.example.cryptoapp.domain.cases

import com.example.cryptoapp.domain.CoinRepository

class LoadDataUseCase(private val coinRepository: CoinRepository) {

    suspend operator fun invoke() = coinRepository.loadData()
}