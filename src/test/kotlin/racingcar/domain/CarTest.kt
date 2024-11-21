package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.car.Car
import racingcar.domain.car.CarLocation
import racingcar.domain.car.CarName

class CarTest : FunSpec({

    val name = CarName("car1")
    val location = CarLocation()
    val car = Car(name, location)

    test("car는 유효한 이름과, 위치 기본 초기 값이 포함되어 있다") {
        car.getNameValue() shouldBe name.value
        car.getLocationValue() shouldBe CarLocation.DEFAULT_VALUE
    }

    test("move()는 차의 위치를 1칸 이동시킨다") {
        car.move()
        car.getLocationValue() shouldBe 1
    }
})
