package step1.domain

import step1.domain.Operator.Companion.getOperator

class Calculator() {
    fun run(input: String?): String {
        val expression = ParsedExpression(input)
        while (expression.isCanCalculate()) {
            val operand1 = Operand(expression.getElement())
            val operator = getOperator(expression.getElement())
            val operand2 = Operand(expression.getElement())
            expression.putElement(calculate(operand1, operand2, operator))
        }

        return expression.getElement()
    }

    private fun calculate(
        operand1: Operand,
        operand2: Operand,
        operator: Operator,
    ): String {
        return when (operator) {
            Operator.PLUS -> operand1.value + operand2.value
            Operator.MINUS -> operand1.value - operand2.value
            Operator.MULTIPLY -> operand1.value * operand2.value
            Operator.DIVIDE -> operand1.value / operand2.value
        }.toString()
    }
}
