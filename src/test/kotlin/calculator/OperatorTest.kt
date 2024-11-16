package calculator

import calculator.Operator.ADD
import calculator.Operator.Companion.fromToken
import calculator.Operator.Companion.isOperator
import calculator.Operator.DIVIDE
import calculator.Operator.MULTIPLY
import calculator.Operator.SUBTRACT
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.inspectors.forAll
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class OperatorTest : StringSpec({
    "더하기 연산자는 더하기를 수행한다" {
        ADD.operate(1.0, 2.0) shouldBeExactly 3.0
    }
    "뺄셈 연산자는 뺄셈을 수행한다" {
        SUBTRACT.operate(5.0, 3.0) shouldBeExactly 2.0
    }

    "곱셈 연산자는 곱셈을 수행한다" {
        MULTIPLY.operate(2.0, 4.0) shouldBeExactly 8.0
    }

    "나눗셈 연산자는 나눗셈을 수행한다" {
        DIVIDE.operate(6.0, 2.0) shouldBeExactly 3.0
    }

    "0으로 나누는 경우 예외 발생한다" {
        shouldThrowWithMessage<IllegalArgumentException>("Division by zero is not allowed") {
            DIVIDE.operate(10.0, 0.0)
        }
    }

    "token 을 통해 symbol 을 추출한다" {
        table(
            headers("token", "expected"),
            row("+", ADD),
            row("-", SUBTRACT),
            row("*", MULTIPLY),
            row("/", DIVIDE),
        ).forAll { token, expected ->
            fromToken(token) shouldBe expected
        }
    }

    "token 이 존재하지 않는 symbol 일 경우 예외 발생한다" {
        listOf("^", "&", "$", "#", "@").forAll { token ->
            val exception =
                shouldThrow<IllegalArgumentException> {
                    fromToken(token)
                }
            exception.message shouldContain token
        }
    }

    "문자열 토큰이 심볼과 일치하는 경우 참을 반환한다" {
        listOf("+", "-", "*", "/").forAll { token ->
            token.isOperator() shouldBe true
        }
    }

    "문자열 토큰이 심볼과 일치하지 않는 경우 거짓을 반환한다" {
        listOf("^", "&", "$", "#", "@").forAll { token ->
            token.isOperator() shouldBe false
        }
    }
})
