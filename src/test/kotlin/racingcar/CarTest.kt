package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "자동차가 움직이는지 확인한다" {
        // given
        val car = Car()

        // when
        car.move()

        // then
        car.getDistance() shouldBe 1
    }
})
