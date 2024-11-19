package racingcar.application

class Winner(
    val name: String,
) {
    companion object {
        fun findWinners(cars: List<Car>): List<Winner> {
            val maxStep = cars.maxOf { it.position }
            return cars.filter { it.position == maxStep }
                .map { Winner(name = it.name) }
        }
    }
}
