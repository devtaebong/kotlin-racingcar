package study.step2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import step2.CalculationResult
import step2.CalculationState
import step2.Calculator

class CalculatorTest : StringSpec({

    val calculator = Calculator()

    "덧셈 연산 테스트" {
        calculator("1 + 2") shouldBe CalculationState.Success(CalculationResult(3.0))
        calculator("10 + 20") shouldBe CalculationState.Success(CalculationResult(30.0))
    }

    "뺄셈 연산 테스트" {
        calculator("3 - 2") shouldBe CalculationState.Success(CalculationResult(1.0))
        calculator("3.5 - 1.5") shouldBe CalculationState.Success(CalculationResult(2.0))
    }

    "곱셈 연산 테스트" {
        calculator("2 * 3") shouldBe CalculationState.Success(CalculationResult(6.0))
        calculator("1.5 * 2") shouldBe CalculationState.Success(CalculationResult(3.0))
        calculator("2 * 2 * 2") shouldBe CalculationState.Success(CalculationResult(8.0))
    }

    "나눗셈 연산 테스트" {
        calculator("6 / 2") shouldBe CalculationState.Success(CalculationResult(3.0))
        calculator("3 / 1.5") shouldBe CalculationState.Success(CalculationResult(2.0))
    }

    "복합 연산 테스트" {
        calculator("1 + 2 * 3") shouldBe CalculationState.Success(CalculationResult(9.0))
        calculator("10 - 5 * 2") shouldBe CalculationState.Success(CalculationResult(10.0))
        calculator("6 / 2 + 1") shouldBe CalculationState.Success(CalculationResult(4.0))
    }

    "빈 입력 테스트" {
        calculator("") should { result -> result is CalculationState.Error }
    }

    "잘못된 숫자 형식 테스트" {
        calculator("a + b") should { result -> result is CalculationState.Error }
        calculator("1.1.1 + 2") should { result -> result is CalculationState.Error }
    }

    "잘못된 연산자 테스트" {
        calculator("1 & 2") should { result -> result is CalculationState.Error }
        calculator("1 + + 2") should { result -> result is CalculationState.Error }
    }

    "잘못된 형식 테스트" {
        calculator("1 + ") should { result -> result is CalculationState.Error }
        calculator("+ 1 + 2") should { result -> result is CalculationState.Error }
    }

    "0으로 나누기 테스트" {
        calculator("4 / 0") should { result -> result is CalculationState.Error }
    }
})
