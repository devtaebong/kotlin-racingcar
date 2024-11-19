package racingcar.domain

import racingcar.strategy.MoveStrategy

class Car(val position: CarPosition = CarPosition()) {
    fun move(moveStrategy: MoveStrategy): Car {
        return if (moveStrategy.move()) {
            val movedPosition = position.move()
            Car(movedPosition)
        } else {
            this
        }
    }
}
