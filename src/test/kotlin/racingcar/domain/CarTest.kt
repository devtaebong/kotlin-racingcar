package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "전진 조건을 만족하면 차는 전진한다" {
        val car = Car().move { true }

        car.position shouldBe CarPosition(1)
    }

    "전진 조건을 만족하지 않으면 차는 전진하지 않는다" {
        val car = Car().move { false }

        car.position shouldBe CarPosition(0)
    }
})
