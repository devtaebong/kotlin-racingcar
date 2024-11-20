package racingcar.domain

data class RaceRound(
    val round: Int,
    val histories: Cars,
) {
    fun roundCars(): List<Car> {
        return histories.cars
    }
}
