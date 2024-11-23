package racingcars.util

import racingcars.Car

private const val MINIMUM_INPUT_NUMBER = 1
private const val REGEX_VALID_CHARACTERS = "^[a-zA-Z,]+$"
private const val MAXIMUM_CAR_NAME_LENGTH = 5

fun String?.validInputToInt(): Int {
    return this?.toIntOrNull()
        ?.takeIf { it >= MINIMUM_INPUT_NUMBER }
        ?: throw IllegalArgumentException("유효한 값을 입력해주세요")
}

fun String?.convertToListOrThrow(): List<String> =
    this?.takeIf { it.matches(Regex(REGEX_VALID_CHARACTERS)) }
        ?.split(",")
        ?.map { it.trim() }
        ?.takeIf { it.isNotEmpty() && it.all { name -> name.length <= MAXIMUM_CAR_NAME_LENGTH } }
        ?: throw IllegalArgumentException()

fun validateCarInput(
    carNameList: List<String>,
    numberOfCars: Int,
) {
    require(numberOfCars == carNameList.size) {
        "자동차 이름과 생성할 대수가 일치하지 않음"
    }
}

fun findWinners(racingCars: List<Car>): List<Car> {
    val maxPosition = racingCars.maxOfOrNull { it.position } ?: 0
    return racingCars.filter { it.position == maxPosition }
}