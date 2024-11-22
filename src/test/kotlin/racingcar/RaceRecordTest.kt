package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.domain.RaceRecord

class RaceRecordTest {
    @Test
    fun `RaceRecord는 race의 차량 목록을 기록한다`() {
        val race = Race(cars = listOf(Car("car1", 2), Car("car2", 3)))
        val raceRecord = RaceRecord(race)

        assertThat(raceRecord.cars.map { it.name }).containsExactly("car1", "car2")
        assertThat(raceRecord.cars.map { it.moveCount }).containsExactly(2, 3)
    }
}
