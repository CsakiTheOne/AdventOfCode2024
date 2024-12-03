package com.csakitheone.days

import com.csakitheone.utils.Puzzle

private fun performMuls(input: String): Int {
    val instructionRegex = Regex("""mul\((\d+),(\d+)\)""")
    val validInstructions = instructionRegex.findAll(input).toList()
    return validInstructions.sumOf { mulMatch ->
        val (a, b) = mulMatch.value.split("(", ",", ")").drop(1).map { it.toIntOrNull() }
        (a ?: 0) * (b ?: 0)
    }
}

val day03 = Puzzle(
    day = 3,
    part1 = { input ->
        performMuls(input)
    },
    part2 = { input ->
        val sections = input.split(Regex("""(?=do\(\)|don't\(\))"""))
        val enabledSections = sections.filter { !it.startsWith("don't()") }
        enabledSections.sumOf { performMuls(it) }
    },
)