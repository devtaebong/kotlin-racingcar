package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.CarNames

class CarNamesTest : StringSpec({

    "자동차 이름은 구분자에 의해 결정된다" {
        // given & when
        val carNames = CarNames.from(listOf("abc", "bcd"))

        // then
        val names = carNames.names
        names.get(0).value shouldBe "abc"
        names.get(1).value shouldBe "bcd"
    }

    "자동차 이름에 구분자가 없으면 하나의 자동차로 결정된다" {
        // given & when
        val carNames = CarNames.from(listOf("ab-cd"))

        // then
        val names = carNames.names
        names.size shouldBe 1
        names.get(0).value shouldBe "ab-cd"
    }
})
