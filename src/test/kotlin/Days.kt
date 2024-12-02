import com.csakitheone.days.day01
import com.csakitheone.days.day02
import com.csakitheone.utils.AOC
import kotlin.test.Test
import kotlin.test.assertTrue

class Days {
    @Test
    fun testDay01() {
        val testInput1 = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent()
        val testOutput1 = 11

        val input = AOC.getInput(1) ?: throw Error("Input not found")
        day01.solvePart1(input)
        day01.solvePart2(input)
    }

    @Test
    fun testDay02() {
        val testInput1 = """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimIndent()
        val testOutput1 = 2

        val input = AOC.getInput(2) ?: throw Error("Input not found")
        day02.solvePart1(input)
        day02.solvePart2(input)
    }
}