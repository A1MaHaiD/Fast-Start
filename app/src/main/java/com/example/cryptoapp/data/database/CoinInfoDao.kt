package com.example.cryptoapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CoinInfoDao {
    @Query("SELECT * FROM full_price_list ORDER BY lastUpdate DESC")
    fun getPriceList(): LiveData<List<CoiInfoDBModel>>

    @Query("SELECT * FROM full_price_list WHERE fromSymbol == :fSym")
    fun getPriceInfoAboutCoin(fSym: String): LiveData<CoiInfoDBModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriceList(priceListDB: List<CoiInfoDBModel>)
}