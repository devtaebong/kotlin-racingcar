package racingcar.domain

import racingcar.util.RandomGenerator

class RacingGame(size: Int, randomGenerator: RandomGenerator) {
    private val cars: List<Car> = List(size) { Car() }
    private val randomGenerator = randomGenerator

    fun tryMove() {
        cars.forEach {
            if (randomGenerator.generate(RANDOM_VALUE_RANGE) >= MIN_VALUE_TO_MOVE_CAR) {
                it.move()
            }
        }
    }

    fun getLocations() = cars.map { it.location }.toList()

    companion object {
        const val MIN_VALUE_TO_MOVE_CAR = 4
        private val RANDOM_VALUE_RANGE = 0..9
    }
}
