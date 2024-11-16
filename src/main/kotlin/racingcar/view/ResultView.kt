package racingcar.view

class ResultView {
    fun resolve(request: ResultViewAttribute) {
        request.cars.getLocations().forEach {
            println("-".repeat(it))
        }
        println()
    }
}
