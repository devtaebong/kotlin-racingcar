package racingcar.ui

import racingcar.application.Car
import racingcar.application.Car.Companion.createDefault
import racingcar.application.DefaultCarMovementDecider
import racingcar.application.RaceBoard
import racingcar.application.RacingGame
import racingcar.ui.CarUiConstant.COMMA
import racingcar.ui.ResultView.printRacingResult
import racingcar.ui.ResultView.printWinners

fun main() {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val cars = inputCars()
    println("시도할 횟수는 몇 회인가요?")
    val moveTryCount =
        readlnOrNull()?.toInt() ?: throw IllegalArgumentException("The try count cannot be null")
    val racingGame = RacingGame(DefaultCarMovementDecider(), cars, RaceBoard())
    println("실행 결과")
    racingGame.race(moveTryCount)
    printRacingResult(racingGame.raceBoard)
    printWinners(cars)
}

private fun inputCars(): List<Car> {
    return readlnOrNull()?.takeIf { it.isNotBlank() }
        ?.split(COMMA)
        ?.map { createDefault(name = it) }
        ?: throw IllegalArgumentException("The name cannot be null or blank")
}
