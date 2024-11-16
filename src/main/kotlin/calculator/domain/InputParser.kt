package calculator.domain

import java.util.LinkedList

object InputParser {
    fun parse(input: String?): LinkedList<String> {
        requireNotNull(input) { "수식은 null일 수 없습니다." }
        require(input.isNotBlank()) { "수식은 빈 문자열일 수 없습니다." }

        return LinkedList(input.split(" ").toMutableList())
    }
}
