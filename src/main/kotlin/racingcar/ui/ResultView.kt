package racingcar.ui

import racingcar.application.Car
import racingcar.application.CarPosition
import racingcar.application.RaceBoard
import racingcar.application.Winner
import racingcar.ui.CarUiConstant.COMMA
import racingcar.ui.CarUiConstant.LINE_DELIMITER

object ResultView {
    fun printRacingResult(raceBoard: RaceBoard) {
        raceBoard.raceResultPerRounds
            .forEach { result ->
                printRacingResultPerRound(result.carPositions)
            }
    }

    fun printWinners(cars: List<Car>) {
        val winners = Winner.findWinners(cars)
        println("${winners.joinToString(COMMA) { it.name }}가 최종 우승 했습니다.")
    }

    private fun printRacingResultPerRound(carPositions: List<CarPosition>) {
        carPositions.forEach { carPosition ->
            println("${carPosition.name} : ${LINE_DELIMITER.repeat(carPosition.position)}")
        }
        println()
    }
}
