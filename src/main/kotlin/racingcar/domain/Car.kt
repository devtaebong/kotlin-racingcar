package racingcar.domain

class Car {
    var location: Int = 0
        private set

    fun move() {
        location++
    }
}
