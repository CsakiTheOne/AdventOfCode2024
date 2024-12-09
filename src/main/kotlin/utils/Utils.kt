package com.csakitheone.utils

fun String.safeSubstring(startIndex: Int, endIndex: Int): String {
    val start = kotlin.math.max(0, startIndex)
    val end = kotlin.math.min(this.length, endIndex)
    return this.substring(start, end)
}

data class IntBox2(
    val x: Int = 0,
    val y: Int = 0,
    val width: Int = 0,
    val height: Int = 0,
) {
    val left = x
    val right = x + width
    val top = y
    val bottom = y + height

    fun contains(point: IntVector2) = point.x in left until right && point.y in top until bottom
}

data class IntVector2(
    val x: Int = 0,
    val y: Int = 0,
) {
    operator fun plus(other: IntVector2) = IntVector2(x + other.x, y + other.y)
    operator fun minus(other: IntVector2) = IntVector2(x - other.x, y - other.y)
    operator fun times(scalar: Int) = IntVector2(x * scalar, y * scalar)
    operator fun div(scalar: Int) = IntVector2(x / scalar, y / scalar)

    companion object {
        val ZERO = IntVector2(0, 0)
        val UP = IntVector2(0, -1)
        val DOWN = IntVector2(0, 1)
        val LEFT = IntVector2(-1, 0)
        val RIGHT = IntVector2(1, 0)
    }
}