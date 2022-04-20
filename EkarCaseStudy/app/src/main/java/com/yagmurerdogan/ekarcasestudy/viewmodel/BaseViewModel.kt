package com.yagmurerdogan.ekarcasestudy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yagmurerdogan.ekarcasestudy.data.network.RestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


abstract class BaseViewModel : ViewModel() {

    fun <T> request(
        flow: Flow<RestResult<T>>,
        onSuccess: ((data: T) -> Unit)? = null,
        onError: ((t: Exception) -> Unit)? = null,
        onLoading: (() -> Unit)? = null
    ) = viewModelScope.launch {
        flow.collect { result ->
            when (result) {
                is RestResult.Loading -> onLoading?.invoke()
                is RestResult.Success -> onSuccess?.invoke(result.data)
                is RestResult.Error -> { onError?.invoke(result.exception) }
            }
        }
    }
}