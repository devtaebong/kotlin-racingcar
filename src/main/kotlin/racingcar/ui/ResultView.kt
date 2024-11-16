package racingcar.ui

import racingcar.domain.Car
import racingcar.domain.Cars

object ResultView {

    fun printStartMessage() {
        println("실행 결과")
    }

    fun printState(cars: Cars) {
        cars.forEach(ResultView::printPosition)
        println()
    }

    private fun printPosition(car: Car) {
        val position = "-".repeat(car.position)
        println("${car.name} : $position")
    }

    fun printWinners(cars: Cars) {
        val winners = cars.getWinners()
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
