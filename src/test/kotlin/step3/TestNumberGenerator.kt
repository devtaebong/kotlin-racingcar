package step3

import step3.util.NumberGenerator

class TestNumberGenerator(private val number: Int) : NumberGenerator {
    override fun generator(): Int {
        return number
    }
}
