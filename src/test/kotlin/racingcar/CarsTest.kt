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
                Car(name = "a", position = 1),
                Car(name = "b", position = 2),
                Car(name = "c", position = 3),
                Car(name = "d", position = 2),
                Car(name = "e", position = 3),
            ),
        )

        // when
        val winners = cars.getWinners()

        // then
        assertThat(winners).size().isEqualTo(2)
        assertThat(winners).contains("c", "e")
    }
}
