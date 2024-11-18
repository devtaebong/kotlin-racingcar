package racingcar.util

class RandomGenerator : NumberGenerator {
    override fun generate(range: IntRange) = range.random()
}
