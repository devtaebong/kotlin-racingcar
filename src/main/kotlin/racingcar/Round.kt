package racingcar

data class Round(
    private var value: Int,
) {
    init {
        require(value >= MIN_ROUND) { "라운드는 1 이상이어야 합니다." }
    }

    fun end() {
        value -= ROUND_END
    }

    fun isFinished(): Boolean {
        return value == ALL_ROUND_FINISHED
    }

    fun getRound(): Int {
        return value
    }

    companion object {
        private const val ALL_ROUND_FINISHED = 0
        private const val MIN_ROUND = 1
        private const val ROUND_END = 1
    }
}
