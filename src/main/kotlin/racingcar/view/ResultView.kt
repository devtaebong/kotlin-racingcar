package racingcar.view

import racingcar.domain.history.CarHistories
import racingcar.domain.history.CarHistory

class ResultView {
    fun resolveTitle() {
        println("실행 결과")
    }

    fun resolveCarsInfo(data: CarsInfoResultViewModel) {
        data.carsInfo.forEach { printCarHistories(it) }
    }

    fun resolveGameWinner(data: GameWinnerResultViewModel) {
        println("${data.winners.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun printCarHistories(carHistories: CarHistories) {
        carHistories.carHistories.forEach { printCarHistory(it) }
        println()
    }

    private fun printCarHistory(carHistory: CarHistory) {
        print("${carHistory.nameValue} : ")
        println("-".repeat(carHistory.locationValue))
    }
}
