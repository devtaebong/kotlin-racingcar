package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.movestrategy.FixMoveStrategy

class CarTest {

    @Test
    fun `random 값이 4이상이면 전진한다`() {
        val car = Car(
            name = "a",
            moveStrategy = FixMoveStrategy(4),
        )
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `random 값이 3이하이면 전진하지 않는다`() {
        val car = Car(
            name = "a",
            moveStrategy = FixMoveStrategy(3),
        )
        car.move()
        assertThat(car.position).isEqualTo(0)
    }
}
