package calculator.operator

class Subtraction : Operator {
    override val symbol = "-"

    override fun apply(
        leftOperand: Int,
        rightOperand: Int,
    ): Int = leftOperand - rightOperand
}
