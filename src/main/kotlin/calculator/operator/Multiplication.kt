package calculator.operator

class Multiplication : Operator {
    override val symbol = "*"

    override fun apply(
        leftOperand: Int,
        rightOperand: Int,
    ): Int = leftOperand * rightOperand
}
