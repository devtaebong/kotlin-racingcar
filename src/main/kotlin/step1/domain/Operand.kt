package step1.domain

class Operand(input: String?) {
    private val _value: Double

    val value: Double
        get() = _value

    init {
        requireNotNull(input) { "입력값은 null일 수 없습니다." }
        require(isNumeric(input)) { "입력값은 유효한 숫자여야 합니다." }
        _value = input.toDouble()
    }

    private fun isNumeric(value: String): Boolean {
        return value.toDoubleOrNull() != null
    }
}
