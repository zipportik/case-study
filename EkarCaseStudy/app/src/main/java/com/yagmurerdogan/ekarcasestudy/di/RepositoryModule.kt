package com.yagmurerdogan.ekarcasestudy.di

import com.yagmurerdogan.ekarcasestudy.data.network.ApiService
import com.yagmurerdogan.ekarcasestudy.data.repository.CarRepository
import com.yagmurerdogan.ekarcasestudy.di.coroutine.CoroutineThread
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideCarDetailRepository(
        apiService: ApiService,
        coroutineThread: CoroutineThread
    ) = CarRepository(apiService, coroutineThread)

}