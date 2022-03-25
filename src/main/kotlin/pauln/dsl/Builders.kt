package pauln.dsl

class CarBuilder {

    var make: String = ""
    var model: String = ""
    var engine : Engine? = null
    fun build(): Car {
        return Car(make, model,engine)
    }
}

class EngineBuilder {

    var cylinders = 0
    var cc = 0
    fun build(): Engine {
        return Engine(cylinders, cc)
    }
}