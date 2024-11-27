package racingcars

import racingcars.view.InputView
import racingcars.view.ResultView

fun main() {
    val inputView = InputView { readln() }
    val resultView = ResultView()
    val racingCarController = RacingCarGame(inputView = inputView, resultView = resultView)
    racingCarController.start()
}
