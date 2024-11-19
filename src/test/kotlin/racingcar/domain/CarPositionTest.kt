package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarPositionTest : StringSpec({
    "처음 자동차 위치는 0이다" {
        val position = CarPosition()

        position shouldBe CarPosition(0)
    }

    "자동차 위치가 1 증가한다" {
        val position = CarPosition()
        val movedPosition = position.move()

        movedPosition shouldBe CarPosition(1)
    }
})
