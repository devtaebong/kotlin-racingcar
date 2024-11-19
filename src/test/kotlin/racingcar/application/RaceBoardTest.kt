package racingcar.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RaceBoardTest : StringSpec({
    "라운드 경주 결과를 추가한다" {
        val car1 = Car.createDefault("car1")
        val car2 = Car.createDefault("car2")
        val raceBoard = RaceBoard()
        car1.moveForward()

        raceBoard.recordRaceResultPerRound(listOf(car1, car2))

        raceBoard.raceResultPerRounds.size shouldBe 1
    }

    "라운드 경주 결과에 차의 위치가 기록된다" {
        val car1 = Car.createDefault("car1")
        val car2 = Car.createDefault("car2")
        val raceBoard = RaceBoard()
        // round 1
        car1.moveForward()
        raceBoard.recordRaceResultPerRound(listOf(car1, car2))
        // round 2
        car1.moveForward()
        raceBoard.recordRaceResultPerRound(listOf(car1, car2))

        raceBoard.raceResultPerRounds[0].carPositions.first { it.name == "car1" }.position shouldBe 1
        raceBoard.raceResultPerRounds[1].carPositions.first { it.name == "car1" }.position shouldBe 2
    }
})
