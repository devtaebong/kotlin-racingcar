package calculator

import calculator.operator.Addition
import calculator.operator.Division
import calculator.operator.Multiplication
import calculator.operator.Operator
import calculator.operator.Subtraction

object OperatorFactory {
    private val operators = listOf(Addition(), Subtraction(), Multiplication(), Division())

    fun from(symbol: String): Operator {
        return operators.find { it.symbol == symbol }
            ?: throw IllegalArgumentException("Invalid operator: $symbol")
    }
}
