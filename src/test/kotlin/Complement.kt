import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Complement {

    @Test
    fun test1() {
        makeComplement("TAACG") shouldBe "ATTGC"
    }

}
fun makeComplement(dna: String): String {

    return dna.toCharArray().map { char ->
        mutableMapOf("A" to "T", "G" to "C").apply {
            putAll(entries.associate { it.value to it.key })
        }[char.toString()]
    }.joinToString(separator = "")

}