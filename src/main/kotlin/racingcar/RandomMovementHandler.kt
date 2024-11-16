package racingcar

class RandomMovementHandler(
    private val randomGenerator: RandomGenerator,
) : MovementHandler {
    override fun isMovable(): Boolean {
        val random = randomGenerator.generate()
        return random >= Car.MOVE_CONDITION
    }
}
