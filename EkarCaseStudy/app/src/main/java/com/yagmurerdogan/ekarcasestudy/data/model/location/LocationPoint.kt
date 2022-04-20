package com.yagmurerdogan.ekarcasestudy.data.model.location

import com.google.android.libraries.maps.model.LatLng

//The API does not support location point information
data class LocationPoint(
    val title: String,
    val latLng: LatLng,
    val iconResource: Float
)
