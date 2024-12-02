package com.csakitheone.days

import com.csakitheone.utils.Puzzle
import kotlin.math.abs

private fun List<Int>.isSafe(): Boolean {
    // All increasing or all decreasing)
    if (this.sorted() != this && this.sortedDescending() != this) {
        return false
    }

    // Gradually changing
    return this.zipWithNext { a, b -> (1..3).contains(abs(a - b)) }.all { it }
}

val day02 = Puzzle(
    day = 2,
    part1 = { input ->
        input.lines().filter { it.isNotBlank() }.count { reportLine ->
            val report = reportLine.split(" ").map { it.toInt() }

            report.isSafe()
        }
    },
    part2 = { input ->
        input.lines().filter { it.isNotBlank() }.count { reportLine ->
            val report = reportLine.split(" ").map { it.toInt() }

            if (report.isSafe()) return@count true

            report.indices.any { i ->
                report.filterIndexed { j, _ -> i != j }.isSafe()
            }
        }
    },
)