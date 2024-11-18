package calculator.domain

class Operand(input: String) {
    val value: Double

    init {
        require(isNumeric(input)) { "입력값은 유효한 숫자여야 합니다." }
        value = input.toDouble()
    }

    private fun isNumeric(value: String): Boolean {
        return value.toDoubleOrNull() != null
    }
}
