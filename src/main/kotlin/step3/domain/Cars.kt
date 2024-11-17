package step3.domain

import step3.util.NumberGenerator

class Cars(userCount: Int) {
    private val cars: List<Car> = List(userCount) { Car.init() }

    fun race(generator: NumberGenerator) {
        for (car in cars) {
            val number = generator.generator()
            car.move(number)
        }
    }

    fun positions(): List<Position> {
        val positions: MutableList<Position> = ArrayList()
        for (car in cars) {
            positions.add(car.position())
        }
        return positions
    }
}
