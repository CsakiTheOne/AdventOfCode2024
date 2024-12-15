import com.csakitheone.days.*
import com.csakitheone.utils.AOC
import kotlin.test.Test

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

    @Test
    fun testDay05() {
        val testInput1 = """
            47|53
            97|13
            97|61
            97|47
            75|29
            61|13
            75|53
            29|13
            97|29
            53|29
            61|53
            97|53
            61|29
            47|13
            75|47
            97|75
            47|61
            75|61
            47|29
            75|13
            53|13
            
            75,47,61,53,29
            97,61,53,29,13
            75,29,13
            75,97,47,61,53
            61,13,29
            97,13,75,29,47
        """.trimIndent()
        val testOutput1 = 143
        val testOutput2 = 123

        val input = AOC.getInput(5) ?: throw Error("Input not found")
        //day05.solvePart1(input)
        day05.solvePart2(input)
    }

    @Test
    fun testDay06() {
        val testInput1 = """
            ....#.....
            .........#
            ..........
            ..#.......
            .......#..
            ..........
            .#..^.....
            ........#.
            #.........
            ......#...
        """.trimIndent()
        val testOutput1 = 41
        val testOutput2 = 6

        val input = AOC.getInput(6) ?: throw Error("Input not found")
        assert((day06.solvePart1(input) as Int) == 4890)
        day06.solvePart2(input)
    }

    @Test
    fun testDay07() {
        val testInput1 = """
            190: 10 19
            3267: 81 40 27
            83: 17 5
            156: 15 6
            7290: 6 8 6 15
            161011: 16 10 13
            192: 17 8 14
            21037: 9 7 18 13
            292: 11 6 16 20
        """.trimIndent()
        val testOutput1 = 3749

        val input = AOC.getInput(7) ?: throw Error("Input not found")
        //assert((day07.solvePart1(input) as Long) > 180667032L)
        day07.solvePart2(input)
    }
}