package racingcar.domain

data class Cars(val cars: List<Car>) {
    fun move(numberGenerator: NumberGenerator) {
        cars.filter { it.isMovable(numberGenerator.generate()) }
            .forEach(Car::move)
    }

    // TODO: 객체 깊은 복사를 다른 방법으로 수정 우쨔,,,,?
    fun copy(): Cars {
        return Cars(cars.map { Car(it.name, it.distance) })
    }

    fun getWinners(): List<String> {
        val maxDistance = getMaxDistance()
        return cars
            .filter { it.isMaxDistance(maxDistance) }
            .map { it.name.value }
    }

    private fun getMaxDistance(): Int {
        return cars.maxOf { it.distance }
    }

    companion object {
        fun joined(carNames: CarNames): Cars {
            return Cars(carNames.names.map { Car(it) })
        }
    }
}
