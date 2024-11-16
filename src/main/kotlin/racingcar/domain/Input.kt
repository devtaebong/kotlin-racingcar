package racingcar.domain

class Input(val carCountInput: String?, val playCountInput: String?) {
    val carCount: Int

    val playCount: Int

    init {
        require(!carCountInput.isNullOrBlank() && !playCountInput.isNullOrBlank()) { "초기화 설정값은 null이나 빈 값이 될 수 없습니다." }
        require(isNumeric(carCountInput, playCountInput))
        require(isPositive(carCountInput.toInt()) && isPositive(playCountInput.toInt()))

        carCount = carCountInput.toInt()
        playCount = playCountInput.toInt()
    }

    private fun isNumeric(
        carCount: String,
        playCount: String,
    ) = carCount.toIntOrNull() != null && playCount.toIntOrNull() != null

    private fun isPositive(value: Int) = value > 0
}
