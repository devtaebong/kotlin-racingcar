package calculator

object StringCalculator {
    fun calculate(input: InputValue): Int {
        return input.operators.foldIndexed(input.firstOperand) { index, result, operator ->
            operator.apply(result, input.operands[index + 1])
        }
    }
}
