import com.csakitheone.days.day01
import com.csakitheone.days.day02
import com.csakitheone.days.day03
import com.csakitheone.days.day04
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

    @Test
    fun testDay03() {
        val testInput1 = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        val testOutput1 = 161

        val input = AOC.getInput(3) ?: throw Error("Input not found")
        day03.solvePart1(input)
        day03.solvePart2(input)
    }

    @Test
    fun testDay04() {
        val testInput1 = """
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
        """.trimIndent()
        val testOutput1 = 18
        val testInput2 = """
            .M.S......
            ..A..MSMS.
            .M.S.MAA..
            ..A.ASMSM.
            .M.S.M....
            ..........
            S.S.S.S.S.
            .A.A.A.A..
            M.M.M.M.M.
            ..........
        """.trimIndent()
        val testOutput2 = 9

        val input = AOC.getInput(4) ?: throw Error("Input not found")
        //assert((day04.solvePart1(input) as Int) > 2629)
        assert((1076..1989).contains(day04.solvePart2(input) as Int))
    }
}