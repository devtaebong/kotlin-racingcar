package racingcar.domain

import racingcar.util.NumberGenerator
import racingcar.view.RacingGameInput

class RacingGame(racingGameInput: RacingGameInput, private val numberGenerator: NumberGenerator) {
    private val cars = Cars.createCars(racingGameInput.carNames)
    private val gameRound = GameRound(racingGameInput.playCount)

    fun play() {
        cars.tryMove(numberGenerator)
        gameRound.decrease()
    }

    fun isEnd() = gameRound.count == 0

    fun getCarsInfo(): List<Pair<String, Int>> {
        return cars.getCars().map { Pair(it.name.value, it.location.value) }
    }

    fun getWinnerInfo(): List<String> {
        val maxLocation = cars.getCars().maxOf { it.location.value }
        return cars.getCars().filter { it.location.value == maxLocation }.map { it.name.value }
    }
}
