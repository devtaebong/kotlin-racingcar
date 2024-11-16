package calculator

import calculator.Calculator.calculate

class StringCalculator {
    fun calculate(input: String): String {
        val parseResult = InputParser(InputValidator()).parse(input)
        val numbers = parseResult.numbers
        val operators = parseResult.operators

        var result = numbers[0]
        for (i in operators.indices) {
            val nextNumber = numbers[i + 1]
            val operator = operators[i]
            result = calculate(result, nextNumber, operator)
        }
        return if (result.isInteger()) result.toInt().toString() else result.toString()
    }

    private fun Double.isInteger(): Boolean = this % 1.0 == 0.0
}
