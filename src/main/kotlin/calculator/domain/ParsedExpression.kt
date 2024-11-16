package calculator.domain

import java.util.LinkedList

class ParsedExpression(input: String?) {
    private val elements: LinkedList<String>

    init {
        elements = InputParser.parse(input)
        require(isCanCalculate())
    }

    fun isCanCalculate() = elements.size >= MIN_SIZE && elements.size % 2 == 1

    fun pollElement(): String = elements.poll()

    fun putElement(value: String) {
        elements.push(value)
    }

    companion object {
        const val MIN_SIZE = 3
    }
}
