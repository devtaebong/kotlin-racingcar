package racingcar

import racingcar.domain.Input
import racingcar.domain.RacingGame
import racingcar.util.DefaultRandomGenerator
import racingcar.view.ResultView
import racingcar.view.ResultViewAttribute

object GameRunner {
    fun play(input: Input) {
        val racingGame = RacingGame(input.carCount, DefaultRandomGenerator())
        println("실행 결과")
        repeat(input.playCount) {
            racingGame.tryMove()
            ResultView().resolve(ResultViewAttribute(racingGame))
        }
    }
}
