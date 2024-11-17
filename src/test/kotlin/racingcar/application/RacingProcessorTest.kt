package racingcar.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.mock.MockRandomGenerator

class RacingProcessorTest : StringSpec({
    "random 값이 4 이상일 경우 차들은 전진한다" {
        val fixedValue = 4
        val mockRandomGenerator = MockRandomGenerator(fixedValue)
        val racingProcessor = RacingProcessor(mockRandomGenerator)
        val cars = listOf(Car.createDefault(), Car.createDefault())
        racingProcessor.race(cars = cars)
        cars.forAll {
            it.step shouldBe 1
        }
    }

    "random 값이 4 미만일 경우 차들은 전진하지 않는다" {
        val fixedValue = 3
        val mockRandomGenerator = MockRandomGenerator(fixedValue)
        val racingProcessor = RacingProcessor(mockRandomGenerator)
        val cars = listOf(Car.createDefault(), Car.createDefault())
        racingProcessor.race(cars = cars)
        cars.forAll {
            it.step shouldBe 0
        }
    }
})
