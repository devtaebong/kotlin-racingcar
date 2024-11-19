package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({
    "차들이 전진한다" {
        val cars = Cars(listOf(Car(), Car(), Car()))

        val movedCars = cars.move { true }

        movedCars.getPositions() shouldBe listOf(1, 1, 1)
    }

    "차들이 전진하지 않는다" {
        val cars = Cars(listOf(Car(), Car(), Car()))

        val movedCars = cars.move { false }

        movedCars.getPositions() shouldBe listOf(0, 0, 0)
    }
})
