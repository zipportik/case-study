package com.yagmurerdogan.ekarcasestudy.domain.mapper

import com.yagmurerdogan.ekarcasestudy.data.model.response.CarResponse
import com.yagmurerdogan.ekarcasestudy.domain.caryear.CarYear
import com.yagmurerdogan.ekarcasestudy.domain.uimodel.CarUIModel
import com.yagmurerdogan.ekarcasestudy.util.Mapper
import javax.inject.Inject

class CarSpecUIModelMapper @Inject constructor(
    private var carYear: CarYear
) : Mapper<CarResponse, CarUIModel> {

    override fun map(input: CarResponse): CarUIModel {
        val attributes = input.attributes
        val colors = input.colors.map { it.name }
        return CarUIModel(
            make = attributes.make.orEmpty(),
            style = attributes.style.orEmpty(),
            model = attributes.model.orEmpty(),
            colors = colors,
            deliveryCharges = attributes.deliveryCharges.orEmpty(),
            seat = attributes.seating.orEmpty(),
            year = attributes.year.orEmpty(),
            formattedYear = attributes.let { carYear.provideYear(it) },
            //The API does not support bookingFee and currency
            bookingFee = "369",
            currency = "AED"
        )
    }
}