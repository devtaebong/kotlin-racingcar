package racingcars

data class Car(
    val id: Int,
    private var _position: Int = DEFAULT_POSITION,
) {
    val position: Int
        get() = _position

    fun moveForward(condition: Int) {
        if (condition >= FORWARD_NUMBER) {
            _position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val FORWARD_NUMBER = 4
    }
}
