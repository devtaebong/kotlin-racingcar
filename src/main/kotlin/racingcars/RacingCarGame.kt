package racingcars

import racingcars.domain.Car
import racingcars.domain.Winners
import racingcars.strategy.SingleDigitRandomNumberGenerator
import racingcars.view.InputView
import racingcars.view.ResultView

class RacingCarGame(
    private val inputView: InputView,
    private val resultView: ResultView,
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

        val winners = Winners.find(racingCars)
        resultView.printWinners(winners)
    }

    private fun playRound(racingCars: List<Car>) {
        val randomNumberGenerator = SingleDigitRandomNumberGenerator()
        racingCars.forEach {
            it.moveForward(randomNumberGenerator.generate())
        }
    }
}
