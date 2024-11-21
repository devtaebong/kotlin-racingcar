package racingcar

import racingcar.controller.GameController
import racingcar.view.InputView

fun main() {
    val inputView = InputView()
    val racingGameInput = inputView.parse()
    GameController().run(racingGameInput)
}
