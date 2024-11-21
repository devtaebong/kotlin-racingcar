package calculator.domain
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class OperandTest : FunSpec({

    test("피연산자는 생성 시 입력값이 숫자면 정상적으로 Double형 값을 가진 객체로 생성된다") {
        val operand1 = Operand("2.0")
        val operand2 = Operand("2")

        operand1.value shouldBe 2.0
        operand2.value shouldBe 2.0
    }

    test("피연산자는 생성 시 입력값이 빈 값이면 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> { Operand("") }
    }
})
