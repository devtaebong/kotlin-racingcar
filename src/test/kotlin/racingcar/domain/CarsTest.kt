package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import racingcar.domain.car.Cars
import racingcar.util.FakeRandomGenerator

class CarsTest : StringSpec({
    val cars = Cars.createCars("a,b,c")

    "Cars는 유효한 이름을 가진 자동차들을 갖고 있다." {
        val names = cars.getCars().map { it.getNameValue() }
        names shouldContain "a"
        names shouldContain "b"
        names shouldContain "c"
    }

    "Cars는 자동차를 이동시킬 수 있다." {
        cars.tryMove(FakeRandomGenerator(mutableListOf(4, 4, 4)))
        cars.getCars().forEach { it.getLocationValue() shouldBe 1 }
    }
})
