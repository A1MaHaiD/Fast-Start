package com.example.cryptoapp.di.component

import com.example.cryptoapp.di.module.CoinViewModelModule
import com.example.cryptoapp.presenter.ui.activities.CoinDetailActivity
import com.example.cryptoapp.presenter.ui.activities.CoinPriceListActivity
import dagger.Subcomponent

@Subcomponent(modules = [CoinViewModelModule::class])
interface ActivityComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(activity: CoinDetailActivity)

    @Subcomponent.Factory
    interface Factory{

        fun create(

        ):ActivityComponent
    }
}