package racingcar.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "Car 최소 생성시 step 은 0이다" {
        Car.createDefault().step shouldBe 0
    }

    "전진 조건의 값이 4이상일 경우 1만큼 전진한다" {
        val sut = Car.createDefault()
        sut.moveForward(4)
        sut.step shouldBe 1
    }
})
