package racingcar.util

class FakeRandomGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
    override fun generate(range: IntRange) = numbers.removeFirst()
}
