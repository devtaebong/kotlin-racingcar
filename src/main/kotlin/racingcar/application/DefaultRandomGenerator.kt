package racingcar.application

import kotlin.random.Random.Default.nextInt

object DefaultRandomGenerator : RandomGenerator {
    override fun generate(until: Int): Int = nextInt(until)
}
