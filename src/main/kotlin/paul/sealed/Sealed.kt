package paul.sealed

sealed class DTO {
    abstract val id: String
}

data class SmobGroupDTO(override val id: String = "invalid smob user id", val name: String = "") : DTO()
data class SmobListDTO(override val id: String = "invalid smob user id", val name: String = "") : DTO()

fun main() {

    fun processDTO(dto: DTO): String {

        return when (dto) {
            is SmobGroupDTO -> "Group"
            is SmobListDTO -> "List"
        }

    }
}