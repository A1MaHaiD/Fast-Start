package com.example.cryptoapp.di.component

import com.example.cryptoapp.di.annotation.ApplicationScope
import com.example.cryptoapp.di.module.AdapterModule
import com.example.cryptoapp.di.module.DataModule
import com.example.cryptoapp.di.module.DomainModule
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class, AdapterModule::class])
interface ApplicationComponent {

    fun activityComponentFactory(): ActivityComponent.Factory

    @Component.Factory
    interface ApplicationComponentFactory{

        fun create(

        ):ActivityComponent
    }
}