package com.csakitheone.days

import com.csakitheone.utils.Puzzle

val day01 = Puzzle(
    day = 1,
    part1 = { input ->
        val pairs = input.lines()
            .filter { it.isNotBlank() }
            .map { line ->
                line.split("   ").mapNotNull { it.toIntOrNull() }
            }
        val list1 = pairs.map { it[0] }.sorted()
        val list2 = pairs.map { it[1] }.sorted()
        val distances = list1.zip(list2).map { (a, b) -> Math.abs(a - b) }

        distances.sum()
    },
    part2 = { input ->
        val pairs = input.lines()
            .filter { it.isNotBlank() }
            .map { line ->
                line.split("   ").mapNotNull { it.toIntOrNull() }
            }
        val list1 = pairs.map { it[0] }.sorted()
        val list2 = pairs.map { it[1] }.sorted()

        list1.sumOf { n ->
            n * list2.count { it == n }
        }
    }
)