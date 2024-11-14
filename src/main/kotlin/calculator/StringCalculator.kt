package calculator

class StringCalculator {
    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { "Input cannot be null or blank" }

        val tokens = input.split(" ")
        var result = tokens[0].toIntOrNull() ?: throw IllegalArgumentException("Input must be a digit")

        var index = 1
        while (index < tokens.size) {
            val operator = Operator.from(tokens[index])
            val nextValue =
                tokens.getOrNull(index + 1)
                    ?.toIntOrNull()
                    ?: throw IllegalArgumentException("Invalid value after operator")
            result = operator.apply(result, nextValue)
            index += 2
        }
        return result
    }
}
