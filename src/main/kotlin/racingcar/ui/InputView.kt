package racingcar.ui

import racingcar.application.CarManager
import racingcar.application.DefaultRandomGenerator
import racingcar.application.RacingProcessor
import racingcar.ui.ResultView.print

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val numberOfCars = readlnOrNull()?.toInt() ?: throw IllegalArgumentException()
    println("시도할 횟수는 몇 회인가요?")
    val moveTryCount = readlnOrNull()?.toInt() ?: throw IllegalArgumentException()

    val cars = CarManager.createCars(numberOfCars)
    val racingProcessor = RacingProcessor(DefaultRandomGenerator)
    println("실행 결과")
    repeat(moveTryCount) {
        print(cars = racingProcessor.race(cars))
    }
}
