package step2

enum class Operator(val symbol: String, val operation: (Double, Double) -> Double) {
    ADD("+", Double::plus),
    SUBTRACT("-", Double::minus),
    MULTIPLY("*", Double::times),
    DIVIDE(
        "/",
        { a, b ->
            b.takeIf { it != 0.0 }?.let { a / it }
                ?: throw IllegalArgumentException("0으로 나눌 수 없습니다")
        },
    ),
}
