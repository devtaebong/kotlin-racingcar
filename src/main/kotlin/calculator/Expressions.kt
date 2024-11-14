package calculator

class Expressions(expression: String) {
    private val zero: Double = 0.0

    private val expressions: List<String> = expression.split(" ")

    init {
        require(expression.isNotBlank()) { "식이 올바르지 않습니다." }
    }

    fun calculate(): Double {
        // FIXME: 조금 더 나이스하게 풀어낼 방법은 없나?
        var currentOperator: Operator? = null
        var result = zero

        expressions.forEach { token ->
            val value = token.toDoubleOrNull()

            if (value == null) {
                currentOperator = getOperator(token)
                return@forEach
            }
            if (currentOperator == null) {
                result = value
                return@forEach
            }
            result = currentOperator!!.apply(result, value)
        }
        return result
    }

    private fun getOperator(operator: String): Operator {
        return when (operator) {
            "+" -> Operator.ADD
            "-" -> Operator.SUBTRACT
            "*" -> Operator.MULTIPLY
            "/" -> Operator.DIVIDE
            else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
