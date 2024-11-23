package racingcars.ui

import racingcars.Car

class ResultView {
    fun printRaceResults(racingCars: List<Car>) = printCurrentPosition(racingCars)

    private fun printCurrentPosition(racingCars: List<Car>) {
        racingCars.forEach { car ->
            val positionString = positionToString(car.position)
            println("${car.name} : $positionString")
        }
        println()
    }

    private fun positionToString(position: Int): String {
        return "-".repeat(position)
    }

    fun printWinners(winnersCar: List<Car>) {
        val winnerNames = winnersCar.joinToString(", ") { it.name }
        println("${winnerNames}이 최종 우승했습니다.")
    }
}
