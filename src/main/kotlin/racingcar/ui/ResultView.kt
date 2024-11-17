package racingcar.ui

import racingcar.application.Car

object ResultView {
    fun print(cars: List<Car>) {
        cars.forEach { car ->
            println(makeLine(count = car.step))
        }
        println()
    }

    private fun makeLine(count: Int): String =
        StringBuilder()
            .append("-".repeat(count))
            .toString()
}
