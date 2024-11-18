package racingcar.ui

import racingcar.domain.Cars
import racingcar.service.dto.Output

object ResultView {

    fun printResult(output: Output) {
        printStartMessage()
        printHistory(output)
        printWinners(output.cars)
    }

    private fun printStartMessage() {
        println("실행 결과")
    }

    private fun printHistory(output: Output) {
        val racingHistory = output.racingHistory
        val result = StringBuilder()
        racingHistory.forEach { history ->
            history.forEach { (carName, position) ->
                result.append("$carName : ${"-".repeat(position)}\n")
            }
            result.append("\n")
        }
        println(result.toString())
    }

    private fun printWinners(cars: Cars) {
        val winners = cars.getWinners()
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
