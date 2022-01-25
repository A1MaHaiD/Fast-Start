package com.example.cryptoapp.di.module

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.di.annotation.ViewModelKey
import com.example.cryptoapp.presenter.view_models.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CoinViewModelModule {

    @IntoMap
    @ViewModelKey(CoinViewModel::class)
    @Binds
    fun bindCoinViewModel(impl: CoinViewModel): ViewModel
}
