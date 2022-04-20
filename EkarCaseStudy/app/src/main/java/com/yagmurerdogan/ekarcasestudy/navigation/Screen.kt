package com.yagmurerdogan.ekarcasestudy.navigation

import androidx.annotation.StringRes
import com.yagmurerdogan.ekarcasestudy.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Splash : Screen("splash", R.string.splash)
    object Map : Screen("map", R.string.map)
    object Vehicle : Screen("vehicle", R.string.vehicle)
}