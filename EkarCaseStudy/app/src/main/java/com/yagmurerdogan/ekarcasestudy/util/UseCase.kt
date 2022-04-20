package com.yagmurerdogan.ekarcasestudy.util

import kotlinx.coroutines.flow.Flow

interface UseCase<in Input, out Output> {
    suspend operator fun invoke(input: Input): Flow<Output>
}