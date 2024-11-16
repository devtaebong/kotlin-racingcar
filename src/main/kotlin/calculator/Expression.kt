package calculator

import calculator.Number.Companion.ZERO

object Expression {
    private const val WHITE_SPACE = " "

    fun calculate(expression: String): Double {
        val expressions = expression.split(WHITE_SPACE)
        var currentOperator: Operator? = null
        var result = ZERO

        expressions.forEach { token ->
            val value = token.toDoubleOrNull()

            if (value == null) {
                currentOperator = Operator.getSymbol(token)
                return@forEach
            }
            if (currentOperator == null) {
                result = value
                return@forEach
            }
            result = checkNotNull(currentOperator) { "연산자가 설정되지 않았습니다. operator = $token" }.apply(result, value)
        }
        return result
    }
}
