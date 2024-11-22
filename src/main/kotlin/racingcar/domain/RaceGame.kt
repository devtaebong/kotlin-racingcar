package racingcar.domain

class RaceGame(
    val race: Race,
    var raceResult: RaceResult,
) {
    fun doRaceGame(numberOfTry: Int) {
        repeat(numberOfTry) {
            race.doRace()
            val raceRecord = RaceRecord(race)
            raceResult = raceResult.addRaceRecord(raceRecord)
        }
    }

    companion object {
        fun of(
            names: List<String>,
            numberGenerator: NumberGenerator,
        ): RaceGame {
            val race = Race.Companion.of(names, numberGenerator)
            val raceResult = RaceResult(listOf())
            return RaceGame(race, raceResult)
        }
    }
}
