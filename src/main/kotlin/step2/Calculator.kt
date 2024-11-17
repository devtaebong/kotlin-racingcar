package step2

class Calculator {
    operator fun invoke(expression: String): CalculationState =
        runCatching {
            expression.split(" ")
                .validateTokens()
                .calculateResult()
                .let { CalculationState.Success(CalculationResult(it)) }
        }.getOrElse { CalculationState.Error(it.message ?: "알 수 없는 오류가 발생했습니다") }

    private fun List<String>.validateTokens(): List<String> {
        require(size >= 3 && size % 2 == 1) { "올바르지 않은 수식 형식입니다" }
        return this
    }

    private fun List<String>.calculateResult(): Double {
        val initialValue = first().parseNumber()
        return this.drop(1)
            .chunked(2)
            .fold(initialValue) { acc, (op, num) ->
                val operator = op.parseOperator()
                val number = num.parseNumber()
                operator.operation(acc, number)
            }
    }

    private fun String.parseNumber(): Double = toDoubleOrNull() ?: throw IllegalArgumentException("숫자 형식이 잘못되었습니다")

    private fun String.parseOperator(): Operator =
        Operator.entries.find { it.symbol == this }
            ?: throw IllegalArgumentException("잘못된 연산자입니다: $this")
}
