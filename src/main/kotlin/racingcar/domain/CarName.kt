package racingcar.domain

class CarName(val value: String) {
    init {
        require(value.length <= MAX_NAME_LENGTH) { "자동차 이름은 5자 이하만 가능합니다. input = $value" }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
