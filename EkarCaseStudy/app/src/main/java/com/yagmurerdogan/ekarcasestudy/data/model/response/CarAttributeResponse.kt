package com.yagmurerdogan.ekarcasestudy.data.model.response

import com.google.gson.annotations.SerializedName

data class CarAttributeResponse(
    @SerializedName("year")
    val year: String? = null,
    @SerializedName("model")
    val model: String? = null,
    @SerializedName("make")
    val make: String? = null,
    @SerializedName("style")
    val style: String? = null,
    @SerializedName("delivery_charges")
    val deliveryCharges: String? = null,
    @SerializedName("standard_seating")
    val seating: String? = null
)