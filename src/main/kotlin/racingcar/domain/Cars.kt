package racingcar.domain

class Cars(
    private val cars: List<Car>,
) : List<Car> by cars {

    fun move() {
        cars.forEach(Car::move)
    }

    companion object {
        fun from(numberOfCars: Int): Cars {
            return Cars(List(numberOfCars) { Car() })
        }
    }
}
