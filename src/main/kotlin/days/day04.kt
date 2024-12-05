package com.csakitheone.days

import com.csakitheone.utils.Puzzle
import com.csakitheone.utils.safeSubstring
import kotlin.math.max
import kotlin.math.min

private fun checkXmasNearby(input: String, x: Int, y: Int): Int {
    val lines = input.lines()
    val line = lines[y]
    val matches = mutableListOf<String>()

    // Horizontal
    if (line.safeSubstring(x, x + 4) == "XMAS") matches.add("right")
    if (line.safeSubstring(x - 3, x + 1) == "SAMX") matches.add("left")
    // Vertical
    if (y < lines.lastIndex - 3) {
        if (lines[y + 1][x] == 'M' && lines[y + 2][x] == 'A' && lines[y + 3][x] == 'S') matches.add("down")
    }
    if (y > 2) {
        if (lines[y - 1][x] == 'M' && lines[y - 2][x] == 'A' && lines[y - 3][x] == 'S') matches.add("up")
    }
    // Diagonal
    if (x < lines[y].length - 3 && y < lines.lastIndex - 3) {
        if (lines[y + 1][x + 1] == 'M' && lines[y + 2][x + 2] == 'A' && lines[y + 3][x + 3] == 'S') matches.add("down-right")
    }
    if (x > 2 && y < lines.lastIndex - 3) {
        if (lines[y + 1][x - 1] == 'M' && lines[y + 2][x - 2] == 'A' && lines[y + 3][x - 3] == 'S') matches.add("down-left")
    }
    if (x < lines[y].length - 3 && y > 2) {
        if (lines[y - 1][x + 1] == 'M' && lines[y - 2][x + 2] == 'A' && lines[y - 3][x + 3] == 'S') matches.add("up-right")
    }
    if (x > 2 && y > 2) {
        if (lines[y - 1][x - 1] == 'M' && lines[y - 2][x - 2] == 'A' && lines[y - 3][x - 3] == 'S') matches.add("up-left")
    }

    // Announce results
    if (matches.isNotEmpty()) println("Found $matches at $x, $y")

    return matches.size
}

val day04 = Puzzle(
    day = 4,
    part1 = { input ->
        val xIndices = input.withIndex().filter { it.value == 'X' }.map { it.index }
        val lineLength = input.lines()[0].length + 1

        println("Found Xs: ${xIndices.size}")

        xIndices.sumOf { index ->
            val x = index % lineLength
            val y = index / lineLength
            checkXmasNearby(input, x, y)
        }
    },
    part2 = { input ->
        val aIndices = input.withIndex().filter { it.value == 'A' }.map { it.index }
        val lines = input.lines().filter { it.isNotBlank() }
        val lineLength = lines[0].length + 1

        aIndices.sumOf { index ->
            val x = index % lineLength
            val y = index / lineLength

            val isWithinBounds = x in 1..<(lineLength - 2) && y in 1..<(lines.lastIndex)
            if (!isWithinBounds) return@sumOf 0

            val nearbyValidCharacters = listOf(
                lines[y - 1][x - 1],
                lines[y - 1][x + 1],
                lines[y + 1][x - 1],
                lines[y + 1][x + 1],
            )

            val hasTwoMs = nearbyValidCharacters.count { it == 'M' } == 2
            val hasTwoSs = nearbyValidCharacters.count { it == 'S' } == 2
            val isNotDiagonal = lines[y - 1][x - 1] != lines[y + 1][x + 1]
            if (hasTwoMs && hasTwoSs && isNotDiagonal) {
                return@sumOf 1
            }

            return@sumOf 0 as Int
        }
    }
)