package racingcar.domain

import racingcar.domain.movestrategy.MoveStrategy
import racingcar.domain.movestrategy.RandomMoveStrategy

class Car(
    val name: String,
    var position: Int = 0,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
) : Comparable<Car> {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move() {
        if (moveStrategy.canMove()) {
            position += MOVE_STEP
        }
    }

    override fun compareTo(other: Car): Int {
        return position.compareTo(other.position)
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MOVE_STEP = 1
    }
}
