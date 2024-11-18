package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({

    "RacingGame은 자동차 경주 게임을 진행한다" {
        // given
        val carNames = "pobi,crong,honux"
        val racingGame = RacingGame(carNames, Round(5), StubNumberGenerator())

        // when
        val playedCars = racingGame.play()

        // then - assert가 어떤게 되어야 올바른 테스트 시나리오인지
        // 이 테스트 케이스는 두 개의 기능을 검사하기 때문에 좋은 테스트가 아니라고 생각됩니다.
        playedCars.getWinners().size shouldBe 3
    }
})
