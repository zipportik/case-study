package com.yagmurerdogan.ekarcasestudy.di.coroutine

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface CoroutineModule {

    @get:[Binds Singleton]
    val CoroutineThreadImpl.coroutineThread: CoroutineThread
}