package racingcar.domain

class CarNames(val names: List<CarName>) {
    companion object {
        fun from(names: List<String>): CarNames {
            return CarNames(names.map { CarName(it) })
        }
    }
}
