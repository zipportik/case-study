package com.yagmurerdogan.ekarcasestudy.util

interface Mapper <in Input, out Output> {
    fun map(input: Input): Output
}