package racingcar.service.dto

import racingcar.domain.Cars

data class Output(
    val cars: Cars,
    val numberOfAttempts: Int,
    val racingHistory: List<Map<String, Int>>,
)
