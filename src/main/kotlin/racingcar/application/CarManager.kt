package racingcar.application

object CarManager {
    fun createCars(numberOfCars: Int): List<Car> = List(numberOfCars) { Car.createDefault() }
}
