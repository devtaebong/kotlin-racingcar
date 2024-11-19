package stringcalculator

object NumberCalculator {
    fun sum(
        left: Int,
        right: Int,
    ): Int = left + right

    fun subtract(
        left: Int,
        right: Int,
    ): Int = left - right

    fun multiply(
        left: Int,
        right: Int,
    ): Int = left * right

    fun divide(
        left: Int,
        right: Int,
    ): Int {
        validateZero(right)
        return left / right
    }

    private fun validateZero(right: Int) {
        if (right == 0) {
            throw IllegalArgumentException("나누는 숫자(right)는 0일 수 없습니다.")
        }
    }

    fun calculate(
        leftNumber: Int,
        operator: Operator,
        rightNumber: Int,
    ): Int {
        return when (operator) {
            Operator.PLUS -> sum(leftNumber, rightNumber)
            Operator.MINUS -> subtract(leftNumber, rightNumber)
            Operator.MULTIPLY -> multiply(leftNumber, rightNumber)
            Operator.DIVIDE -> divide(leftNumber, rightNumber)
        }
    }
}
