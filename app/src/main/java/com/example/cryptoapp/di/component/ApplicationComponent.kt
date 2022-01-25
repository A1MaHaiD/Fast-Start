package com.example.cryptoapp.di.component

import android.app.Application
import com.example.cryptoapp.di.module.AdapterModule
import com.example.cryptoapp.di.module.CoinViewModelModule
import com.example.cryptoapp.di.module.DomainModule
import com.example.cryptoapp.presenter.ui.activities.CoinPriceListActivity
import com.example.cryptoapp.presenter.ui.fragments.CoinDetailFragment
import dagger.BindsInstance
import dagger.Component

//@ApplicationScope
@Component(
    modules = [
        /*DataModule::class,*/
        CoinViewModelModule::class,
        DomainModule::class,
        AdapterModule::class
    ]
)
interface ApplicationComponent {

//    fun activityComponentFactory(): ActivityComponent.Factory

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}