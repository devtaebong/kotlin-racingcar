package racingcar.application

class RacingGame(
    private val carMovementDecider: CarMovementDecider,
    private val cars: List<Car>,
    val raceBoard: RaceBoard,
) {
    fun race(moveTryCount: Int) {
        repeat(moveTryCount) {
            moveEachCar()
            raceBoard.recordRaceResultPerRound(cars)
        }
    }

    private fun moveEachCar() {
        cars.filter { carMovementDecider.canMove() }
            .forEach { car -> car.moveForward() }
    }
}
