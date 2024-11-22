package racingcar.view

import racingcar.domain.CarRecord
import racingcar.domain.RaceGame
import racingcar.domain.RaceRecord

class OutputView() {
    fun drawRaceGame(raceGame: RaceGame) {
        raceGame.raceResult.raceRecords.forEach { drawRace(it) }
        val winner = raceGame.raceResult.getWinner()
        println(winner.joinToString(",") { it.name })
    }

    private fun drawRace(raceRecord: RaceRecord) {
        raceRecord.cars.forEach { drawCar(it) }
        println()
    }

    private fun drawCar(carRecord: CarRecord) {
        var outputPrefix = carRecord.name + " : "
        repeat(carRecord.moveCount) { outputPrefix = "$outputPrefix-" }
        println(outputPrefix)
    }
}
