package com.yagmurerdogan.ekarcasestudy.ui.vehicle

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.yagmurerdogan.ekarcasestudy.R
import com.yagmurerdogan.ekarcasestudy.components.WhiteButton
import com.yagmurerdogan.ekarcasestudy.components.BlueButton
import com.yagmurerdogan.ekarcasestudy.components.Dropdown
import com.yagmurerdogan.ekarcasestudy.components.LoadingView
import com.yagmurerdogan.ekarcasestudy.components.NumberAndStringLabel
import com.yagmurerdogan.ekarcasestudy.components.StringAndNumberLabel
import com.yagmurerdogan.ekarcasestudy.viewmodel.VehicleViewModel

@ExperimentalMaterialApi
@Composable
fun VehicleScreen(navController: NavController) {
    val viewModel = hiltViewModel<VehicleViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    if (uiState.isLoading) {
        LoadingView()
    } else {
        LazyColumn {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.dark_ekar_blue))
                ) {
                    Column() {
                        Image(
                            painter = painterResource(R.drawable.ekar_car),
                            contentDescription = stringResource(R.string.cd_car_image),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            NumberAndStringLabel(
                                label = R.string.base_price,
                                title = uiState.carDetail?.deliveryCharges.orEmpty(),
                                subtitle = stringResource(id = R.string.aed_month)
                            )
                            NumberAndStringLabel(
                                label = R.string.standard_seating,
                                title = uiState.carDetail?.seat.orEmpty(),
                                subtitle = stringResource(id = R.string.seating)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            StringAndNumberLabel(
                                label = R.string.booking_fee,
                                title = uiState.carDetail?.bookingFee.orEmpty(),
                                subtitle = uiState.carDetail?.currency.orEmpty(),
                            )

                            WhiteButton(textResId = R.string.how_contracts_work) {
                                Toast.makeText(
                                    context,
                                    R.string.message_button_actions,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }

            if (uiState.carDetail?.year.isNullOrEmpty().not()) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = uiState.carDetail?.formattedYear.orEmpty(),
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }

            if (uiState.carDetail?.colors.isNullOrEmpty().not()) {
                item {
                    Box(modifier = Modifier.padding(8.dp)) {
                        Dropdown(
                            labelResId = R.string.available_colors,
                            options = uiState.carDetail?.colors.orEmpty()
                        )
                    }

                }
            }
            item {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Row {
                        Image(
                            painter = painterResource(R.drawable.ekar_logo),
                            contentDescription = stringResource(R.string.cd_car_image),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = CircleShape
                                )
                        )
                        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                            Row {
                                Text(
                                    text = uiState.carDetail?.make.orEmpty(),
                                    style = MaterialTheme.typography.h5,
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                                Text(
                                    text = uiState.carDetail?.model.orEmpty(),
                                    style = MaterialTheme.typography.h5,
                                    color = Color.LightGray
                                )
                            }
                            Text(
                                text = uiState.carDetail?.style.orEmpty(),
                                style = MaterialTheme.typography.h6,
                                color = Color.DarkGray
                            )
                        }
                    }
                    BlueButton(textResId = R.string.proceed_with_your_selection) {}
                }
            }
        }
    }
}