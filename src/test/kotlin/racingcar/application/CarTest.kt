package racingcar.application

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "Car 최소 생성시 step 은 0이다" {
        Car.createDefault(name = "car1").position shouldBe 0
    }

    "전진 조건의 값이 4이상일 경우 1만큼 전진한다" {
        val sut = Car.createDefault(name = "car2")
        sut.moveForward()
        sut.position shouldBe 1
    }

    "자동차 이름이 5자 초과시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Car.createDefault("aaa_aaa")
        }
    }
})
