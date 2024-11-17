package step3.domain

class Car(private var position: Position) {
    fun move(number: Int) {
        this.position = position.move(number)
    }

    fun position(): Position {
        return position
    }

    companion object {
        fun init(): Car {
            return Car(Position.init())
        }
    }
}
