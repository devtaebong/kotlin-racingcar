package calculator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class InputValidatorTest : StringSpec({
    "입력값이 공백인 경우 예외 발생한다" {
        val sut = InputValidator()
        shouldThrowWithMessage<IllegalArgumentException>("The input cannot be null or blank") {
            sut.validate(" ")
        }
    }

    "입력값이 사칙연산이 아닌 문자열 포함한 경우 예외 발생한다" {
        val sut = InputValidator()
        listOf("a", "a + 2", "3 + a", "3 $ 3", "%$").forAll {
            shouldThrowWithMessage<IllegalArgumentException>("There is an invalid input") {
                sut.validate(it)
            }
        }
    }

    "숫자와 입력값이 순서대로 나오지 않은 경우 예외 발생한다" {
        val sut = InputValidator()
        listOf("1 +", "+ 1", "1 + 2 +", "+ 2 + 2").forAll {
            shouldThrowWithMessage<IllegalArgumentException>("There is an invalid input") {
                sut.validate(it)
            }
        }
    }
})
