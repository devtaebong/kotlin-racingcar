package racingcar.ui

object InputView {
    fun getUserInput(): Input {
        val carNames = getCarNames()
        val numberOfAttempts = getNUmberOfAttempts()
        return Input(
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

    private fun validateCarNameSize(carNames: List<String>, numberOfCars: Int) {
        if (carNames.size != numberOfCars) {
            throw IllegalArgumentException("자동차 대수와 이름의 개수가 일치하지 않습니다.")
        }
    }

    private fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대 인가요?")
        val numberOfCars = readln().toInt()
        return numberOfCars
    }
}

data class Input(
    val carNames: List<String>,
    val numberOfAttempts: Int,
)
