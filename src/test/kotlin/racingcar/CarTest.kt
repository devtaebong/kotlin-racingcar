package racingcar

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.NumberGenerator

class CarTest {
    @Test
    fun `car 생성 테스트`() {
        val car = Car(initialMove = 5, name = "car12")
        car.name shouldBe "car12"
        car.moveCount shouldBe 5
    }

    @Test
    fun moveTest() {
        val numberGenerator =
            object : NumberGenerator {
                override fun getNumber(): Int {
                    return 5
                }
            }
        val car = Car("car1", 0, numberGenerator)
        car.move()
        assertThat(car.moveCount).isEqualTo(1)
    }

    @Test
    fun moveThreeTimesTest() {
        val numberGenerator =
            object : NumberGenerator {
                override fun getNumber(): Int {
                    return 5
                }
            }
        val car = Car(name = "car1", numberGenerator = numberGenerator)
        car.move()
        car.move()
        car.move()
        assertThat(car.moveCount).isEqualTo(3)
    }

    @Test
    fun notMoveTest() {
        val numberGenerator =
            object : NumberGenerator {
                override fun getNumber(): Int {
                    return 2
                }
            }
        val car = Car(name = "car1", numberGenerator = numberGenerator)
        car.move()
        assertThat(car.moveCount).isEqualTo(0)
    }

    @Test
    fun notMoveThreeTimesTest() {
        val numberGenerator =
            object : NumberGenerator {
                override fun getNumber(): Int {
                    return 2
                }
            }
        val car = Car(name = "car1", numberGenerator = numberGenerator)
        car.move()
        car.move()
        car.move()
        assertThat(car.moveCount).isEqualTo(0)
    }

    @Test
    fun `자동차 이름 부여 테스트`() {
        val car = Car(name = "자동차1")
        assertThat(car.moveCount).isEqualTo(0)
        assertThat(car.name).isEqualTo("자동차1")
    }

    @Test
    fun `5글자 이상의 자동차 이름 부여`() {
        assertThatThrownBy { Car(name = "5글자가넘어요") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름이 너무 길어요")
    }
}
