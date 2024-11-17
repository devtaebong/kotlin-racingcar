package racingcar.application

import racingcar.application.Car.Companion.MOVE_FORWARD_CONDITION_BOUNDS

class RacingProcessor(
    private val randomGenerator: RandomGenerator,
) {
    fun race(cars: List<Car>): List<Car> =
        cars.map { car ->
            val randomNumber = randomGenerator.generate(MOVE_FORWARD_CONDITION_BOUNDS)
            car.moveForward(randomNumber)
            car
        }
}
