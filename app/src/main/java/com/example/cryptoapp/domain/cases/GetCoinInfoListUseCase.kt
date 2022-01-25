package com.example.cryptoapp.domain.cases

import com.example.cryptoapp.domain.CoinRepository
import javax.inject.Inject

class GetCoinInfoListUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke() = repository.getCoinInfoList()
}