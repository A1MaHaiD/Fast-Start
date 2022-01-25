package com.example.cryptoapp.presenter.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.cases.GetCoinInfoListUseCase
import com.example.cryptoapp.domain.cases.GetCoinInfoUseCase
import com.example.cryptoapp.domain.cases.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}