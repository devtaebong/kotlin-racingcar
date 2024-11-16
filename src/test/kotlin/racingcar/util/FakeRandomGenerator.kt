package racingcar.util

import racingcar.domain.RacingGame.Companion.MIN_VALUE_TO_MOVE_CAR

class FakeRandomGenerator : RandomGenerator {
    override fun generate(range: IntRange): Int = MIN_VALUE_TO_MOVE_CAR
}
