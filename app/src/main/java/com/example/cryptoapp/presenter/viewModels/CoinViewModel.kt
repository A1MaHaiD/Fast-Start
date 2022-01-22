package com.example.cryptoapp.presenter.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.network.dto.CoinInfoDTO
import com.example.cryptoapp.data.network.dto.CoinJsonContainerDTO
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    val priceList = db.coinPriceInfoDao().getPriceList()

    fun getDetailInfo(fSym:String):LiveData<CoinInfoDTO>{
        return db.coinPriceInfoDao().getPriceInfoAboutCoin(fSym)
    }

    init {
        loadData()
    }

    private fun loadData() {
        val disposable = ApiFactory.apiService.getTopCoinInfo(limit = 50)
            .map { it.names?.map { it.coinName?.name }?.joinToString(",") }
            .flatMap { ApiFactory.apiService.getFullPriceList(fSyms = it) }
            .map { getPriceListFromRawData(it) }
            .delaySubscription(10,TimeUnit.SECONDS)
            .repeat()
            .retry()
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.coinPriceInfoDao().insertPriceList(it)
                Log.i("TEST_OF_LOCAL_DATA", "Success: $it")
            }, {
                Log.i("TEST_OF_LOCAL_DATA", "Failure: ${it.message}")
            })
    }

    private fun getPriceListFromRawData(
        coinJsonContainerDTO: CoinJsonContainerDTO
    ): List<CoinInfoDTO> {

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}