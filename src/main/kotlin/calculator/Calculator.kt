package calculator

class Calculator {
    fun calculate(expression: String): Double {
        validateExpression(expression)

        return Expression.calculate(expression)
    }
}
