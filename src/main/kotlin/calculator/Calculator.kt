package calculator

object Calculator {
    fun calculate(
        a: Double,
        b: Double,
        operator: Operator,
    ): Double = operator.operate(a, b)
}
