package racingcar.strategy

private const val MIN_VALUE = 0
private const val MOVE_THRESHOLD = 4
private const val MAX_VALUE = 9

class RandomMoveStrategy : MoveStrategy {
    override fun move(): Boolean {
        return (MIN_VALUE..MAX_VALUE).random() >= MOVE_THRESHOLD
    }
}
