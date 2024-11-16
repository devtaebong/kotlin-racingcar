package racingcar.util

class DefaultRandomGenerator : RandomGenerator {
    override fun generate(range: IntRange) = range.random()
}
