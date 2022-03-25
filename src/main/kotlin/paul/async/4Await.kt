package paul.async

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    suspend fun calcA(): Int {
        delay(1000)
        return 1
    }

    suspend fun calcB(): Int {
        delay(1000)
        return 2
    }

    runBlocking {
        println("started")
        val a = async { calcA() }
        val b = async { calcB() }
        println(a.await() + b.await())
    }
}