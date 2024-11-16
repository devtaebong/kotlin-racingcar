package calculator

fun validateExpression(expression: String) {
    if (expression.isBlank()) {
        throw IllegalArgumentException("식이 널이거나, 비어있거나, 공백 문자이면 안 됩니다.")
    }
}
