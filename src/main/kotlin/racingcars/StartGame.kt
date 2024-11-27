package racingcars

import racingcars.ui.InputView
import racingcars.ui.ResultView

fun main() {
    start()
}

fun start() {
    val inputView = InputView { readln() }
    val resultView = ResultView()
    val racingCarNames = inputView.getCarNames()
    val numberOfCar = inputView.getNumberOfCars()
    val attemptCount = inputView.getAttemptCount()

    val racingCars = Car.fromInput(numberOfCar, racingCarNames)
    repeat(attemptCount) {
        playRound(racingCars)
        resultView.printRaceResults(racingCars)
    }
    val winners = Car.findWinners(racingCars)
    resultView.printWinners(winners)
}

private fun playRound(racingCars: List<Car>) {
    val randomNumberGenerator = SingleDigitRandomNumberGenerator()
    racingCars.forEach {
        it.moveForward(randomNumberGenerator.generate())
    }
}