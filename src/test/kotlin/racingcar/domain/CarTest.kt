package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    test("car는 유효한 이름과, 위치 기본 초기 값이 포함되어 있다") {
        val name = "car1"
        val car = Car(name)

        car.name.value shouldBe name
        car.location.value shouldBe 0
    }

    test("move()는 차의 위치를 1칸 이동시킨다") {
        val car = Car("car1")
        car.move()
        car.location.value shouldBe 1
    }
})
