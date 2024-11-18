package racingcar

import racingcar.view.InputView
import racingcar.view.v2.CarNameInputView
import racingcar.view.v2.CarNameOutputView

fun main() {
    // input
    val inputView = CarNameInputView(InputView())
    val carNames = inputView.inputCarCount()
    val tryCount = inputView.inputRoundCount()

    val game = RacingGame(carNames, Round(tryCount), SecureNumberGenerator())
    val playedCars = game.play()
    val winners = playedCars.getWinners()

    // output
    val outputView = CarNameOutputView()
    val joinedWinners = winners.joinToString(", ") { it.getName() }
    outputView.outputWinners(joinedWinners)
}
