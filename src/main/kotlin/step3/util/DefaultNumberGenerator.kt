package step3.util

import kotlin.random.Random

private const val RANDOM_MAX_NUMBER = 10

class DefaultNumberGenerator : NumberGenerator {
    override fun generator(): Int {
        return Random.nextInt(RANDOM_MAX_NUMBER)
    }
}
