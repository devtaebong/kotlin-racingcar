package calculator.domain

import calculator.domain.Operator.Companion.getOperator

class Calculator {
    fun run(input: String?): String {
        val expression = ParsedExpression(input)
        while (expression.isCanCalculate()) {
            val operand1 = Operand(expression.pollElement())
            val operator = getOperator(expression.pollElement())
            val operand2 = Operand(expression.pollElement())
            expression.putElement(calculate(operand1, operand2, operator))
        }

        return expression.pollElement()
    }

    private fun calculate(
        operand1: Operand,
        operand2: Operand,
        operator: Operator,
    ) = operator.operate(operand1, operand2).toString()
}
