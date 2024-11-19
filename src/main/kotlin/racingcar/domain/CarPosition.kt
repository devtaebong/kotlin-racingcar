package racingcar.domain

data class CarPosition(private val position: Int = 0) {
    fun move(): CarPosition {
        return CarPosition(position + 1)
    }

    val point: Int get() = position
}
