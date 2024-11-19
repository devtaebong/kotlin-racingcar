package calculator.operator

class Division : Operator {
    override val symbol = "/"

    override fun apply(
        leftOperand: Int,
        rightOperand: Int,
    ): Int {
        require(rightOperand != 0) { "Cannot divide by zero" }
        return leftOperand / rightOperand
    }
}
