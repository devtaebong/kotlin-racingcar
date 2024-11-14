package calculator

import java.util.function.BiFunction

enum class Operator(private val operation: BiFunction<Double, Double, Double>) {
    ADD(
        BiFunction { left, right -> left + right },
    ),
    SUBTRACT(
        BiFunction { left, right -> left - right },
    ),
    MULTIPLY(
        BiFunction { left, right -> left * right },
    ),
    DIVIDE(
        BiFunction { left, right ->
            if (right == 0.0) {
                throw IllegalArgumentException("0으로 나눌 수 없습니다")
            } else {
                left / right
            }
        },
    ), ;

    fun apply(
        left: Double,
        right: Double,
    ): Double {
        return operation.apply(left, right)
    }
}
