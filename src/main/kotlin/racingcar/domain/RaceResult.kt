package racingcar.domain

class RaceResult(val raceRecords: List<RaceRecord>) {
    fun addRaceRecord(raceRecord: RaceRecord): RaceResult {
        return RaceResult(raceRecords + listOf(raceRecord))
    }

    fun getWinner(): List<CarRecord> {
        val cars = raceRecords.last().cars
        val max = cars.maxOf { it.moveCount }
        return cars.filter { it.moveCount == max }
    }
}
