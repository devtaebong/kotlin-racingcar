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
        "-".repeat(car.position).also { println(it) }
    }
}
