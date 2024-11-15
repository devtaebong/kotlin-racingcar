package racingcar.domain.movestrategy

import kotlin.random.Random

class RandomMoveStrategy : MoveStrategy {
    override fun canMove(): Boolean {
        return Random.nextInt(0, 10) >= 4
    }
}
