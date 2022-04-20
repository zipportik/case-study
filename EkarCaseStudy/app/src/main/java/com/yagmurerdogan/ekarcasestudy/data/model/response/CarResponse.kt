package com.yagmurerdogan.ekarcasestudy.data.model.response

import com.google.gson.annotations.SerializedName

data class CarResponse(
    @SerializedName("success")
    val success: Boolean? = null,
    @SerializedName("attributes")
    val attributes: CarAttributeResponse,
    @SerializedName("colors")
    val colors: List<CarColorResponse>
)