package com.example.cryptoapp.di.module

import com.example.cryptoapp.presenter.view_models.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CoinViewModelModule {

    @IntoMap
    @Binds
    fun bindCoinViewModel(impl: CoinViewModel): CoinViewModel
}