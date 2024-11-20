package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.CarName

class CarTest : StringSpec({

    "자동차가 움직이는지 확인한다" {
        // given
        val car = Car(CarName("tally"))

        // when
        car.move()

        // then
        car.distance shouldBe 1
    }

    "자동차가 움직일 수 없는지 확인한다" {
        // given
        val car = Car(CarName("tally"))

        // when
        val movable = car.isMovable(3)

        // then
        movable shouldBe false
    }

    "자동차가 움직일 수 있는지 확인한다" {
        // given
        val car = Car(CarName("tally"))

        // when
        val movable = car.isMovable(4)

        // then
        movable shouldBe true
    }
})
