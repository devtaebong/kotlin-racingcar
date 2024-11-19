package stringcalculator

enum class Operator(val sequence: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"), ;

    companion object {
        fun fromSequence(sequence: String): Operator {
            return entries.find { it.sequence == sequence }
                ?: throw IllegalArgumentException("지원하지 않는 연산자 입니다. $sequence")
        }
    }
}
