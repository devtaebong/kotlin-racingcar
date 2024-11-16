package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import java.lang.IllegalArgumentException

class InputParserTest : FunSpec({

    test("paser()는 인자로 null이 들어오면 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> { InputParser.parse(null) }
    }

    test("paser()는 인자로 빈 문자열이나 빈 공백 들어오면 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> { InputParser.parse("") }
        shouldThrow<IllegalArgumentException> { InputParser.parse("      ") }
    }
})
