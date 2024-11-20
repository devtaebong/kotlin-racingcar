package racingcar.view.v1

import racingcar.domain.Car
import racingcar.view.OutputView

class CarOutputView(
    private val output: OutputView,
) {
    fun outputView(cars: List<Car>) {
        cars.forEach { car -> output.print(car.distance) }
    }
}
