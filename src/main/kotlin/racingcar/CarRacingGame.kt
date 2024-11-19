package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.strategy.MoveStrategy

class CarRacingGame(
    carCount: Int,
    private val rounds: Int,
) {
    private val cars: Cars = Cars(List(carCount) { Car() })

    fun play(moveStrategy: MoveStrategy): List<Cars> {
        val results = mutableListOf<Cars>()
        var currentCars = cars
        repeat(rounds) {
            currentCars = currentCars.move(moveStrategy)
            results.add(currentCars)
        }

        return results
    }
}
