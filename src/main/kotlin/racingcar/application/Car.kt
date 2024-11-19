package racingcar.application

class Car private constructor(
    val name: String,
    var position: Int,
) {
    init {
        require(name.trim().length <= CAR_NAME_LENGTH_LIMIT) { "자동차 이름은 5자를 초과할 수 없습니다" }
    }

    fun moveForward() {
        position++
    }

    companion object {
        private const val CAR_NAME_LENGTH_LIMIT = 5
        private const val STARTING_POSITION = 0

        fun createDefault(name: String): Car {
            return Car(
                name = name,
                position = STARTING_POSITION,
            )
        }
    }
}
