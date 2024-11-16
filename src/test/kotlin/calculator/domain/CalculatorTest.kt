package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({

    val calculator = Calculator()

    test("run()은 유효한 인자가 들어오면 수행 결과로 문자열을 반환한다.") {
        calculator.run("2 + 3 * 4 / 2") shouldBe "10.0"
        calculator.run("3 - 3 - 4 - 2") shouldBe "-6.0"
        calculator.run("2 * 3 * 4 / 2") shouldBe "12.0"
    }

    test("run()은 유효하지 않은 식이 들어오면 예외를 던진다.") {
        val invalidExpressions = mutableListOf("2 +3 * 4 / 2", "abd cdac advd", "1 +", "1+ 2", "a+ b", "a + b * c / d", "1 + 2 * 3 /")

        invalidExpressions.forEach { expression ->
            shouldThrow<IllegalArgumentException> { calculator.run(expression) }
        }
    }
})
