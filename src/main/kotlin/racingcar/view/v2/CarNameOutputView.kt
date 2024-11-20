package racingcar.view.v2

import racingcar.domain.RaceRound

class CarNameOutputView {
    fun outputWinners(raceRounds: List<RaceRound>) {
        printRaceResults(raceRounds)
        printWinners(raceRounds.last())
    }

    private fun printWinners(raceRound: RaceRound) {
        val winners = raceRound.histories.getWinners()
        println(winners.joinToString(WINNERS_DELIMITER) + WINNER_MESSAGE)
    }

    private fun printRaceResults(raceRounds: List<RaceRound>) {
        raceRounds.forEach { round ->
            println(
                round.roundCars().joinToString(CAR_NAME_SEPARATOR) { car ->
                    car.name.value + ": " + DISPLAY_SYMBOL.repeat(car.distance)
                },
            )
            println()
        }
    }

    companion object {
        private const val CAR_NAME_SEPARATOR = "\n"
        private const val DISPLAY_SYMBOL = "-"
        private const val WINNERS_DELIMITER = ", "
        private const val WINNER_MESSAGE = "가 최종 우승했습니다."
    }
}
