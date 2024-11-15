package racingcar.ui

object InputView {
    fun getUserInput(): Input {
        val numberOfCars = getNumberOfCars()
        val numberOfAttempts = getNUmberOfAttempts()
        return Input(numberOfCars, numberOfAttempts)
    }

    private fun getNUmberOfAttempts(): Int {
        println("시도할 회수는 몇 회 인가요?")
        val numberOfAttempts = readln().toInt()
        return numberOfAttempts
    }

    private fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대 인가요?")
        val numberOfCars = readln().toInt()
        return numberOfCars
    }
}

data class Input(
    val numberOfCars: Int,
    val numberOfAttempts: Int,
)
