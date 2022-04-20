package com.yagmurerdogan.ekarcasestudy.domain.usecase

import com.yagmurerdogan.ekarcasestudy.data.model.request.CarRequest
import com.yagmurerdogan.ekarcasestudy.data.network.RestResult
import com.yagmurerdogan.ekarcasestudy.data.network.map
import com.yagmurerdogan.ekarcasestudy.data.repository.CarRepository
import com.yagmurerdogan.ekarcasestudy.domain.mapper.CarSpecUIModelMapper
import com.yagmurerdogan.ekarcasestudy.domain.uimodel.CarUIModel
import com.yagmurerdogan.ekarcasestudy.util.UseCase
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CarDetail @Inject constructor(
    private val repository: CarRepository,
    private val mapper: CarSpecUIModelMapper
) : UseCase<CarRequest, RestResult<CarUIModel>> {

    override suspend fun invoke(input: CarRequest) =
        repository(input).map { networkState ->
            networkState.map { authResponse ->
                mapper.map(authResponse)
            }
        }
}