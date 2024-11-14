package step1.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({

    test("run()은 유효한 인자가 들어오면 수행 결과로 문자열을 반환한다.") {
        Calculator().run("2 + 3 * 4 / 2") shouldBe "10.0"
        Calculator().run("3 - 3 - 4 - 2") shouldBe "-6.0"
        Calculator().run("2 * 3 * 4 / 2") shouldBe "12.0"
    }

    test("run()은 유효하지 않은 식이 들어오면 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> { Calculator().run("2 +3 * 4 / 2") }
        shouldThrow<IllegalArgumentException> { Calculator().run("abd cdac advd") }
        shouldThrow<IllegalArgumentException> { Calculator().run("1 +") }
        shouldThrow<IllegalArgumentException> { Calculator().run("1+ 2") }
        shouldThrow<IllegalArgumentException> { Calculator().run("a+ b") }
        shouldThrow<IllegalArgumentException> { Calculator().run("a + b * c / d") }
        shouldThrow<IllegalArgumentException> { Calculator().run("1 + 2 * 3 /") }
    }
})
