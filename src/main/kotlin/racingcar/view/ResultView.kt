package racingcar.view

class ResultView {
    fun resolveTitle() {
        println("실행 결과")
    }

    fun resolveCarsInfo(data: CarsInfoResultViewModel) {
        data.carsInfo.forEach {
            print("${it.first} : ")
            println("-".repeat(it.second))
        }
        println()
    }

    fun resolveGameWinner(data: GameWinnerResultViewModel) {
        println("${data.winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
