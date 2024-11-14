package calculator

class Calculator {
    fun calculate(expression: String): Double {
        val expressions = Expressions(expression)
        return expressions.calculate()
    }
}
