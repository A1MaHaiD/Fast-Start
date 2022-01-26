package com.example.cryptoapp.di.component

import android.app.Application
import com.example.cryptoapp.di.annotation.ApplicationScope
import com.example.cryptoapp.di.module.AdapterModule
import com.example.cryptoapp.di.module.CoinViewModelModule
import com.example.cryptoapp.di.module.DataModule
import com.example.cryptoapp.presenter.CoinApp
import com.example.cryptoapp.presenter.ui.activities.CoinPriceListActivity
import com.example.cryptoapp.presenter.ui.fragments.CoinDetailFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        CoinViewModelModule::class,
        DataModule::class,
        AdapterModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    fun inject(application: CoinApp)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}