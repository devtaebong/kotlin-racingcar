package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import java.lang.IllegalArgumentException

class InputTest : FunSpec({

    test("입력 값은 빈값이나 null이면 예외를 던진다.") {

        shouldThrow<IllegalArgumentException> { Input("", null) }
        shouldThrow<IllegalArgumentException> { Input("", "") }
        shouldThrow<IllegalArgumentException> { Input(null, "") }
        shouldThrow<IllegalArgumentException> { Input(null, null) }
    }

    test("입력 값은 양수가 아니면 예외를 던진다.") {

        shouldThrow<IllegalArgumentException> { Input("-1", "0") }
        shouldThrow<IllegalArgumentException> { Input("0", "-1") }
        shouldThrow<IllegalArgumentException> { Input("-1", "-1") }
        shouldThrow<IllegalArgumentException> { Input("0", "0") }
    }
})
