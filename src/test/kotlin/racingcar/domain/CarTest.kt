package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    test("move()는 차의 위치를 1칸 이동시킨다") {
        val car = Car()
        car.move()
        car.location shouldBe 1
    }
})
