package com.csakitheone.days

import com.csakitheone.utils.IntBox2
import com.csakitheone.utils.IntVector2
import com.csakitheone.utils.Puzzle

val day06 = Puzzle(
    day = 6,
    part1 = { input ->
        val guardRegex = Regex("""[\^><v]""")
        val map = input.lines().filter { it.isNotBlank() }
        val mapBounds = IntBox2(width = map.first().length, height = map.size)
        var guardPosition = IntVector2(
            x = map.first { it.contains(guardRegex) }.indexOfFirst { it.toString().matches(guardRegex) },
            y = map.indexOfFirst { it.contains(guardRegex) }
        )
        var guardFacing = map[guardPosition.y][guardPosition.x]
        val visitedPlaces = mutableSetOf(guardPosition)

        while (mapBounds.contains(guardPosition)) {
            val nextPosition = when (guardFacing) {
                '^' -> guardPosition + IntVector2.UP
                'v' -> guardPosition + IntVector2.DOWN
                '<' -> guardPosition + IntVector2.LEFT
                '>' -> guardPosition + IntVector2.RIGHT
                else -> throw Error("Invalid guard facing: $guardFacing")
            }
            if (!mapBounds.contains(nextPosition)) break
            val nextPlace = map[nextPosition.y][nextPosition.x]
            if (nextPlace != '#') {
                visitedPlaces.add(nextPosition)
                guardPosition = nextPosition
            }
            else {
                guardFacing = when (guardFacing) {
                    '^' -> '>'
                    'v' -> '<'
                    '<' -> '^'
                    '>' -> 'v'
                    else -> throw Error("Invalid guard facing: $guardFacing")
                }
            }
        }

        visitedPlaces.size
    },
    part2 = { input ->
        val guardRegex = Regex("""[\^><v]""")
        val map = input.lines().filter { it.isNotBlank() }
        val mapBounds = IntBox2(width = map.first().length, height = map.size)

        data class GuardState(
            val position: IntVector2,
            val facing: Char,
        )

        fun hasLoop(extraObstacle: IntVector2): Boolean {
            var guardPosition = IntVector2(
                x = map.first { it.contains(guardRegex) }.indexOfFirst { it.toString().matches(guardRegex) },
                y = map.indexOfFirst { it.contains(guardRegex) }
            )
            var guardFacing = map[guardPosition.y][guardPosition.x]
            val knownStates = mutableSetOf(GuardState(guardPosition, guardFacing))

            while (mapBounds.contains(guardPosition)) {
                val nextPosition = when (guardFacing) {
                    '^' -> guardPosition + IntVector2.UP
                    'v' -> guardPosition + IntVector2.DOWN
                    '<' -> guardPosition + IntVector2.LEFT
                    '>' -> guardPosition + IntVector2.RIGHT
                    else -> throw Error("Invalid guard facing: $guardFacing")
                }
                if (!mapBounds.contains(nextPosition)) return false
                val nextPlace = map[nextPosition.y][nextPosition.x]
                if (nextPlace != '#' && nextPosition != extraObstacle) {
                    guardPosition = nextPosition
                }
                else {
                    guardFacing = when (guardFacing) {
                        '^' -> '>'
                        'v' -> '<'
                        '<' -> '^'
                        '>' -> 'v'
                        else -> throw Error("Invalid guard facing: $guardFacing")
                    }
                }
                val state = GuardState(guardPosition, guardFacing)
                if (state in knownStates) {
                    return true
                }
                knownStates.add(state)
            }

            return false
        }

        val loopCausingObstacles = (0 until mapBounds.width).flatMap { x ->
            (0 until mapBounds.height).mapNotNull { y ->
                val obstacle = IntVector2(x, y)
                if (map[obstacle.y][obstacle.x] != '#') {
                    if (hasLoop(obstacle)) obstacle else null
                }
                else null
            }
        }

        loopCausingObstacles.size
    }
)