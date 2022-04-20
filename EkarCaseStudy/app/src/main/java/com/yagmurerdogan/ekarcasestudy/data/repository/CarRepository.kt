package com.yagmurerdogan.ekarcasestudy.data.repository

import com.yagmurerdogan.ekarcasestudy.data.model.request.CarRequest
import com.yagmurerdogan.ekarcasestudy.data.network.ApiService
import com.yagmurerdogan.ekarcasestudy.di.coroutine.CoroutineThread
import javax.inject.Inject

class CarRepository @Inject constructor(
    private val api: ApiService,
    private val coroutineThread: CoroutineThread
) : BaseRepository() {

    suspend operator fun invoke(request: CarRequest) =
        safeApiCall(dispatcher = coroutineThread.io) {
            api.getSpecs(
                key = request.key,
                vin = request.vin
            )
        }
}