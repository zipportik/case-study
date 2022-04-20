package com.yagmurerdogan.ekarcasestudy.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun NumberAndStringLabel(
    @StringRes label: Int,
    title: String,
    subtitle: String
) {
    Column() {
        Text(
            text = stringResource(id = label),
            style = MaterialTheme.typography.subtitle2,
        )
        Row() {
            Text(
                text = title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(end = 4.dp)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .align(Alignment.Bottom)
            )
        }
    }
}