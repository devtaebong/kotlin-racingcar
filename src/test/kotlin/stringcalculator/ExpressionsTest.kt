package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExpressionsTest : StringSpec({
    "단항 연산자를 입력하면 수 타입으로 계산된다" {
        NumberExpression("1").evaluate() shouldBe 1
        NumberExpression("+1").evaluate() shouldBe 1
        NumberExpression("-1").evaluate() shouldBe -1
    }

    "지원하지 않는 단항 연산자를 입력하면 예외가 발생한다" {
        shouldThrowExactly<NumberFormatException> { NumberExpression("--1").evaluate() }
        shouldThrowExactly<NumberFormatException> { NumberExpression("++1").evaluate() }
        shouldThrowExactly<NumberFormatException> { NumberExpression("-+1").evaluate() }
        shouldThrowExactly<NumberFormatException> { NumberExpression("+-1").evaluate() }
    }

    "1 + 2는 3이다" {
        BinaryExpression(NumberExpression("1"), Operator.PLUS, NumberExpression("2")).evaluate() shouldBe 3
    }

    "1 - 2는 -1이다" {
        BinaryExpression(NumberExpression("1"), Operator.MINUS, NumberExpression("2")).evaluate() shouldBe -1
    }

    "1 / 2는 0.5다" {
        BinaryExpression(NumberExpression("1"), Operator.DIVIDE, NumberExpression("2")).evaluate() shouldBe 0.5
    }

    "1 * 2 는 2이다" {
        BinaryExpression(NumberExpression("1"), Operator.MULTIPLY, NumberExpression("2")).evaluate() shouldBe 2
    }
})