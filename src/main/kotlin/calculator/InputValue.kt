package calculator

import calculator.operator.Operator

class InputValue(val operands: List<Int>, val operators: List<Operator>) {
    val firstOperand: Int = operands[0]

    companion object {
        private const val SPACE = " "

        fun from(input: String?): InputValue {
            require(!input.isNullOrBlank()) { "Input cannot be null or blank" }

            val tokens = input.split(SPACE)
            val operands = getOperands(tokens)
            val operators = getOperators(tokens)

            return InputValue(operands, operators)
        }

        private fun getOperands(tokens: List<String>): List<Int> =
            tokens.filterIndexed { index, _ -> index % 2 == 0 }
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("Invalid number: $it") }

        private fun getOperators(tokens: List<String>): List<Operator> =
            tokens.filterIndexed { index, _ -> index % 2 != 0 }
                .map { OperatorFactory.from(it) }
    }
}
