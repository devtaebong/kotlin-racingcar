package calculator.operator

class Addition : Operator {
    override val symbol = "+"

    override fun apply(
        leftOperand: Int,
        rightOperand: Int,
    ): Int = leftOperand + rightOperand
}
