package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorKtTest {

    @Test
    fun `문자열을 계산한다`() {
        val calculate = Calculator.calculate("2 + 3 * 4 - 10 / 2")

        assertThat(calculate).isEqualTo(5.0)
    }

    @Test
    fun `4개의 연산자를 통해 문자열을 계산한다`() {
        val calculate = Calculator.calculate("2 + 3 * 4 / 2")

        assertThat(calculate).isEqualTo(10.0)
    }

    @Test
    fun `없는 연산자가 들어오면 예외를 발생한다`() {
        assertThatThrownBy { Calculator.calculate("2 + 3 * 4 & 5 / 2") }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessage("Invalid operator: &")
    }

    @Test
    fun `입력 값이 비어있으면 에외를 발생한다`() {
        assertThatThrownBy { Calculator.calculate(" ") }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessage("input values cannot be null or empty.")
    }

    @Test
    fun `0으로 나누는 경우 에외를 발생한다`() {
        assertThatThrownBy { Calculator.calculate("1 + 3 / 0") }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessage("cannot divide by zero.")
    }

    @Test
    fun `홀수 번 째 숫자가 아니면 예외가 발생한다 `() {
        assertThatThrownBy { Calculator.calculate("1 + & 3 / 0") }
            .isInstanceOf(NumberFormatException::class.java)
    }

}
