import com.csakitheone.days.day01
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

        val input1 = AOC.getInput(1) ?: throw Error("Input not found")
        day01.solvePart1(input1)
    }
}