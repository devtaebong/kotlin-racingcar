package racingcar.domain.car

@JvmInline
value class CarName(val value: String) {
    init {
        require(value.isNotBlank()) { "이름은 빈 값일 수 없습니다." }
        require(value.length <= 5) { "이름은 5자를 초과할 수 없습니다. name=$value" }
    }
}
