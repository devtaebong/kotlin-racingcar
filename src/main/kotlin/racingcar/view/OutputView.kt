package racingcar.view

class OutputView {
    fun print(number: Int) {
        println(MOVE_DISTANCE_SYMBOL.repeat(number))
    }

    companion object {
        private const val MOVE_DISTANCE_SYMBOL = "-"
    }
}
