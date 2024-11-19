package racingcar.application

import kotlin.random.Random

class DefaultCarMovementDecider(
    private val random: Random = Random.Default,
) : CarMovementDecider {
    override fun canMove(): Boolean {
        return random.nextInt(MOVE_FORWARD_CONDITION_BOUNDS) >= MOVE_FORWARD_THRESHOLD
    }

    companion object {
        private const val MOVE_FORWARD_CONDITION_BOUNDS = 10
        private const val MOVE_FORWARD_THRESHOLD = 4
    }
}
