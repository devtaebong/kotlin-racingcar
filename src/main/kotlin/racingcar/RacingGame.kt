package racingcar

import racingcar.view.CarInputView
import racingcar.view.CarOutputView
import racingcar.view.DisplayConstant.Companion.CAR_VIEW_MESSAGE
import racingcar.view.DisplayConstant.Companion.TRY_VIEW_MESSAGE

class RacingGame(
    private val inputView: CarInputView,
    private val outputView: CarOutputView,
) {
    fun start() {
        val carCount = inputView.inputView(CAR_VIEW_MESSAGE)
        val tryCount = inputView.inputView(TRY_VIEW_MESSAGE)

        val racingCars = Cars(List(carCount) { Car() }, RandomMovementHandler(SecureRandomGenerator()))

        for (i in 0 until tryCount) {
            racingCars.move()
        }
        outputView.outputView(racingCars.getCars())
    }
}
