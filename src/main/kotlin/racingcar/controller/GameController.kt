package racingcar.controller

import racingcar.domain.GameRound
import racingcar.domain.GameWinnerSelector
import racingcar.domain.RacingGame
import racingcar.domain.car.Cars
import racingcar.util.RandomGenerator
import racingcar.view.CarsInfoResultViewModel
import racingcar.view.GameWinnerResultViewModel
import racingcar.view.RacingGameInput
import racingcar.view.ResultView

class GameController {
    fun run(racingGameInput: RacingGameInput) {
        val cars = Cars.createCars(racingGameInput.carNames)
        val gameRounds = GameRound(racingGameInput.playCount)
        val racingGame = RacingGame(cars, gameRounds, RandomGenerator())
        val resultView = ResultView()

        resultView.resolveTitle()

        val gameResult = racingGame.play()
        val winners = GameWinnerSelector.decideWinners(gameResult)

        resultView.resolveCarsInfo(CarsInfoResultViewModel(racingGame.totalCarHistories))
        resultView.resolveGameWinner(GameWinnerResultViewModel(winners))
    }
}
