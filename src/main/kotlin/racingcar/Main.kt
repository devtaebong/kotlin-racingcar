package racingcar

import racingcar.domain.RaceGame
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val randomNumberGenerator = RandomNumberGenerator()

    inputView.drawNamesInput()
    val names = readln().split(",")
    inputView.drawNumberOfTryInput()
    val numberOfTrys = readln().toInt()

    val raceGame = RaceGame.of(names, randomNumberGenerator)
    raceGame.doRaceGame(numberOfTrys)
    outputView.drawRaceGame(raceGame)
}
