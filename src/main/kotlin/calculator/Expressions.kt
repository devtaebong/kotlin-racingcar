package calculator

class Expressions(
    private val tokens: List<String>,
) {
    fun calculate(): Double {
        var currentOperator: Operator? = null // TODO: null을 사용하지 않도록 수정
        var result = Number.ZERO

        tokens.forEach { token ->
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
