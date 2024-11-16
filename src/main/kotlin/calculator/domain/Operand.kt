package calculator.domain

class Operand(input: String?) {
    val value: Double

    init {
        requireNotNull(input) { "입력값은 null일 수 없습니다." }
        require(isNumeric(input)) { "입력값은 유효한 숫자여야 합니다." }
        value = input.toDouble()
    }

    private fun isNumeric(value: String): Boolean {
        return value.toDoubleOrNull() != null
    }
}
