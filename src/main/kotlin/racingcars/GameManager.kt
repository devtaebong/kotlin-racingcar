package racingcars

import racingcars.ui.InputView
import racingcars.ui.ResultView

class GameManager(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val randomNumberGenerator: RandomNumberGenerator,
) {
    fun start() {
        val racingCarNames = inputView.getCarNames()
        val numberOfCar = inputView.getNumberOfCars()
        val attemptCount = inputView.getAttemptCount()
        val racingCars = Car.fromInput(numberOfCar, racingCarNames)
        repeat(attemptCount) {
            playRound(racingCars)
            resultView.printRaceResults(racingCars)
        }
        val winners = findWinners(racingCars)
        resultView.printWinners(winners)
    }

    private fun findWinners(racingCars: List<Car>): List<Car> {
        val maxPosition = racingCars.maxOfOrNull { it.position } ?: 0
        return racingCars.filter { it.position == maxPosition }
    }

    private fun playRound(racingCars: List<Car>) {
        racingCars.forEach {
            it.moveForward(randomNumberGenerator.generate())
        }
    }
}
