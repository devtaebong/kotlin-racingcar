package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    "복합 연산을 수행합니다." {
        // given
        val expression = "2 + 3 * 4 / 2 - 1"

        // when
        val calculator = Calculator()
        val result = calculator.calculate(expression)

        // then
        result shouldBe 9
    }
})
