package com.yagmurerdogan.ekarcasestudy.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yagmurerdogan.ekarcasestudy.components.AppBar
import com.yagmurerdogan.ekarcasestudy.navigation.Screen
import com.yagmurerdogan.ekarcasestudy.ui.map.MapScreen
import com.yagmurerdogan.ekarcasestudy.ui.splash.Splash
import com.yagmurerdogan.ekarcasestudy.ui.theme.EkarCaseStudyTheme
import com.yagmurerdogan.ekarcasestudy.ui.vehicle.VehicleScreen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EkarCaseStudyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    Scaffold(
                        topBar = { AppBar() }
                    ) {
                        NavHost(navController, startDestination = Screen.Splash.route) {
                            composable(Screen.Splash.route) { Splash(navController) }
                            composable(Screen.Map.route) { MapScreen(navController) }
                            composable(Screen.Vehicle.route) { VehicleScreen(navController) }
                        }
                    }
                }
            }
        }
    }
}
