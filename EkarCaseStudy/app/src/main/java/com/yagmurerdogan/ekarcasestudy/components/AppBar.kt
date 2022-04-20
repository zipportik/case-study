package com.yagmurerdogan.ekarcasestudy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yagmurerdogan.ekarcasestudy.R

@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painterResource(id = R.drawable.ekar_logo), contentDescription = "ekar logo",
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.Center)
                )
            }
        },
        backgroundColor = Color.White
    )
}

