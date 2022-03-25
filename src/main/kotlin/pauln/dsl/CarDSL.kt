package pauln.dsl



class CarDSL {

    val engineBuilder : EngineBuilder = EngineBuilder()
    val carBuilder = CarBuilder()

     fun create(block: CarBuilder.() -> Unit): Car {

         fun engine(block: EngineBuilder.() -> Unit): Unit {

             engineBuilder.block()
             val engine = engineBuilder.build()
             carBuilder.engine = engine
         }


         carBuilder.block()
        return carBuilder.build()
    }




}