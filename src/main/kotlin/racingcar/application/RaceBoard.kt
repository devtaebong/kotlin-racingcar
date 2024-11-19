package racingcar.application

class RaceBoard {
    private val _raceResultPerRounds: MutableList<RaceResultPerRound> = mutableListOf()
    val raceResultPerRounds: List<RaceResultPerRound>
        get() = _raceResultPerRounds.toList()

    fun recordRaceResultPerRound(cars: List<Car>) {
        this._raceResultPerRounds.add(
            RaceResultPerRound(
                carPositions =
                    cars.map {
                        CarPosition(name = it.name, position = it.position)
                    },
            ),
        )
    }
}

data class RaceResultPerRound(
    val carPositions: List<CarPosition>,
)

data class CarPosition(
    val name: String,
    val position: Int,
)
