package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({

    "덧셈 연산자는 덧셈을 수행합니다." {
        // given
        val expression = "2 + 3"

        // when
        val result = StringCalculator().calculate(expression)

        // then
        result shouldBe 5
    }

    "뺄셈 연산자는 뺄셈을 수행합니다." {
        // given
        val expression = "2 - 3"

        // when
        val result = StringCalculator().calculate(expression)

        // then
        result shouldBe -1
    }

    "곱셈 연산자는 곱셈을 수행합니다." {
        // given
        val expression = "2 * 3"

        // when
        val result = StringCalculator().calculate(expression)

        // then
        result shouldBe 6
    }

    "나눗셈 연산자는 나눗셈을 수행합니다." {
        // given
        val expression = "6 / 3"

        // when
        val result = StringCalculator().calculate(expression)

        // then
        result shouldBe 2
    }

    "0으로 나눌 수 없습니다." {
        // given
        val expression = "6 / 0"

        // when & then
        val calculator = StringCalculator()
        shouldThrow<IllegalArgumentException> {
            calculator.calculate(expression)
        }
    }
})
