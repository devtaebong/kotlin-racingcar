package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class OperatorTest : FunSpec({

    val operand1 = Operand("6")
    val operand2 = Operand("2")

    test("getOperator()는 인자가 열거형에 존재하지 않으면 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> { Operator.getOperator("&") }
    }
    test("getOperator()는 유효한 연산자를 존재하면 값을 반환한다.") {
        Operator.getOperator("+") shouldBe Operator.PLUS
        Operator.getOperator("-") shouldBe Operator.MINUS
        Operator.getOperator("*") shouldBe Operator.MULTIPLY
        Operator.getOperator("/") shouldBe Operator.DIVIDE
    }

    test("+ 는 두 피연산자를 더한 값을 반환한다.") {
        val operator = Operator.PLUS

        operator.value shouldBe "+"
        operator.operate(operand1, operand2) shouldBe 8.0
    }

    test("- 는 두 피연산자를 뺸 값을 반환한다.") {
        val operator = Operator.MINUS

        operator.value shouldBe "-"
        operator.operate(operand1, operand2) shouldBe 4.0
    }

    test("* 는 두 피연산자를 곱한 값을 반환한다.") {
        val operator = Operator.MULTIPLY

        operator.value shouldBe "*"
        operator.operate(operand1, operand2) shouldBe 12.0
    }

    test("/ 는 두 피연산자를 나눈 값을 반환한다.") {
        val operator = Operator.DIVIDE

        operator.value shouldBe "/"
        operator.operate(operand1, operand2) shouldBe 3.0
    }
})
