package racingcar.domain

class GameRound(input: String?) {
    var count: Int
        private set

    init {
        requireNotNull(input)
        require(isNumeric(input))
        require(isPositive(input.toInt())) { "판수는 음수가 될 수 없습니다." }
        count = input.toInt()
    }

    fun proceed() {
        decrease()
    }

    private fun decrease() {
        check(count - 1 >= 0) { "더이상 남은 판수가 없습니다." }
        count--
    }

    private fun isNumeric(input: String) = input.toIntOrNull() != null

    private fun isPositive(value: Int) = value > 0
}
