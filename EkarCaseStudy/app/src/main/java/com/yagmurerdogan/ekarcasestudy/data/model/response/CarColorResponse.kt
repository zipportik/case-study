package com.yagmurerdogan.ekarcasestudy.data.model.response

import com.google.gson.annotations.SerializedName

data class CarColorResponse(
    @SerializedName("name")
    val name: String
)