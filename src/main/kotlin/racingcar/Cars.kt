package racingcar

class Cars(
    private val cars: List<Car>,
    private val movementHandler: MovementHandler,
) {
    fun move() {
        cars.filter { movementHandler.isMovable() }
            .forEach { it.move() }
    }

    fun getCars(): List<Car> {
        return cars
    }
}
