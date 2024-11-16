package calculator.domain

import java.lang.IllegalArgumentException

enum class Operator(val value: String, val operate: (Operand, Operand) -> Double) {
    PLUS("+", { a, b -> a.value + b.value }),
    MINUS("-", { a, b -> a.value - b.value }),
    MULTIPLY("*", { a, b -> a.value * b.value }),
    DIVIDE("/", { a, b -> a.value / b.value }), ;

    companion object {
        fun getOperator(input: String): Operator {
            return values().firstOrNull { it.value == input } ?: throw IllegalArgumentException("지원하지 않는 연산자 입니다. operator=$input")
        }
    }
}
