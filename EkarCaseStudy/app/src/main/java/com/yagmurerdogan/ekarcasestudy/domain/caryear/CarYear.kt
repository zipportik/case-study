package com.yagmurerdogan.ekarcasestudy.domain.caryear

import android.content.Context
import com.yagmurerdogan.ekarcasestudy.R
import com.yagmurerdogan.ekarcasestudy.data.model.response.CarAttributeResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.StringBuilder
import javax.inject.Inject


class CarYear @Inject constructor(@ApplicationContext private val context: Context) {

    fun provideYear(carAttribute: CarAttributeResponse): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(context.getString(R.string.year))
        stringBuilder.append(HYPHEN)
        stringBuilder.append(carAttribute.year)
        return stringBuilder.toString()
    }

    companion object {
        const val HYPHEN = " - "
    }
}