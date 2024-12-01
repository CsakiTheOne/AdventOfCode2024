import com.csakitheone.utils.AOC
import kotlin.test.Test
import kotlin.test.assertTrue

class Utils {
    @Test
    fun getInputFromWebTest() {
        val input = AOC.getInputFromWeb(1, 2023)
        val isValid = (input?.lines()?.size ?: 0) > 2
        if (!isValid) println(input)
        assertTrue { isValid }
    }
}