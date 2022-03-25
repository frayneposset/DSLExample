import io.kotest.matchers.shouldBe
import org.jetbrains.annotations.TestOnly
import org.junit.jupiter.api.Test
import pauln.dsl.CarBuilder
import pauln.dsl.CarDSL

class CarTest {

    @Test
    fun dslTest() {

        val car = CarDSL().create {
            model = "Puma"
            make = "Ford"
//            engine  {
//
//            }
        }
        car.make shouldBe "Ford"
        car.model shouldBe "Puma"
    }


}