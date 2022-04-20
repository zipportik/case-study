package com.yagmurerdogan.ekarcasestudy.domain.uimodel

data class CarUIModel(
    val make : String,
    val model : String,
    val style : String,
    val colors: List<String>,
    val year: String,
    val formattedYear : String,
    val seat : String,
    val deliveryCharges: String,
    val bookingFee : String,
    val currency: String
)