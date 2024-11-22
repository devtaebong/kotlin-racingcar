package racingcar.domain

class Car(
    val name: String,
    initialMove: Int = 0,
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    var moveCount = initialMove
        private set

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름이 너무 길어요" }
    }

    fun move() {
        val number = numberGenerator.getNumber()
        if (number >= MOVE_MINIMUM_VALUE) {
            moveCount++
        }
    }

    companion object {
        private const val MOVE_MINIMUM_VALUE = 4
        private const val MAX_NAME_LENGTH = 5
    }
}
