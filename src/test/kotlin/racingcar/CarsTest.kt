package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Cars

class CarsTest {

    @Test
    fun `position이 가장 큰 차들이 winner로 선정된다`() {
        // given
        val cars = Cars(
            listOf(
                Car("a", 1),
                Car("b", 2),
                Car("c", 3),
                Car("d", 2),
                Car("e", 3),
            ),
        )

        // when
        val winners = cars.getWinners()

        // then
        assertThat(winners).size().isEqualTo(2)
        assertThat(winners).contains("c", "e")
    }
}
