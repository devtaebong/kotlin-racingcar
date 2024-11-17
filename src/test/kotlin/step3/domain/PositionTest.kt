package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `위치이동 시 4보다 이상 인 경우 이동한다`(number: Int) {
        val position = Position.init()

        val movedPosition = position.move(number)

        assertThat(movedPosition).isEqualTo(Position(1))
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `위치이동 시 4보다 미만 인 경우 이동한다`(number: Int) {
        val position = Position.init()

        val movedPosition = position.move(number)

        assertThat(movedPosition).isEqualTo(Position(0))
    }

    @Test
    fun `위치이동 시 0보다 작은 경우 에러가 발생한다`() {
        val position = Position.init()

        assertThatThrownBy { position.move(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Only numbers between 0 and 9 can be entered.")
    }

    @Test
    fun `위치이동 시 9보다 큰 경우 에러가 발생한다`() {
        val position = Position.init()

        assertThatThrownBy { position.move(10) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Only numbers between 0 and 9 can be entered.")
    }
}
