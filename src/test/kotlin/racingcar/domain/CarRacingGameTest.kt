package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import racingcar.CarRacingGame
import racingcar.strategy.RandomMoveStrategy

class CarRacingGameTest : StringSpec({
    "자동차들이 n번의 라운드 동안 이동한다" {
        val game = CarRacingGame(carCount = 3, rounds = 5)

        val raceResult = game.play(RandomMoveStrategy())

        raceResult.size shouldBe 5
        raceResult.forEach { round ->
            round.getPositions().size shouldBe 3
        }
    }

    "자동차의 위치가 라운드 수를 초과하지 않는다" {
        val game = CarRacingGame(carCount = 3, rounds = 5)

        val raceResult = game.play(RandomMoveStrategy())

        raceResult.forEachIndexed { _, round ->
            round.getPositions().forEach { position ->
                position shouldBeGreaterThanOrEqual 0
                position shouldBeLessThanOrEqual 5
            }
        }
    }
})
