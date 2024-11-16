package calculator

import calculator.Calculator.calculate
import calculator.Operator.ADD
import calculator.Operator.DIVIDE
import calculator.Operator.MULTIPLY
import calculator.Operator.SUBTRACT
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly

class CalculatorTest : StringSpec({
    "덧셈 연산자를 전달하면 두 수를 더한다" {
        calculate(1.0, 2.0, ADD) shouldBeExactly 3.0
    }

    "뺄셈 연산자를 전달하면 두 수를 뺀다" {
        calculate(1.0, 2.0, SUBTRACT) shouldBeExactly -1.0
    }

    "곱셈 연산자를 전달하면 두 수를 곱한다" {
        calculate(3.0, 2.0, MULTIPLY) shouldBeExactly 6.0
    }

    "나눗셈 연산자를 전달하면 두 수를 나눈다" {
        calculate(10.0, 2.0, DIVIDE) shouldBeExactly 5.0
    }

    "나누는 수를 0과 함께 나눗셈 연산자를 전달하면 예외 발생한다" {
        shouldThrowWithMessage<IllegalArgumentException>("Division by zero is not allowed") {
            calculate(10.0, 0.0, DIVIDE)
        }
    }
})
