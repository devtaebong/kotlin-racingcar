package racingcar.domain

class CarName(input: String) {
    val value: String

    init {
        require(input.isNotBlank()) { "이름은 빈 값일 수 없습니다." }
        require(input.length <= 5) { "이름은 5자를 초과할 수 없습니다. name=$input" }
        value = input
    }
}
