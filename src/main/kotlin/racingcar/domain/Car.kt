package racingcar.domain

class Car(nameInput: String) {
    val name: CarName = CarName(nameInput)

    val location: CarLocation = CarLocation()

    fun move() {
        location.increase()
    }
}
