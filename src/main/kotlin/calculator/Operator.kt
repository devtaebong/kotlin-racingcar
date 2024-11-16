package calculator

enum class Operator(
    val symbol: String,
) {
    ADD("+") {
        override fun operate(
            a: Double,
            b: Double,
        ): Double = a + b
    },
    SUBTRACT("-") {
        override fun operate(
            a: Double,
            b: Double,
        ): Double = a - b
    },
    MULTIPLY("*") {
        override fun operate(
            a: Double,
            b: Double,
        ): Double = a * b
    },
    DIVIDE("/") {
        override fun operate(
            a: Double,
            b: Double,
        ): Double {
            if (b == 0.0) {
                throw IllegalArgumentException("Division by zero is not allowed")
            }
            return a / b
        }
    },
    ;

    abstract fun operate(
        a: Double,
        b: Double,
    ): Double

    companion object {
        fun fromToken(token: String): Operator =
            entries.find { it.symbol == token } ?: throw IllegalArgumentException("Not found operator from $token")

        fun String.isOperator(): Boolean = entries.map { it.symbol }.contains(this)
    }
}
