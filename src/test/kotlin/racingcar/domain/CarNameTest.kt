package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.car.CarName
import java.lang.IllegalArgumentException

class CarNameTest : StringSpec({

    "자동차 이름은 빈 값이면 초기화 시 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { CarName("") }
    }

    "자동차 이름은 5자를 초과하면 초기화 시 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { CarName("123456") }
    }

    "자동차 이름은 5자를 이하 시 정상 생성된다.." {
        val name = "12345"
        CarName(name).value shouldBe name
    }
})
