package racingcar.view.v1

import racingcar.view.InputView

class CarInputView(
    private val input: InputView,
) {
    fun inputCarCount(): Int {
        println(CAR_VIEW_MESSAGE)
        return input.getInput().toInt()
    }

    fun inputRoundCount(): Int {
        println(TRY_VIEW_MESSAGE)
        return input.getInput().toInt()
    }

    companion object {
        private const val CAR_VIEW_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val TRY_VIEW_MESSAGE = "시도할 회수는 몇 회인가요?"
    }
}
