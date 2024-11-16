package calculator

import calculator.domain.Calculator

fun main() {
    println("식을 입력해주세요")
    val expression = readLine()

    println("결과: ${Calculator().run(expression)}")
}
