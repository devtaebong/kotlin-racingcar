package racingcar

import racingcar.view.CarInputView
import racingcar.view.CarOutputView
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val game = RacingGame(CarInputView(InputView()), CarOutputView(OutputView()))
    game.start()
}
