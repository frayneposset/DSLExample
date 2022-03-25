import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Stack {

    @ParameterizedTest(name = "Size {index}: {0}")
    @MethodSource("invalidAges")

    fun shouldFailToCreateAge(hint: String, sizeCandidate: Int) {

        process(hint, sizeCandidate) { _, size ->
            println("add your test using size here $size")
        }
    }

    private fun process(hint: String, sizeCandidate: Int, block: (String, Int) -> Unit) {
        block(hint, sizeCandidate)
    }

    companion object {

        @JvmStatic
        fun invalidAges(): Stream<Arguments> =
            Stream.of(
                arguments("negative", -5),
                arguments("zero", 0),
                arguments("too much", 1000)
            )
    }
}
