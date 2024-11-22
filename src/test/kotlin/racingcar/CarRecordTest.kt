package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class CarRecordTest {
    @Test
    fun `자동차 기록은 자동차의 이름과 이동수를 기록한다`() {
        val car1 = Car("car1", 5)
        val car2 = Car("car2", 3)

        assertThat(car1.name).isEqualTo("car1")
        assertThat(car1.moveCount).isEqualTo(5)
        assertThat(car2.name).isEqualTo("car2")
        assertThat(car2.moveCount).isEqualTo(3)
    }
}
