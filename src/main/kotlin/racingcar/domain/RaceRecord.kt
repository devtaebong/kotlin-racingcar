package racingcar.domain

class RaceRecord(race: Race) {
    val cars = race.cars.map { CarRecord(it.name, it.moveCount) }
}
