package racingcar

import racingcar.domain.RacingGame
import racingcar.util.RandomGenerator
import racingcar.view.CarsInfoResultViewModel
import racingcar.view.GameWinnerResultViewModel
import racingcar.view.InputView
import racingcar.view.ResultView

object GameRunner {
    fun run() {
        val inputView = InputView()
        val racingGameInput = inputView.parse()
        val racingGame = RacingGame(racingGameInput, RandomGenerator())
        val resultView = ResultView()

        resultView.resolveTitle()

        while (!racingGame.isEnd()) {
            racingGame.play()
            resultView.resolveCarsInfo(CarsInfoResultViewModel(racingGame.getCarsInfo()))
        }

        resultView.resolveGameWinner(GameWinnerResultViewModel(racingGame.getWinnerInfo()))
    }
}
