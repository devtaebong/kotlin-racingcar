package racingcar.view.v2

class CarNameOutputView {
    fun outputWinners(winners: String) {
        require(winners.isNotBlank()) { "우승자는 반드시 존재해야 합니다." }
        println(winners + WINNER_MESSAGE)
    }

    companion object {
        private const val WINNER_MESSAGE = "가 최종 우승했습니다."
    }
}
