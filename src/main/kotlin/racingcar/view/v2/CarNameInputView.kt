package racingcar.view.v2

import racingcar.view.InputView

class CarNameInputView(
    private val input: InputView,
) {
    fun inputCarCount(): String {
        println(CAR_NAME_VIEW_MESSAGE)

        val input = input.getInput()
        require(input.isNotBlank()) { "자동차 이름은 공백일 수 없습니다." }

        return input
    }

    fun inputRoundCount(): Int {
        println(TRY_VIEW_MESSAGE)

        val input = input.getInput()
        require(input.isNotBlank()) { "시도 횟수는 공백일 수 없습니다." }

        return input.toInt()
    }

    companion object {
        const val CAR_NAME_VIEW_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val TRY_VIEW_MESSAGE = "시도할 회수는 몇 회인가요?"
    }
}
