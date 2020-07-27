package step3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class RacingFieldTest {
    @Test
    fun `시도횟수가 0미만인 경우 Exception`() {
        // given
        val cars = Cars(listOf(Car(CarMover())))
        val racingField = RacingField(cars)

        // then
        assertThatThrownBy { racingField.startRace(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("시도 횟수는 0이상이어야 합니다. 입력 값 : -1")
    }

    @Test
    fun `무조건 전진하는 자동차경주시 그 결과가 제대로 나오는지 확인`() {
        // given
        val car = Car(object : Mover {
            override fun canMove(): Boolean {
                return true
            }
        })
        val cars = Cars(listOf(car))
        val racingField = RacingField(cars)
        val expectedRacingResult = RacingResult(listOf(5))

        // when
        val racingResult = racingField.startRace(5)

        // then
        assertThat(racingResult.last()).isEqualTo(expectedRacingResult)
    }
}