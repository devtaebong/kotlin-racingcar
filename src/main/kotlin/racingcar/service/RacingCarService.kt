package racingcar.service

import racingcar.domain.Cars
import racingcar.service.dto.Input
import racingcar.service.dto.Output
import kotlin.Int as Position
import kotlin.String as CarName

class RacingCarService {
    fun run(input: Input): Output {
        val cars = Cars.from(input.carNames)

        val racingHistory = (1..input.numberOfAttempts).map {
            cars.move()
            saveRacingHistory(cars)
        }

        return Output(
            cars = cars,
            numberOfAttempts = input.numberOfAttempts,
            racingHistory = racingHistory,
        )
    }

    private fun saveRacingHistory(cars: Cars): Map<CarName, Position> {
        return cars.associate { it.name to it.position }
    }
}
