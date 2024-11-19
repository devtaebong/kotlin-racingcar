package calculator.operator

interface Operator {
    val symbol: String

    fun apply(
        leftOperand: Int,
        rightOperand: Int,
    ): Int
}
