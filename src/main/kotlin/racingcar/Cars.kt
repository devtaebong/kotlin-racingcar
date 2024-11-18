package racingcar

class Cars(private val cars: List<Car>) {
    fun move(numberGenerator: NumberGenerator) {
        cars.filter { it.isMovable(numberGenerator.generate()) }
            .forEach(Car::move)
    }

    fun print() {
        cars.forEach { println("${it.getName()} : ${it.getDisplayDistance()}") }
        println()
    }

    fun getWinners(): List<Car> {
        val max = cars.maxOf { it.getDistance() }
        return cars.filter { it.getDistance() == max }
    }

    fun getCars(): List<Car> {
        return cars
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","

        fun joined(carNames: String): Cars {
            return Cars(carNames.split(CAR_NAME_DELIMITER).map { Car(it) })
        }
    }
}
