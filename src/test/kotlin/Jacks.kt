import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule


data class Simple(val x: String, val y: String)
data class Test2(val simple: Simple)


fun main() {

    val xmlDeserializer = XmlMapper(JacksonXmlModule().apply {
        setDefaultUseWrapper(false)
    }).registerKotlinModule()
        .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    val simple = Simple("x","y")
    val test = Test2(simple)
    println(xmlDeserializer.writeValueAsString(test))

    val stringToParse = "<Test><Simple><x>1</x><y>2</y></Simple></Test>"
    val finalObject = xmlDeserializer.readValue(stringToParse, Test2::class.java)
    println(finalObject.simple.x)
}