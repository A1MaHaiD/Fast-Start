package com.example.cryptoapp.presenter

import android.app.Application
import com.example.cryptoapp.di.component.DaggerApplicationComponent

class CoinApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}