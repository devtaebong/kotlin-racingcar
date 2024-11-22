package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.NumberGenerator
import racingcar.domain.Race
import racingcar.domain.RaceGame
import racingcar.domain.RaceResult

class RaceGameTest {
    private val numberGenerator =
        object : NumberGenerator {
            var flag = 1

            override fun getNumber(): Int {
                val result = (flag + 9) % 10
                flag++
                flag %= 2
                return result
            }
        }

    @Test
    fun `우승자 테스트`() {
        val race = Race.Companion.of(listOf("car1", "car2", "car3"), numberGenerator)
        val raceGame = RaceGame(race, RaceResult(listOf()))
        raceGame.doRaceGame(3)
        assertThat(raceGame.raceResult.getWinner().map { it.name }).containsExactly("car2")
    }
}
