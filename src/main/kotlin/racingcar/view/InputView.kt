package racingcar.view

class InputView {
    fun parse(): RacingGameInput {
        println(CAR_SETTING_MESSAGE)
        val carNames = readLine()
        println(TRY_COUNT_SETTING_MESSAGE)
        val playCount = readLine()

        return RacingGameInput(carNames = carNames, playCount = playCount)
    }

    companion object {
        private const val CAR_SETTING_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분"
        private const val TRY_COUNT_SETTING_MESSAGE = "시도할 횟수 몇 회인가요?"
    }
}
