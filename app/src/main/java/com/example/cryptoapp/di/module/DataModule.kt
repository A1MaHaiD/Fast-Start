package com.example.cryptoapp.di.module

import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.database.CoinInfoDao
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import com.example.cryptoapp.di.annotation.ApplicationScope
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRoomData(imp: AppDatabase): CoinInfoDao

    @ApplicationScope
    @Binds
    fun bindRetrofitData(imp: ApiFactory): ApiService
}