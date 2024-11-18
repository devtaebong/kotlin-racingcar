package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain

class CarsTest : StringSpec({

    "Cars는 유효한 이름을 가진 자동차들을 갖고 있다." {
        val cars = Cars.createCars("a,b,c")
        val names = cars.getCars().map { it.name.value }
        names shouldContain "a"
        names shouldContain "b"
        names shouldContain "c"
    }
})
