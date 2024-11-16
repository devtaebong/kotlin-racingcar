package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    "계산결과가 정수인 경우 소수점을 제거한다" {
        val sut = StringCalculator()
        table(
            headers("input", "expected"),
            row("1 + 1", "2"),
            row("2 + 4 * 3", "18"),
            row("10 * 10 - 1", "99"),
            row("10 * 10 / 20 + 1", "6"),
        ).forAll { input, expected ->
            sut.calculate(input) shouldBe expected
        }
    }

    "계산결과가 실수인 경우 소수점을 제거하지 않는다" {
        val sut = StringCalculator()
        table(
            headers("input", "expected"),
            row("5 + 5 / 4", "2.5"),
            row("3 * 2 / 4", "1.5"),
            row("2 * 5 / 3", "3.3333333333333335"),
        ).forAll { input, expected ->
            sut.calculate(input) shouldBe expected
        }
    }
})
