package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import racingcar.util.FakeRandomGenerator
import racingcar.view.RacingGameInput

class RacingGameTest : StringSpec({

    "경주게임은 참가한 게임이 끝날 때 까지 자동차들을 전진에 대한 조작을 할 수 있다." {
        val carNames = "a,b,c"
        val playCount = "2"
        val racingGame = RacingGame(RacingGameInput(carNames, playCount), FakeRandomGenerator(mutableListOf(1, 2, 4, 4, 4, 4)))

        repeat(playCount.toInt()) {
            racingGame.play()
        }

        racingGame.isEnd() shouldBe true
    }

    "경주게임은 자동차 정보를 조회할 수 있다." {
        val carNames = "a,b,c"
        val playCount = "2"
        val racingGame = RacingGame(RacingGameInput(carNames, playCount), FakeRandomGenerator(mutableListOf(1, 2, 4, 4, 4, 4)))
        val expectedResults = listOf(Pair("a", 1), Pair("b", 1), Pair("c", 2))

        repeat(playCount.toInt()) {
            racingGame.play()
        }

        val carsInfo = racingGame.getCarsInfo()

        carsInfo.forEachIndexed { index, pair ->
            val expectedResult = expectedResults[index]
            pair.first shouldBe expectedResult.first
            pair.second shouldBe expectedResult.second
        }
    }

    "경주게임은 우승자 정보를 조회할 수 있다." {
        val carNames = "a,b,c"
        val playCount = "2"
        val racingGame = RacingGame(RacingGameInput(carNames, playCount), FakeRandomGenerator(mutableListOf(1, 2, 4, 4, 4, 4)))
        val expectedResults = listOf("c")

        repeat(playCount.toInt()) {
            racingGame.play()
        }

        val winners = racingGame.getWinnerInfo()

        winners.forEach { it shouldBeIn expectedResults }
    }
})
