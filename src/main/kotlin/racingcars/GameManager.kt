package racingcars

import racingcars.ui.InputView
import racingcars.ui.ResultView
import racingcars.util.findWinners
import racingcars.util.validateCarInput

class GameManager(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val randomNumberGenerator: RandomNumberGenerator,
) {
    fun start() {
        val racingCarNames = inputView.getCarNames()
        val numberOfCar = inputView.getNumberOfCars()
        val attemptCount = inputView.getAttemptCount()
        val racingCars = createCarOrThrow(racingCarNames, numberOfCar)
        repeat(attemptCount) {
            playRound(racingCars)
            resultView.printRaceResults(racingCars)
        }
        val winners = findWinners(racingCars)
        resultView.printWinners(winners)
    }

    private fun createCarOrThrow(
        racingCarNames: List<String>,
        numberOfCars: Int,
    ): List<Car> {
        validateCarInput(racingCarNames, numberOfCars)
        return (1..numberOfCars).map { id -> Car(id = id, racingCarNames[id - 1]) }
    }

    private fun playRound(racingCars: List<Car>) {
        racingCars.forEach {
            it.moveForward(randomNumberGenerator.generate())
        }
    }
}
