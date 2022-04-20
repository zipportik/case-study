package com.yagmurerdogan.ekarcasestudy.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.yagmurerdogan.ekarcasestudy.R
import com.yagmurerdogan.ekarcasestudy.navigation.Screen
import com.yagmurerdogan.ekarcasestudy.viewmodel.SplashEvent
import com.yagmurerdogan.ekarcasestudy.viewmodel.SplashViewModel

@Composable
fun Splash(navController: NavController) {
    val viewModel = hiltViewModel<SplashViewModel>()
    val event by viewModel.navigationEvent.collectAsState(SplashEvent.Initial)

    when (event) {
        is SplashEvent.Initial -> {
            Image(
                painter = painterResource(R.drawable.ekar_logo),
                contentDescription = "ekar logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)
                    .size(200.dp)
            )
        }
        is SplashEvent.NavigateToHome -> {
            navController.navigate(Screen.Map.route)
        }
    }

}