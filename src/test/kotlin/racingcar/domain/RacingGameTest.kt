package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.car.Cars
import racingcar.util.FakeRandomGenerator

class RacingGameTest : StringSpec({

    "경주게임은 참가한 게임이 끝날 때 까지 자동차들을 전진에 대한 조작을 할 수 있다." {
        val cars = Cars.createCars("a,b,c")
        val racingGame = RacingGame(cars, GameRound("2"), FakeRandomGenerator(mutableListOf(1, 2, 4, 4, 4, 4)))

        racingGame.play()

        racingGame.isEnd() shouldBe true
    }

    "경주게임은 게임 진행 후 결과를 반환한다." {
        val cars = Cars.createCars("a,b,c")
        val racingGame = RacingGame(cars, GameRound("1"), FakeRandomGenerator(mutableListOf(4, 4, 4)))
        val gameResult = racingGame.play()

        gameResult.forEachIndexed { index, carHistory -> carHistory.nameValue shouldBe cars.getCars()[index].getNameValue() }
    }
})
