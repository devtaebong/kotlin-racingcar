package racingcar.domain

class Car(
    val name: CarName,
) {
    var distance: Int = 0
        private set

    constructor(name: CarName, distance: Int) : this(name) {
        require(distance >= 0) { "거리는 0 이상이어야 합니다. input = $distance" }
        this.distance = distance
    }

    fun move() {
        distance++
    }

    fun isMovable(number: Int): Boolean {
        return number >= MOVE_CONDITION
    }

    fun isMaxDistance(max: Int): Boolean {
        return distance == max
    }

    fun getCarNameValue(): String {
        return name.value
    }

    companion object {
        private const val MOVE_CONDITION = 4
    }
}
