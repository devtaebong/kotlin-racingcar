package stringcalculator

private const val START_INDEX = 0
private const val FIRST_OPERATOR_INDEX = 1

class StringCalculator {
    private val allowedOperators = setOf(Operator.PLUS, Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE)
    private val regex: Regex = buildRegexForOperators()

    private fun buildRegexForOperators(): Regex {
        val operators = allowedOperators.joinToString(prefix = "\\", separator = "\\") { operator -> operator.sequence }
        return "^\\s*\\d+\\s[$operators]\\s\\d+(\\s[$operators]\\s\\d+)*\\s*$".toRegex()
    }

    fun calculate(input: String?): Int {
        return input?.let {
            validateFormat(input)
            val strings = convertToList(input)

            var leftNumber = strings[START_INDEX].toInt()
            var result = 0
            for (idx in FIRST_OPERATOR_INDEX until strings.size step 2) {
                val operator = strings[idx]
                val rightNumber = strings[idx + 1].toInt()

                result = NumberCalculator.calculate(leftNumber, Operator.fromSequence(operator), rightNumber)
                leftNumber = result
            }
            return result
        } ?: throw IllegalArgumentException("입력 값은 null일 수 없습니다.")
    }

    private fun convertToList(input: String): List<String> {
        return input.trim().split(" ")
    }

    private fun validateFormat(input: String) {
        if (regex.matches(input).not()) {
            throw IllegalArgumentException(
                """
                입력 형태 또는 사용된 연산자가 잘못되었습니다.
                - 현재 입력 : $input
                - 사용 가능한 연산자 : $allowedOperators
                - 숫자와 연산자 사이에 공백이 반드시 하나 있어야 합니다 
                - 입력 예: 2 + 3 * 4 / 2
                """.trimIndent(),
            )
        }
    }
}
