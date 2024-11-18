package calculator

class Expression(
    private val value: String,
) {
    init {
        require(value.isNotBlank()) { "식이 널이거나, 비어있거나, 공백 문자이면 안 됩니다." }
    }

    fun calculate(): Double {
        val expressions = Expressions(value.split(TOKEN_DELIMITER))
        return expressions.calculate()
    }

    companion object {
        private const val TOKEN_DELIMITER = " "
    }
}
