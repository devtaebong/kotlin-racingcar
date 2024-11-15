package racingcar.domain

import racingcar.domain.movestrategy.MoveStrategy
import racingcar.domain.movestrategy.RandomMoveStrategy

class Car(
    position: Int = 0,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
) {

    var position = position
        private set

    fun move() {
        if (moveStrategy.canMove()) {
            position += 1
        }
    }
}
