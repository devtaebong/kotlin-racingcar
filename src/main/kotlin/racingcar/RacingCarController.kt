package racingcar

import racingcar.domain.Cars
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val (carNames, numberOfAttempts) = InputView.getUserInput()
    val cars = Cars.from(carNames)

    ResultView.printStartMessage()
    for (i in 1..numberOfAttempts) {
        cars.move()
        ResultView.printState(cars)
    }
    ResultView.printWinners(cars)
}
