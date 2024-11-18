package racingcar.controller

import racingcar.service.RacingCarService
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val request = InputView.getUserRequest()
    val input = request.toInput()
    val output = RacingCarService().run(input)
    ResultView.printResult(output)
}
