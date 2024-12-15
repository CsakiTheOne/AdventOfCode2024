package com.csakitheone.days

import com.csakitheone.utils.Puzzle
import kotlin.math.pow

private data class Equation(val left: String, val right: String)

private fun evalLeftToRight(expression: String): Long {
    var result = expression.takeWhile { it.isDigit() }.toLong()
    var remainingExpression = expression.removePrefix(result.toString())

    while (remainingExpression.isNotEmpty()) {
        val operator = remainingExpression.takeWhile { !it.isDigit() }
        val number = remainingExpression.drop(operator.length).takeWhile { it.isDigit() }.toLong()
        remainingExpression = remainingExpression.drop(operator.length + number.toString().length)

        result = when (operator) {
            "+" -> result + number
            "*" -> result * number
            "||" -> "$result$number".toLong()
            else -> throw Error("Invalid operator: $operator")
        }
    }

    return result
}

val day07 = Puzzle(
    day = 7,
    part1 = { input ->
        val equations = input.lines()
            .filter { it.isNotBlank() }
            .map {
                val (left, right) = it.split(": ")
                Equation(left, right)
            }

        equations
            .filter { equation ->
                val operators = listOf("+", "*")
                val numbers = equation.right.split(" ").mapNotNull { it.toIntOrNull() }

                println("Numbers: $numbers Target: ${equation.left}")

                (0..(2.0.pow(numbers.size).toInt())).forEach { p ->
                    val operatorCombinationValue = p.toString(2)
                        .padStart(numbers.size - 1, '0')

                    val expression = numbers.mapIndexed { index, n ->
                        if (index == numbers.lastIndex) return@mapIndexed n.toString()
                        return@mapIndexed "$n${operators[operatorCombinationValue[index].toString().toInt()]}"
                    }.joinToString("")

                    val result = evalLeftToRight(expression)
                    //println("Expression: $expression Result: $result")

                    if (equation.left.toLong() == result) {
                        println("Match found!\n")
                        return@filter true
                    }
                }

                println("No match found!\n")
                false
            }
            .sumOf { it.left.toLong() }
    },
    part2 = { input ->
        val equations = input.lines()
            .filter { it.isNotBlank() }
            .map {
                val (left, right) = it.split(": ")
                Equation(left, right)
            }

        equations
            .filter { equation ->
                val operators = listOf("+", "*", "||")
                val numbers = equation.right.split(" ").mapNotNull { it.toIntOrNull() }

                println("Numbers: $numbers Target: ${equation.left}")

                (0..(3.0.pow(numbers.size).toInt())).forEach { p ->
                    val operatorCombinationValue = p.toString(3)
                        .padStart(numbers.size - 1, '0')

                    val expression = numbers.mapIndexed { index, n ->
                        if (index == numbers.lastIndex) return@mapIndexed n.toString()
                        return@mapIndexed "$n${operators[operatorCombinationValue[index].toString().toInt()]}"
                    }.joinToString("")

                    val result = evalLeftToRight(expression)
                    //println("Expression: $expression Result: $result")

                    if (equation.left.toLong() == result) {
                        println("Match found!\n")
                        return@filter true
                    }
                }

                println("No match found!\n")
                false
            }
            .sumOf { it.left.toLong() }
    },
)