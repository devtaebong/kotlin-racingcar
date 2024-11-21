package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import racingcar.domain.history.CarHistory

class GameWinnerSelectorTest : StringSpec({

    "우승자는 위치 값이 가장 큰 자동차(들)이다." {
        val histories =
            listOf(
                CarHistory("a", 1),
                CarHistory("b", 2),
                CarHistory("c", 2),
                CarHistory("d", 0),
            )

        val actualResults = GameWinnerSelector.decideWinners(histories)
        val expectedResults = listOf("b", "c")

        actualResults.forEach { it shouldBeIn expectedResults }
    }
})
