package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class ExpressionsTest : StringSpec({

    "식이 빈 문자열이면 IllegalArgumentException을 던집니다" {
        // given
        val expression = ""

        // when & then
        shouldThrow<IllegalArgumentException> {
            StringCalculator().calculate(expression)
        }
    }

    "식에 사칙 연산자(+,-,*,/)가 없으면 IllegalArgumentException을 던집니다" {
        // given
        val expression = "2 ! 1"

        // when & then
        shouldThrow<IllegalArgumentException> {
            StringCalculator().calculate(expression)
        }
    }

    "식에 숫자가 아닌 문자가 포함되어 있으면 IllegalArgumentException을 던집니다" {
        // given
        val expression = "2 + a"

        // when & then
        shouldThrow<IllegalArgumentException> {
            StringCalculator().calculate(expression)
        }
    }
})
