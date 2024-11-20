package racingcar.domain

class RacingGame(
    private val cars: Cars,
    private val round: Round,
    private val numberGenerator: NumberGenerator,
) {
    fun play(): List<RaceRound> {
        val raceRounds = mutableListOf<RaceRound>()

        while (round.isFinished().not()) {
            cars.move(numberGenerator)
            round.end()
            raceRounds.add(RaceRound(round.value, cars.copy()))
        }
        return raceRounds
    }
}
