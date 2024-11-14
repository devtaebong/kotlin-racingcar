package step1.domain

import java.lang.IllegalArgumentException

enum class Operator(private val operator: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"), ;

    companion object {
        fun getOperator(input: String): Operator {
            return values().firstOrNull { it.operator == input } ?: throw IllegalArgumentException("지원하지 않는 연산자 입니다. operator=$input")
        }
    }
}
