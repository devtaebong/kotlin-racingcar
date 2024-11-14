package calculator

enum class Operator(val symbol: String) {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    fun apply(
        a: Int,
        b: Int,
    ): Int =
        when (this) {
            ADD -> a + b
            SUBTRACT -> a - b
            MULTIPLY -> a * b
            DIVIDE -> {
                require(b != 0) { "Cannot divide by zero" }
                a / b
            }
        }

    companion object {
        fun from(symbol: String): Operator {
            return entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Invalid operator: $symbol")
        }
    }
}
