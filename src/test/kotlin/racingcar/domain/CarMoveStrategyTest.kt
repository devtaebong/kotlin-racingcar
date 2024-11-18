package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.util.FakeRandomGenerator

class CarMoveStrategyTest : StringSpec({

    "자동차가 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다." {
        CarMoveStrategy(FakeRandomGenerator(mutableListOf(4, 5, 6, 7, 8, 9))).canMove() shouldBe true
    }
})
