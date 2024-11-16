package calculator

import calculator.Operator.ADD
import calculator.Operator.DIVIDE
import calculator.Operator.MULTIPLY
import calculator.Operator.SUBTRACT
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

class InputParserTest : StringSpec({
    "입력값을 파싱하는 경우 숫자리스트와 사칙연산리스트를 반환한다" {
        val sut = InputParser(InputValidator())
        val actual = sut.parse("1 + 2 - 3 * 4 / 5")

        actual.numbers shouldContainExactly listOf(1.0, 2.0, 3.0, 4.0, 5.0)
        actual.operators shouldContainExactly listOf(ADD, SUBTRACT, MULTIPLY, DIVIDE)
    }
})
