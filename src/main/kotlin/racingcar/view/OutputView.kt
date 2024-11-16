package racingcar.view

import racingcar.view.DisplayConstant.Companion.MOVE_DISTANCE_SYMBOL

class OutputView {
    fun print(number: Int) {
        println(MOVE_DISTANCE_SYMBOL.repeat(number))
    }
}
