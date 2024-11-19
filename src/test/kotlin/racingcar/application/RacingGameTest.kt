package racingcar.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.application.Car.Companion.createDefault

class RacingGameTest : StringSpec({
    "canMove가 true일 경우 차들은 전진한다" {
        val decider = CarMovementDecider { true }
        val cars = listOf(createDefault("car1"), createDefault("car2"))
        val racingGame = RacingGame(decider, cars, RaceBoard())
        racingGame.race(3)
        cars.forAll {
            it.position shouldBe 3
        }
    }

    "canMove가 false 경우 차들은 전진하지 않는다" {
        val decider = CarMovementDecider { false }
        val cars = listOf(createDefault("car1"), createDefault("car2"))
        val racingGame = RacingGame(decider, cars, RaceBoard())
        racingGame.race(3)
        cars.forAll {
            it.position shouldBe 0
        }
    }
})
