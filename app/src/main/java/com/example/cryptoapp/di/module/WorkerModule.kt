package com.example.cryptoapp.di.module

import com.example.cryptoapp.data.workers.ChildWorkerFactory
import com.example.cryptoapp.data.workers.RefreshDataWorker
import com.example.cryptoapp.di.annotation.WorkerKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    @Binds
    fun bindRefreshDataWorkerFactory(worker: RefreshDataWorker.Factory): ChildWorkerFactory
}