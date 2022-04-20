package com.yagmurerdogan.ekarcasestudy.viewmodel

import androidx.lifecycle.viewModelScope
import com.yagmurerdogan.ekarcasestudy.data.model.request.CarRequest
import com.yagmurerdogan.ekarcasestudy.domain.uimodel.CarUIModel
import com.yagmurerdogan.ekarcasestudy.domain.usecase.CarDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

const val KEY_VALUE = "tha91z6lv_j8u1nv4xs_ilfswb1e3"
const val VIN_VALUE = "JTDZN3EU0E3298500"

@HiltViewModel
class VehicleViewModel @Inject constructor(private val carDetail: CarDetail) :
    BaseViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    init {
        getCarDetail()
    }

    private fun getCarDetail(key: String = KEY_VALUE, vin: String = VIN_VALUE) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            request(
                flow = carDetail(CarRequest(key = key, vin = vin)),
                onSuccess = { carDetail ->
                    _uiState.update { it.copy(carDetail = carDetail, isLoading = false) }
                })
        }
    }

    data class UiState(
        val isLoading: Boolean = true,
        val carDetail: CarUIModel? = null
    )
}