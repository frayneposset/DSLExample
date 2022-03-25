package pauln.dsl

data class Car(val make: String, val model: String, val engine: Engine?)

data class Engine(val cylinders : Int, val cc : Int)
