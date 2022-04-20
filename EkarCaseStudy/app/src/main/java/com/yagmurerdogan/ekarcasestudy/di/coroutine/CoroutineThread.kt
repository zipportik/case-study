package com.yagmurerdogan.ekarcasestudy.di.coroutine

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineThread {
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
}