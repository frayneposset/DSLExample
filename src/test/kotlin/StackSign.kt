import TestSingleton.staticMethod1
import io.mockk.every
import io.mockk.just
import io.mockk.mockkStatic
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Test

internal object TestSingleton {
    @JvmStatic
    fun staticMethod1(str: String) {
        println("+++ === +++ TestSingleton.staticMethod(), $str")
        staticMethod2(str)
    }

    @JvmStatic
    fun staticMethod2(str: String) {
        println("+++ === +++ TestSingleton.staticMethod2(), $str")
    }
}

class StackSign {

    @Test
    fun test_staticMethod() {

        mockkStatic(TestSingleton::class)
        every { TestSingleton.staticMethod2("test") } just runs
        staticMethod1("test")
        verify(exactly = 1) { TestSingleton.staticMethod2("test") }
    }
}
