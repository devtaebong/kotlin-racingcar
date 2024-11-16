package racingcar.domain

class Cars(
    private val cars: List<Car>,
) : List<Car> by cars {

    fun move() {
        cars.forEach(Car::move)
    }

    fun getWinners(): List<String> {
        val winnerCar = cars.maxOrNull() ?: return emptyList()
        return cars.filter { it >= winnerCar } // compareTo 메서드를 활용하기 위해 부등호 비교 처리
            .map { it.name }
    }

    companion object {
        fun from(carNames: List<String>): Cars {
            return carNames.map { Car(name = it) }
                .let(::Cars)
        }
    }
}
