package calculator

import calculator.Operator.Companion.isOperator

class InputValidator {
    fun validate(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("The input cannot be null or blank")
        }

        val tokens = input.trimIndent().split(" ")
        if (tokens.size % 2 == 0) {
            throw IllegalArgumentException("There is an invalid input")
        }
        tokens.forEachIndexed { index, arg ->
            if (index % 2 == 0 && !arg.isDouble()) {
                throw IllegalArgumentException("There is an invalid input")
            }
            if (index % 2 == 1 && !arg.isOperator()) {
                throw IllegalArgumentException("There is an invalid input")
            }
        }
    }

    private fun String.isDouble(): Boolean = this.toDoubleOrNull() != null
}
