package step2

private const val SPLIT_DELIMITER = " "

object Calculator {
    fun calculate(expression: String?): Double {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("input values cannot be null or empty.")
        }

        val expressions = expression.split(SPLIT_DELIMITER)

        return calculate(expressions)
    }

    private fun calculate(expressions: List<String>): Double {
        if (expressions.isEmpty()) {
            throw IllegalArgumentException("Expression cannot be empty.")
        }

        var result = expressions[0].toDouble()

        for (i in 1 until expressions.size step 2) {
            val operator = Operator.from(expressions[i])
            val toDouble = expressions[i + 1].toDouble()

            result = operator.apply(result, toDouble)
        }

        return result
    }
}


enum class Operator(val operator: String, val apply: (Double, Double) -> Double) {
    ADDITION("+", { a, b -> a + b }),
    SUBTRACTION("-", { a, b -> a - b }),
    MULTIPLICATION("*", { a, b -> a * b }),
    DIVISION("/", { a, b ->
        if (b == 0.0) {
            throw IllegalArgumentException("cannot divide by zero.")
        }
        a / b
    });

    companion object {
        fun from(operator: String): Operator {
            return entries.find { it.operator == operator }
                ?: throw IllegalArgumentException("Invalid operator: $operator")
        }
    }
}
