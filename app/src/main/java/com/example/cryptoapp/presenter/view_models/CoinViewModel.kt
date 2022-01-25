package com.example.cryptoapp.presenter.view_models

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.cases.GetCoinInfoListUseCase
import com.example.cryptoapp.domain.cases.GetCoinInfoUseCase
import com.example.cryptoapp.domain.cases.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}