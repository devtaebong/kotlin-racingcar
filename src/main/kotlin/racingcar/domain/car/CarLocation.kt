package racingcar.domain.car

class CarLocation(initValue: Int = DEFAULT_VALUE) {
    var value: Int = initValue
        private set

    fun increase() {
        value++
    }

    companion object {
        const val DEFAULT_VALUE = 0
    }
}
