package racingcar.domain

import racingcar.strategy.MoveStrategy

data class Cars(private val cars: List<Car>) {
    fun move(moveStrategy: MoveStrategy): Cars {
        return Cars(cars.map { it.move(moveStrategy) })
    }

    fun getPositions(): List<Int> {
        return cars.map { it.position.point }
    }
}
