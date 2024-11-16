package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ParsedExpressionTest : FunSpec({

    test("ParsedExpression은 사이즈가 3미만의 리스트를 생성하면 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> { ParsedExpression("1+b") }
        shouldThrow<IllegalArgumentException> { ParsedExpression("1+2") }
        shouldThrow<IllegalArgumentException> { ParsedExpression("ab +2") }
    }

    test("ParsedExpression은 사이즈가 3 이상, 리스트이 사이즈가 홀수개의 원소를 가진 리스트는 정상적으로 생성된다") {
        ParsedExpression("1 + b + 2").isCanCalculate() shouldBe true
        ParsedExpression("ab + asd - aa").isCanCalculate() shouldBe true
    }
})
