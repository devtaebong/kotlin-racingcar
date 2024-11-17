package racingcar.application

class Car private constructor(
    var step: Int,
) {
    fun moveForward(condition: Int) {
        if (condition >= MOVE_FORWARD_THRESHOLD) {
            step++
        }
    }

    companion object {
        private const val MOVE_FORWARD_THRESHOLD = 4
        const val MOVE_FORWARD_CONDITION_BOUNDS = 10

        fun createDefault(): Car = Car(step = 0)
    }
}
