package com.yagmurerdogan.ekarcasestudy.ui.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.model.BitmapDescriptorFactory
import com.google.android.libraries.maps.model.LatLngBounds
import com.google.android.libraries.maps.model.MarkerOptions
import com.google.maps.android.ktx.awaitMap
import com.yagmurerdogan.ekarcasestudy.components.map.rememberMapViewWithLifecycle
import com.yagmurerdogan.ekarcasestudy.data.model.location.DummyLocationProvider
import com.yagmurerdogan.ekarcasestudy.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MapScreen(navController: NavController) {
    val mapView = rememberMapViewWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White)
    ) {
        AndroidView({ mapView }) { mapView ->
            CoroutineScope(Dispatchers.Main).launch {
                val map = mapView.awaitMap()

                map.setOnMarkerClickListener {
                    navController.navigate(Screen.Vehicle.route)
                    true
                }
                val builder = LatLngBounds.Builder()
                val locationPoints = DummyLocationProvider.locationPoints
                locationPoints.forEach { point ->
                    builder.include(point.latLng)
                    val markerOptions = MarkerOptions()
                        .position(point.latLng)
                        .title(point.title)
                        .icon(BitmapDescriptorFactory.defaultMarker(point.iconResource))
                    map.addMarker(markerOptions)
                }
                val bounds: LatLngBounds = builder.build()
                map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 120))
            }
        }
    }


}