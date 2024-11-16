package calculator

import calculator.Number.Companion.ZERO
import java.util.function.BiFunction

enum class Operator(
    private val symbol: String,
    private val operation: BiFunction<Double, Double, Double>,
) {
    ADD(
        "+",
        BiFunction { left, right -> left + right },
    ),
    SUBTRACT(
        "-",
        BiFunction { left, right -> left - right },
    ),
    MULTIPLY(
        "*",
        BiFunction { left, right -> left * right },
    ),
    DIVIDE(
        "/",
        BiFunction { left, right ->
            if (right == ZERO) {
                throw IllegalArgumentException("0으로 나눌 수 없습니다")
            }
            left / right
        },
    ),
    ;

    fun apply(
        left: Double,
        right: Double,
    ): Double {
        return operation.apply(left, right)
    }

    companion object {
        fun getSymbol(symbol: String): Operator {
            return entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("유효하지 않은 연산자입니다. operator = $symbol")
        }
    }
}
