import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

data class SimRetrieveDevicesResponse(
    val data: Devices,
    val error: String? = null,
)

data class Devices(val devices: Map<String, List<DeviceInfo>>)
data class DeviceInfo(
    val device_id: String,
    val device_type: String,
    val network_id: String,
    val send_period_sec: Int,
    val loss_in_thousand: Int,
    val tti_application_id: String,
    val cmt_tenant_id: String,
)

class StackOverFlowTest {
    @Test
    fun test() {

        val data = """
       {
         "data": {
           "devices": {
             "600": [
               {
                 "device_id": "device_id",
                 "device_type": "device_type",
                 "network_id": "network_id",
                 "send_period_sec": 2,
                 "loss_in_thousand": 3,
                 "tti_application_id": "tti_application_id",
                 "cmt_tenant_id": "cmt_tenant_id"
                 
               }
             ]
           }
         }
       }
      """.trimIndent()

        val mapper = jacksonObjectMapper()

        val response = mapper.readValue(data, SimRetrieveDevicesResponse::class.java)

        val device = response.data.devices["600"]
        withClue("Device should be present") {
            device.shouldNotBe(null)
        }
        device!!.first().device_id shouldBe "device_id"
    }
}

