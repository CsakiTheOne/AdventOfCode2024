package com.csakitheone.utils

fun String.safeSubstring(startIndex: Int, endIndex: Int): String {
    val start = kotlin.math.max(0, startIndex)
    val end = kotlin.math.min(this.length, endIndex)
    return this.substring(start, end)
}