package racingcar.ui

import racingcar.service.dto.Input

object InputView {
    fun getUserRequest(): Request {
        val carNames = getCarNames()
        val numberOfAttempts = getNUmberOfAttempts()
        return Request(
            carNames = carNames,
            numberOfAttempts = numberOfAttempts,
        )
    }

    private fun getNUmberOfAttempts(): Int {
        println("시도할 회수는 몇 회 인가요?")
        val numberOfAttempts = readln().toInt()
        return numberOfAttempts
    }

    private fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readln().split(",")
        return carNames
    }
}

data class Request(
    val carNames: List<String>,
    val numberOfAttempts: Int,
) {
    fun toInput(): Input {
        return Input(
            carNames = carNames,
            numberOfAttempts = numberOfAttempts,
        )
    }
}
