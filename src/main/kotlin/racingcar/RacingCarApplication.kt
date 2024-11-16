package racingcar

import racingcar.view.InputView

fun main() {
    GameRunner.play(InputView().parse())
}
