package racingcar.domain.car

import racingcar.domain.history.CarHistories
import racingcar.domain.history.CarHistory
import racingcar.util.NumberGenerator

class Cars(private val cars: List<Car>) {
    fun tryMove(numberGenerator: NumberGenerator) {
        cars.forEach {
            if (CarMoveStrategy(numberGenerator).canMove()) {
                it.move()
            }
        }
    }

    fun getCars() = cars

    companion object {
        fun createCars(names: String?): Cars {
            require(!names.isNullOrBlank()) { "입력 값은 널이나 빈 값이 될 수 없습니다." }
            return Cars(names.split(",").map { Car(CarName(it), CarLocation(CarLocation.DEFAULT_VALUE)) })
        }

        fun toTotalCarHistories(data: Cars): CarHistories =
            CarHistories(
                data.cars.map {
                    CarHistory(
                        it.getNameValue(),
                        it.getLocationValue(),
                    )
                },
            )

        fun toCarHistories(data: Cars): List<CarHistory> =
            data.cars.map {
                CarHistory(
                    it.getNameValue(),
                    it.getLocationValue(),
                )
            }
    }
}
