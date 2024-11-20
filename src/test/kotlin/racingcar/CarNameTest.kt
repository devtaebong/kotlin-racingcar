package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import racingcar.domain.CarName

class CarNameTest : StringSpec({

    "자동차 이름은 5글자 이하이면 생성 가능하다" {
        // when & then
        CarName("12345")
    }

    "자동차 이름은 5글자 이상이 되면 생성 불가능하다" {
        // when & then
        shouldThrow<IllegalArgumentException> {
            CarName("123456")
        }
    }
})
