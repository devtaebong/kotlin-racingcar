package racingcar.domain

class Race(
    val cars: List<Car>,
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    fun doRace() {
        cars.forEach { it.move() }
    }

    companion object {
        fun of(
            names: List<String>,
            numberGenerator: NumberGenerator,
        ): Race {
            val cars = names.map { Car(name = it, numberGenerator = numberGenerator) }
            return Race(cars, numberGenerator)
        }
    }
}
