package racingcar.domain.car

class Car(
    private val name: CarName,
    private val location: CarLocation,
) {
    fun move() {
        location.increase()
    }

    fun getLocationValue(): Int = location.value

    fun getNameValue(): String = name.value
}
