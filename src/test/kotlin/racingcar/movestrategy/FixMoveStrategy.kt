package racingcar.movestrategy

import racingcar.domain.movestrategy.MoveStrategy

class FixMoveStrategy(
    private val fixedInt: Int,
) : MoveStrategy {
    override fun canMove(): Boolean {
        return fixedInt >= 4
    }
}
