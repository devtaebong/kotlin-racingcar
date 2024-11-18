package calculator

class StringCalculator {
    fun calculate(expression: String): Double {
        return Expression(expression).calculate()
    }
}
