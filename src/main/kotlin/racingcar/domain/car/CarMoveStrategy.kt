package racingcar.domain.car

import racingcar.util.NumberGenerator

class CarMoveStrategy(numberGenerator: NumberGenerator) {
    private val numberGenerator = numberGenerator

    fun canMove() = numberGenerator.generate(RANDOM_VALUE_RANGE) >= MIN_VALUE_TO_MOVE_CAR

    companion object {
        const val MIN_VALUE_TO_MOVE_CAR = 4
        private val RANDOM_VALUE_RANGE = 0..9
    }
}
