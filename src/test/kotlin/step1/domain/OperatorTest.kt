package step1.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class OperatorTest : FunSpec({

    test("getOperator()는 인자가 열거형에 존재하지 않으면 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> { Operator.getOperator("&") }
    }
    test("getOperator()는 유효한 연산자를 존재하면 값을 반환한다.") {
        Operator.getOperator("+") shouldBe Operator.PLUS
        Operator.getOperator("-") shouldBe Operator.MINUS
        Operator.getOperator("*") shouldBe Operator.MULTIPLY
        Operator.getOperator("/") shouldBe Operator.DIVIDE
    }
})
