package com.example.faststart.api

import com.example.faststart.pojo.CoinInfoListOfData
import com.example.faststart.pojo.CoinPriceInfoRawData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top/totalvolfull")
    fun getTopCoinInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey:String = "76cb5ab8c2292e5fdb291950bee51332b8a2a072b4e2c27069b19adc940773b6",
        @Query(QUERY_PARAM_LIMIT) limit:Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym:String = CURRENCY
    ): Single<CoinInfoListOfData>
    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey:String = "76cb5ab8c2292e5fdb291950bee51332b8a2a072b4e2c27069b19adc940773b6",
        @Query(QUERY_PARAM_FROM_SYMBOLS)fSyms:String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms:String = CURRENCY
    ):Single<CoinPriceInfoRawData>

    companion object{
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"

        private const val CURRENCY = "USD"
//        private const val CONVERT_COIN = "BTC"
    }
}