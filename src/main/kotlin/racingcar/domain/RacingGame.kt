package racingcar.domain

import racingcar.domain.car.Cars
import racingcar.domain.history.CarHistories
import racingcar.domain.history.CarHistory
import racingcar.util.NumberGenerator

class RacingGame(
    private val cars: Cars,
    private val gameRound: GameRound,
    private val numberGenerator: NumberGenerator,
) {
    val totalCarHistories = mutableListOf<CarHistories>()

    fun play(): List<CarHistory> {
        while (!isEnd()) {
            cars.tryMove(numberGenerator)
            addHistory()
            gameRound.proceed()
        }

        return Cars.toCarHistories(cars)
    }

    fun isEnd() = gameRound.count == 0

    private fun addHistory() {
        totalCarHistories.add(Cars.toTotalCarHistories(cars))
    }
}
