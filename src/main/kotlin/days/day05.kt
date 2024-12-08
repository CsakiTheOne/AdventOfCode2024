package com.csakitheone.days

import com.csakitheone.utils.Puzzle
import kotlin.system.measureTimeMillis

private data class Update(
    val pages: List<Int>,
) {
    fun isValid(rules: Map<Int, List<Int>>): Boolean {
        return pages.indices.all { pageIndex ->
            val currentPage = pages[pageIndex]
            val prevPages = pages.subList(0, pageIndex)
            rules[currentPage]?.none { it in prevPages } ?: true
        }
    }
}

val day05 = Puzzle(
    day = 5,
    part1 = { input ->
        val (ruleLines, updateLines) = input.split("\n\n").map { it.trim() }
        val rules = ruleLines.lines().map {
            val (before, after) = it.split("|")
            before.toInt() to after
        }.groupBy { it.first }
            .map { (k, v) -> k to v.map { it.second.toInt() } }.toMap()
        val updates = updateLines.lines().map { line ->
            Update(line.split(",").map { it.toInt() })
        }

        val validUpdates = updates.filter { update ->
            update.isValid(rules)
        }

        validUpdates.sumOf { update ->
            update.pages[update.pages.size / 2]
        }
    },
    part2 = { input ->
        val (ruleLines, updateLines) = input.split("\n\n").map { it.trim() }
        val rules = ruleLines.lines().map {
            val (before, after) = it.split("|")
            before.toInt() to after
        }.groupBy { it.first }
            .map { (k, v) -> k to v.map { it.second.toInt() } }.toMap()
        val updates = updateLines.lines().map { line ->
            Update(line.split(",").map { it.toInt() })
        }

        val invalidUpdates = updates.filter { update ->
            !update.isValid(rules)
        }

        val fixedUpdates = invalidUpdates.map { update ->
            var fixedUpdate = update

            println("Fixing: $update")

            val fixTime = measureTimeMillis {
                while (!fixedUpdate.isValid(rules)) {
                    var i = 0
                    while (i < fixedUpdate.pages.size) {
                        val currentPage = fixedUpdate.pages[i]
                        val currentRule = rules[currentPage] ?: continue
                        val prevPages = fixedUpdate.pages.subList(0, i)
                        if (prevPages.any { it in currentRule }) {
                            val firstBadPageIndex = prevPages.indexOfFirst { it in currentRule }
                            fixedUpdate = fixedUpdate.copy(
                                pages = fixedUpdate.pages.toMutableList().apply {
                                    set(firstBadPageIndex, currentPage)
                                    set(i, prevPages[firstBadPageIndex])
                                }
                            )
                        }
                        else i++
                    }
                }
            }

            println("Fixed: $fixedUpdate in $fixTime ms")

            fixedUpdate
        }

        fixedUpdates.sumOf { update ->
            update.pages[update.pages.size / 2]
        }
    }
)