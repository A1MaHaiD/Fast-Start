package com.example.cryptoapp.data.workers

import android.content.Context
import androidx.work.*
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.database.CoinInfoDao
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import kotlinx.coroutines.delay

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val coinInfoDao: CoinInfoDao,
    private val coinApi: ApiService,
    private val mapper: CoinMapper
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = coinApi.getTopCoinInfo(limit = 50)
                val fSymbols = mapper.mapNamesListToString(topCoins)
                val jsonContainer = coinApi.getFullPriceList(fSyms = fSymbols)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfoDTO(jsonContainer)
                val dbModelList = coinInfoDtoList.map {
                    mapper.mapDtoToModel(it)
                }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
            }
            delay(100000)
        }
    }

    companion object {
        const val NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>()
                .setConstraints(makerConstrains())
                .build()
        }

        private fun makerConstrains(): Constraints {
            return Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
        }
    }
}